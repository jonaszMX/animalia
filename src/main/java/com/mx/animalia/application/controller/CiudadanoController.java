package com.mx.animalia.application.controller;

import com.mx.animalia.application.model.*;
import com.mx.animalia.application.service.AltaCiudadanosService;
import com.mx.animalia.application.service.ConsultaInfoCiudadanosService;

import com.mx.animalia.application.service.EliminarCiudadanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class CiudadanoController {

	@Autowired
	AltaCiudadanosService a1ltaCiudadanosService;
	@Autowired
	EliminarCiudadanosService eliminarCiudadanosService;
	@Autowired
	private ConsultaInfoCiudadanosService consultaRolesCiudadanosService;

	    @PostMapping("${path.registro}")
		public ContenedorResponse<?> altaCiudadanos(
				@Valid @RequestBody DatosRegistroCiudadano datosRegistroCiudadano){
			ContenedorResponse<?> contenedor = new ContenedorResponse<>();
			contenedor=a1ltaCiudadanosService.altaCiudadanos(datosRegistroCiudadano);
			return contenedor;
		}
	    
	    @DeleteMapping("${path.elimina.ciudadano}")
		public ContenedorResponse<?> bajaCiudadanos(
				@Valid @RequestBody CiudadanoExistenteModel ciudadanoExistenteModel){
			ContenedorResponse<?> contenedor = new ContenedorResponse<>();
			contenedor=eliminarCiudadanosService.eliminaCiudadanos(ciudadanoExistenteModel);
			return contenedor;
	    }

		@GetMapping("${path.get.ciudadano}")
		public ContenedorResponse<?> consultaiudadanos(
				@Valid @RequestBody CiudadanoExistenteModel ciudadanoExistenteModel){
			ContenedorResponse<?> contenedor = new ContenedorResponse<>();
			contenedor=consultaRolesCiudadanosService.consultaCiudadanosPorId(ciudadanoExistenteModel);

			return contenedor;
		}

		@GetMapping("${path.get.roles}")
		public ContenedorResponse<?> RolCiudadanos(){
			ContenedorResponse<?> contenedor = new ContenedorResponse<>();
			contenedor=consultaRolesCiudadanosService.consultaRolCiudadanos();
			
			return contenedor;
		}

		@GetMapping("${path.get.ciudadanos}")
		public ContenedorResponse<?> busquedaCiudadanos(
				@Valid @RequestBody BusquedaCiudadanoModel busquedaCiudadanoModel){
			ContenedorResponse<?> contenedor = new ContenedorResponse<>();
			contenedor=consultaRolesCiudadanosService.busquedaCiudadanos(busquedaCiudadanoModel);

			return contenedor;
		}

		@PutMapping("${path.update.info.ciudadanos}")
		public ContenedorResponse<?> actualizaCiudadanos(
				@Valid @RequestBody CiudadanoDatosModel ciudadanoDatosModel){
			ContenedorResponse<?> contenedor = new ContenedorResponse<>();
			contenedor=consultaRolesCiudadanosService.actualizaInfoCiudadanos(ciudadanoDatosModel);

			return contenedor;
		}

}
