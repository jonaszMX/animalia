package com.mx.animalia.application.dao;

import com.mx.animalia.application.model.DatosRegistroCiudadano;

import java.util.HashMap;

public interface AltaCiudadanosDao {
	HashMap<String, Object> altaCiudadanos(DatosRegistroCiudadano datosRegistroCiudadano);
}
