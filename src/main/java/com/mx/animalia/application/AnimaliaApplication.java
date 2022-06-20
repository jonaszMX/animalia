package com.mx.animalia.application;

import com.mx.animalia.application.model.ContenedorResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@ComponentScan("com.mx.animalia")
@SpringBootApplication
public class AnimaliaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimaliaApplication.class, args);
	}

	@GetMapping("/status")
	public ContenedorResponse<?> altaCiudadanos(){
		ContenedorResponse<?> contenedor = new ContenedorResponse<>();
		contenedor.setCodigo(200L);
		contenedor.setDescripcion("El servicio desplego de manera correcta.");
		contenedor.setError(false);
		return contenedor;
	}

}
