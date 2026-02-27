package dobledsoftware.proveedores.features;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.util.TimeZone;

@SpringBootApplication
@ComponentScan(basePackages = "dobledsoftware.proveedores")
public class ProveedoresApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(ProveedoresApplication.class, args);
	}

}
