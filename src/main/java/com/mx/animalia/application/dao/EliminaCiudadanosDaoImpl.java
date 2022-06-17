package com.mx.animalia.application.dao;

import com.mx.animalia.application.conexion.Datos;
import com.mx.animalia.application.constants.ConstantsWS;
import com.mx.animalia.application.model.CiudadanoExistenteModel;
import com.mx.animalia.application.model.DatosRegistroCiudadano;
import com.mx.animalia.application.model.DatosRolCiudadanosModel;
import com.mx.animalia.application.model.RolCiudadanosModel;
import com.mx.animalia.application.utils.UtileriasHelper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class EliminaCiudadanosDaoImpl implements EliminaCiudadanosDao{

	DatosRolCiudadanosModel datosRolCiudadanosModel;
	RolCiudadanosModel rolCiudadanosModel =  new RolCiudadanosModel();
	Datos datos = new Datos();

	@Override
	public HashMap<String, Object> eliminaCiudadanos(CiudadanoExistenteModel ciudadanoExistenteModel) {
		HashMap<String, Object> resultadosSP = new HashMap<String, Object>();
		String sql = ConstantsWS.SP_ELIMINAR_CIUDADANO;
		UtileriasHelper utileriasHelper = new UtileriasHelper();
			String[] parametros={Integer.toString(ciudadanoExistenteModel.getIdCiudadano())};
			List<String[]> resultado= datos.ejecutaSP(sql,parametros);

			if(!resultado.isEmpty()){
				if(resultado.get(0)[0].contains("ok")){
					resultadosSP.put("resultado", "ok");
				}
			}else{
				resultadosSP.put("resultado", "Usuario no encontrado");
			}

		return resultadosSP;
	}

}
