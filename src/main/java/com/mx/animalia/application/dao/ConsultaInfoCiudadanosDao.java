package com.mx.animalia.application.dao;

import com.mx.animalia.application.model.BusquedaCiudadanoModel;
import com.mx.animalia.application.model.CiudadanoDatosModel;
import com.mx.animalia.application.model.CiudadanoExistenteModel;
import com.mx.animalia.application.model.ContenedorResponse;

import java.util.HashMap;

public interface ConsultaInfoCiudadanosDao {
	HashMap<String, Object> consultaRolCiudadanos();
	HashMap<String, Object> consultaCiudadanosPorId(CiudadanoExistenteModel ciudadanoExistenteModel);
	HashMap<String, Object> busquedaCiudadanos(BusquedaCiudadanoModel busquedaCiudadanoModel);
	HashMap<String, Object>actualizaInfoCiudadanos(CiudadanoDatosModel ciudadanoDatosModel);
}
