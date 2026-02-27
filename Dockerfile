# Etapa 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar solo el pom.xml primero para aprovechar la caché de dependencias
COPY pom.xml .
# Descargar dependencias (esto se cacheará si el pom.xml no cambia)
RUN mvn dependency:go-offline -B

# Copiar el código fuente
COPY src ./src

# Compilar y empaquetar la aplicación (saltando tests para agilizar el build en CI/CD)
RUN mvn clean package -DskipTests

# Etapa 2: Run
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Crear un usuario no root por seguridad
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copiar el JAR generado desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto de la aplicación
EXPOSE 8090

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]
