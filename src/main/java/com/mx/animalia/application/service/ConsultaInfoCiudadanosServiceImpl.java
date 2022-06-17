package com.mx.animalia.application.service;

import java.util.HashMap;

import com.mx.animalia.application.model.BusquedaCiudadanoModel;
import com.mx.animalia.application.model.CiudadanoDatosModel;
import com.mx.animalia.application.model.CiudadanoExistenteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.animalia.application.dao.ConsultaInfoCiudadanosDao;
import com.mx.animalia.application.model.ContenedorResponse;

@Service
public class ConsultaInfoCiudadanosServiceImpl implements ConsultaInfoCiudadanosService {

	@Autowired
	private ConsultaInfoCiudadanosDao consultaRolesCiudadanosDao;
	
	@Override
	public ContenedorResponse<String> consultaRolCiudadanos() {
		HashMap<String, Object> resultados = new HashMap<String, Object>();
		ContenedorResponse<String> contenedor = new ContenedorResponse<>();
		resultados=consultaRolesCiudadanosDao.consultaRolCiudadanos();

		contenedor.setCodigo(200L);
		contenedor.setData(resultados.get("resultado").toString());
		
		return contenedor;
	}

	@Override
	public ContenedorResponse<?> consultaCiudadanosPorId(CiudadanoExistenteModel ciudadanoExistenteModel) {
		HashMap<String, Object> resultados = new HashMap<String, Object>();
		ContenedorResponse<String> contenedor = new ContenedorResponse<>();
		resultados=consultaRolesCiudadanosDao.consultaCiudadanosPorId(ciudadanoExistenteModel);

		contenedor.setCodigo(200L);
		contenedor.setData(resultados.get("resultado").toString());

		return contenedor;
	}

	@Override
	public ContenedorResponse<?> busquedaCiudadanos(BusquedaCiudadanoModel busquedaCiudadanoModel) {
		HashMap<String, Object> resultados = new HashMap<String, Object>();
		ContenedorResponse<String> contenedor = new ContenedorResponse<>();
		resultados=consultaRolesCiudadanosDao.busquedaCiudadanos(busquedaCiudadanoModel);

		contenedor.setCodigo(200L);
		contenedor.setData(resultados.get("resultado").toString());

		return contenedor;
	}

	@Override
	public ContenedorResponse<?> actualizaInfoCiudadanos(CiudadanoDatosModel ciudadanoDatosModel) {
		HashMap<String, Object> resultados = new HashMap<String, Object>();
		ContenedorResponse<String> contenedor = new ContenedorResponse<>();
		resultados=consultaRolesCiudadanosDao.actualizaInfoCiudadanos(ciudadanoDatosModel);

		contenedor.setCodigo(200L);
		contenedor.setData(resultados.get("resultado").toString());

		return contenedor;
	}

}
