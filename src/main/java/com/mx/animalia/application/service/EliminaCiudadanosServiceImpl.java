package com.mx.animalia.application.service;

import com.mx.animalia.application.dao.AltaCiudadanosDao;
import com.mx.animalia.application.dao.EliminaCiudadanosDao;
import com.mx.animalia.application.model.CiudadanoExistenteModel;
import com.mx.animalia.application.model.ContenedorResponse;
import com.mx.animalia.application.model.DatosRegistroCiudadano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class EliminaCiudadanosServiceImpl implements EliminarCiudadanosService{

	@Autowired
	private EliminaCiudadanosDao eliminaCiudadanosDao;

	@Override
	public ContenedorResponse<?> eliminaCiudadanos(CiudadanoExistenteModel ciudadanoExistenteModel) {
		HashMap<String, Object> resultados = new HashMap<String, Object>();
		ContenedorResponse<String> contenedor = new ContenedorResponse<>();
		resultados=eliminaCiudadanosDao.eliminaCiudadanos(ciudadanoExistenteModel);

		contenedor.setCodigo(200L);
		contenedor.setData(resultados.get("resultado").toString());

		return contenedor;
	}
}
