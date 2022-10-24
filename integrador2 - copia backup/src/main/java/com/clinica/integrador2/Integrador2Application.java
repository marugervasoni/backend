package com.clinica.integrador2;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Integrador2Application {

	public static void main(String[] args) {

		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(Integrador2Application.class, args);
	}

	//TODO------------------------------------------------------------------------

	//FALTA
	//excepciones
	//manejar bien los response 200 y 400
	//login ??? VA??? NO ES NECESARIO PERO YA ESTA
	//implementar vistas: crear nuesvos js para cada objeto y linkear con index y los html restantes.
	//validaciones
	//id domicilio mejorarlo
	//tests de integracion
	//borrar comentarios
	//jwt???? VA???

}

