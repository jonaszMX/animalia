package com.mx.animalia.application.service;

import com.mx.animalia.application.model.ContenedorResponse;
import com.mx.animalia.application.model.DatosRegistroCiudadano;

public interface AltaCiudadanosService {
	ContenedorResponse<?> altaCiudadanos(DatosRegistroCiudadano datosRegistroCiudadano);
}
