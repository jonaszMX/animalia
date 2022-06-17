package com.mx.animalia.application.service;

import com.mx.animalia.application.model.CiudadanoExistenteModel;
import com.mx.animalia.application.model.ContenedorResponse;
import com.mx.animalia.application.model.DatosRegistroCiudadano;

public interface EliminarCiudadanosService {
	ContenedorResponse<?> eliminaCiudadanos(CiudadanoExistenteModel ciudadanoExistenteModel);
}
