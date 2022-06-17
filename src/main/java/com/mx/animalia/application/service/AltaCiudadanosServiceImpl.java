package com.mx.animalia.application.service;

import com.mx.animalia.application.dao.AltaCiudadanosDao;
import com.mx.animalia.application.model.ContenedorResponse;
import com.mx.animalia.application.model.DatosRegistroCiudadano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AltaCiudadanosServiceImpl implements AltaCiudadanosService{

	@Autowired
	private AltaCiudadanosDao altaCiudadanosDao;
	
	@Override
	public ContenedorResponse<String> altaCiudadanos(DatosRegistroCiudadano datosRegistroCiudadano) {
		HashMap<String, Object> resultados = new HashMap<String, Object>();
		ContenedorResponse<String> contenedor = new ContenedorResponse<>();

		resultados=altaCiudadanosDao.altaCiudadanos(datosRegistroCiudadano);

		contenedor.setCodigo(200L);
		contenedor.setData(resultados.get("resultado").toString());
		
		return contenedor;
	}

}
