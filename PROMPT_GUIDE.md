# Guía de Desarrollo y Prompt Genérico para Proveedores-srv

Este documento define las pautas y estándares de desarrollo para el proyecto `Proveedores-srv`. Utiliza este contexto al solicitar nuevas funcionalidades o modificaciones.

## Prompt Genérico

"Actúa como un desarrollador experto en Spring Boot y Java. Necesito implementar la siguiente funcionalidad en el proyecto `Proveedores-srv`:

**[DESCRIBE AQUÍ TU REQUERIMIENTO FUNCIONAL]**

Por favor, sigue estrictamente estas pautas de desarrollo:

1.  **Internacionalización (i18n):**
    *   No hardcodees ningún mensaje o texto visible para el usuario en el código Java.
    *   Usa `ResourceBundle` para obtener los mensajes.
    *   Agrega las nuevas claves y sus traducciones al archivo `messages_en.properties` (y `messages_es.properties` si existiera/se requiriera).
    *   Si el mensaje ya existe, reutiliza la clave.

2.  **Constantes:**
    *   Evita "números mágicos" o cadenas repetidas en la lógica de negocio.
    *   Define constantes en la clase `ProveedorConstants` (o crea una nueva clase de constantes si es un dominio diferente) para valores fijos como nombres de auditoría, estados por defecto, configuraciones, etc.

3.  **Utilidades y Abstracciones:**
    *   Revisa si existen métodos en `ProveedorUtils` que puedan facilitar la tarea (ej. formateo de fechas, validaciones comunes).
    *   Utiliza los servicios abstractos disponibles (`AuditService`, `EmailService`) para funcionalidades transversales. No implementes lógica de auditoría o correo directamente en el servicio de negocio.

4.  **Estilo y Convenciones:**
    *   Mantén el código en inglés (nombres de variables, métodos, clases).
    *   Sigue la arquitectura en capas: Controller -> Service -> Repository -> Entity.
    *   Usa DTOs para la transferencia de datos y Mappers para convertir entre DTO y Entity.
    *   Maneja las excepciones de forma adecuada (ej. `try-catch` en el Controller o un `@ControllerAdvice`) y devuelve respuestas HTTP coherentes (400 para errores de validación, 404 para no encontrado, etc.).

5.  **Base de Datos:**
    *   Asegúrate de que los cambios en las entidades (`@Entity`) sean compatibles con la tabla existente `PROVEEDORES` en la base de datos (nombres de columnas, tipos de datos).
    *   Usa `validate` en `ddl-auto` para evitar modificaciones accidentales del esquema.

Por favor, genera el código necesario modificando los archivos existentes o creando nuevos según corresponda."
