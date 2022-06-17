package com.mx.animalia.application.service;

import com.mx.animalia.application.model.BusquedaCiudadanoModel;
import com.mx.animalia.application.model.CiudadanoDatosModel;
import com.mx.animalia.application.model.CiudadanoExistenteModel;
import com.mx.animalia.application.model.ContenedorResponse;

public interface ConsultaInfoCiudadanosService {
	ContenedorResponse<?> consultaRolCiudadanos();
	ContenedorResponse<?> consultaCiudadanosPorId(CiudadanoExistenteModel ciudadanoExistenteModel);
	ContenedorResponse<?> busquedaCiudadanos(BusquedaCiudadanoModel busquedaCiudadanoModel);
	ContenedorResponse<?> actualizaInfoCiudadanos(CiudadanoDatosModel ciudadanoDatosModel);
}
