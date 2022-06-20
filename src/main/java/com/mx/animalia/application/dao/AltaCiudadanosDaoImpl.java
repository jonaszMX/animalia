package com.mx.animalia.application.dao;

import com.mx.animalia.application.conexion.Datos;
import com.mx.animalia.application.constants.ConstantsWS;
import com.mx.animalia.application.model.CiudadanoDatosModel;
import com.mx.animalia.application.model.DatosRegistroCiudadano;
import com.mx.animalia.application.model.DatosRolCiudadanosModel;
import com.mx.animalia.application.model.RolCiudadanosModel;
import com.mx.animalia.application.utils.UtileriasHelper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class AltaCiudadanosDaoImpl implements AltaCiudadanosDao{

	DatosRolCiudadanosModel datosRolCiudadanosModel;
	RolCiudadanosModel rolCiudadanosModel =  new RolCiudadanosModel();
	Datos datos = new Datos();
	@Override
	public HashMap<String, Object> altaCiudadanos(DatosRegistroCiudadano datosRegistroCiudadano) {

		HashMap<String, Object> resultadosSP = new HashMap<String, Object>();
		ArrayList<String> r1 = new ArrayList<>();
		String sql = ConstantsWS.SP_INSERT_CIUDADANO;
		UtileriasHelper utileriasHelper = new UtileriasHelper();

		for(int i=0;i<datosRegistroCiudadano.getCiudadanosRequest().size();i++){

			int idRol=Integer.parseInt(datosRegistroCiudadano.getCiudadanosRequest().get(i).getRolesCiudadano().get(0).getIdRol());
			int idRol1=Integer.parseInt(datosRegistroCiudadano.getCiudadanosRequest().get(i).getRolesCiudadano().get(0).getIdRol1());
			int idRol2=Integer.parseInt(datosRegistroCiudadano.getCiudadanosRequest().get(i).getRolesCiudadano().get(0).getIdRol2());

			if((idRol==0 && idRol1==0 && idRol2==6)
					||(idRol<4 && (idRol1>3&&idRol1<6) && idRol2==7)
					||(idRol<4 && idRol1<4 && idRol2==0)
					||(idRol==0 && (idRol1>3&&idRol1<6) && idRol2==0)
					||(idRol<4 && idRol1==0 && idRol2==0)
					||(idRol==0 && idRol1==0 && idRol2==0)){

				String rol = idRol==0 ? "7" : Integer.toString(idRol);
				String rol1 = idRol1==0 ? "7" : Integer.toString(idRol1);
				String rol2 = idRol2==0 ? "7" : Integer.toString(idRol2);

				if(rol.equals("7") && rol1.equals("7") && rol2.equals("7")){
					rol2="6";
				}

				String[] parametros={
						datosRegistroCiudadano.getCiudadanosRequest().get(i).getNombreCiudadano(),
						datosRegistroCiudadano.getCiudadanosRequest().get(i).getTipoEspecieCiudadano(),
						datosRegistroCiudadano.getCiudadanosRequest().get(i).getDescCiudadano(),
						datosRegistroCiudadano.getCiudadanosRequest().get(i).getPesoEspecie().toString(),
						datosRegistroCiudadano.getCiudadanosRequest().get(i).getAlturapecie().toString(),
						datosRegistroCiudadano.getCiudadanosRequest().get(i).getUrlFotoCiudadano(),
						String.valueOf(datosRegistroCiudadano.getCiudadanosRequest().get(i).isTieneMascota()),
						rol,
						rol1,
						rol2
				};
				List<String[]> resultado= datos.ejecutaSP(sql,parametros);
				ArrayList<RolCiudadanosModel> r = new ArrayList<>();
				String respuesta="";
				String respuesta1="";
				if(!resultado.isEmpty()){
					if(resultado.get(0)[0].contains("ok")){
						respuesta1=(i+1) +" El ciudadano " + datosRegistroCiudadano.getCiudadanosRequest().get(i).getNombreCiudadano() + " se registro correctamente";
						r1.add(i,respuesta1);
						//resultadosSP.put("resultado", "El ciudadadano se registro correctamente" + (i+1));
					}else{
						respuesta1=(i+1) +" El ciudadano " + datosRegistroCiudadano.getCiudadanosRequest().get(i).getNombreCiudadano() + " " +resultado.get(0)[0];
						//resultadosSP.put("resultado", resultado.get(0)[0]);
						r1.add(i,respuesta1);
					}
				}else{
					resultadosSP.put("resultado", "Algo salio mal al registrar el usuario"+datosRegistroCiudadano.getCiudadanosRequest().get(i).getNombreCiudadano());
				}

			}else{
				resultadosSP.put("resultado", "La combinacion de roles no es valida "+datosRegistroCiudadano.getCiudadanosRequest().get(i).getNombreCiudadano());
			}
		}
		resultadosSP.put("resultado",r1);
		return resultadosSP;
	}

}
