package com.mx.animalia.application.dao;

import com.mx.animalia.application.model.CiudadanoExistenteModel;
import com.mx.animalia.application.model.DatosRegistroCiudadano;

import java.util.HashMap;

public interface EliminaCiudadanosDao {
	HashMap<String, Object> eliminaCiudadanos(CiudadanoExistenteModel ciudadanoExistenteModel);
}
