package com.mx.animalia.application.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mx.animalia.application.constants.ConstantsWS;
import com.mx.animalia.application.model.*;
import com.mx.animalia.application.utils.UtileriasHelper;
import org.springframework.stereotype.Repository;

import com.mx.animalia.application.conexion.Datos;

@Repository
public class ConsultaInfoCiudadanosDaoImpl implements ConsultaInfoCiudadanosDao {

	DatosRolCiudadanosModel datosRolCiudadanosModel;
	RolCiudadanosModel rolCiudadanosModel =  new RolCiudadanosModel();
	CiudadanoDatosModel ciudadanoDatosModel = new CiudadanoDatosModel();
	CiudadanosRolesModel ciudadanosRolesModel = new CiudadanosRolesModel();
	UtileriasHelper utileriasHelper = new UtileriasHelper();
	Datos datos = new Datos();
	@Override
	public HashMap<String, Object> consultaRolCiudadanos() {
		
		HashMap<String, Object> resultadosSP = new HashMap<String, Object>();
		String sql = ConstantsWS.SP_CONSULTA_CATALOGO_ROL_CIUDADANO;
		List<String[]> resultado= datos.ejecutaSP(sql);
		ArrayList<RolCiudadanosModel> r = new ArrayList<>();
		String respuesta="";

		if(!resultado.isEmpty()){
			for (int i=0; i<resultado.size();i++) {
				rolCiudadanosModel.setId(resultado.get(i)[0]);
				rolCiudadanosModel.setRol(resultado.get(i)[1]);
				rolCiudadanosModel.setDescripcion(resultado.get(i)[2]);
				rolCiudadanosModel.setEstatus(resultado.get(i)[3]);

				r.add(i,rolCiudadanosModel);
            }
		}

		String jsonRoles=utileriasHelper.convertObjectToJson(r);
		
		resultadosSP.put("resultado", r);
		
		return resultadosSP;
	}

	@Override
	public HashMap<String, Object> consultaCiudadanosPorId(CiudadanoExistenteModel ciudadanoExistenteModel) {
		HashMap<String, Object> resultadosSP = new HashMap<String, Object>();
		String[] parametros={Integer.toString(ciudadanoExistenteModel.getIdCiudadano())};
		String sql = ConstantsWS.SP_CONSULTA_CIUDADANO_POR_ID;
		List<String[]> resultado= datos.ejecutaSP(sql,parametros);

		ArrayList<CiudadanosRolesModel> rolesCiudadano=new ArrayList<>();

		if(!resultado.isEmpty()){

			String tieneMascota="";
			if(resultado.get(0)[7].equals("false")){
				tieneMascota="No";
			}else{
				tieneMascota="Si";
			}

			ciudadanosRolesModel.setIdRol(resultado.get(0)[8]);
			ciudadanosRolesModel.setIdRol1(resultado.get(0)[9]);
			ciudadanosRolesModel.setIdRol2(resultado.get(0)[10]);

			rolesCiudadano.add(0,ciudadanosRolesModel);

			ciudadanoDatosModel.setId(resultado.get(0)[0]);
			ciudadanoDatosModel.setNombreCiudadano(resultado.get(0)[1]);
			ciudadanoDatosModel.setTipoEspecieCiudadano(resultado.get(0)[2]);
			ciudadanoDatosModel.setDescCiudadano(resultado.get(0)[3]);
			ciudadanoDatosModel.setPesoEspecie(Double.parseDouble(resultado.get(0)[4]));
			ciudadanoDatosModel.setAlturapecie(Double.parseDouble(resultado.get(0)[5]));
			ciudadanoDatosModel.setUrlFotoCiudadano(resultado.get(0)[6]);
			ciudadanoDatosModel.setTieneMascota(tieneMascota);
			ciudadanoDatosModel.setRolesCiudadano(rolesCiudadano);

			String jsonCiudadano=utileriasHelper.convertObjectToJson(ciudadanoDatosModel);

			resultadosSP.put("resultado",jsonCiudadano);
		}else{
			resultadosSP.put("resultado","No existe un usuario con ese id");
		}

		return resultadosSP;
	}

	@Override
	public HashMap<String, Object> busquedaCiudadanos(BusquedaCiudadanoModel busquedaCiudadanoModel) {
		HashMap<String, Object> resultadosSP = new HashMap<String, Object>();
		ArrayList<CiudadanoDatosModel> r = new ArrayList<>();
		String[] parametros={busquedaCiudadanoModel.getNombre(),String.valueOf(busquedaCiudadanoModel.getIdEspecie()),busquedaCiudadanoModel.getDescCiudadano(),
				String.valueOf(busquedaCiudadanoModel.getIdRol()),busquedaCiudadanoModel.getTieneMascota()};
		String sql = ConstantsWS.SP_CONSULTA_CIUDADANO;
		List<String[]> resultado= datos.ejecutaSP(sql,parametros);

		if(!resultado.isEmpty()){
			for (int i=0; i<resultado.size();i++) {
				String tieneMascota="";
				if(resultado.get(0)[7].equals("false")){
					tieneMascota="No";
				}else{
					tieneMascota="Si";
				}
				ciudadanoDatosModel.setId(resultado.get(i)[0]);
				ciudadanoDatosModel.setNombreCiudadano(resultado.get(i)[1]);
				ciudadanoDatosModel.setTipoEspecieCiudadano(resultado.get(i)[2]);
				ciudadanoDatosModel.setDescCiudadano(resultado.get(i)[3]);
				ciudadanoDatosModel.setPesoEspecie(Double.parseDouble(resultado.get(i)[4]));
				ciudadanoDatosModel.setAlturapecie(Double.parseDouble(resultado.get(i)[5]));
				ciudadanoDatosModel.setUrlFotoCiudadano(resultado.get(i)[6]);
				ciudadanoDatosModel.setTieneMascota(tieneMascota);
				ciudadanoDatosModel.getRolesCiudadano().get(i).setIdRol(resultado.get(i)[8]);
				ciudadanoDatosModel.getRolesCiudadano().get(i).setIdRol1(resultado.get(i)[9]);
				ciudadanoDatosModel.getRolesCiudadano().get(i).setIdRol2(resultado.get(i)[10]);
				String jsonCiudadano=utileriasHelper.convertObjectToJson(ciudadanoDatosModel);
				r.add(i,ciudadanoDatosModel);
			}
			resultadosSP.put("resultado",r);
		}else{
			resultadosSP.put("resultado","No existe un usuario con ese id");
		}

		return resultadosSP;
	}

	@Override
	public HashMap<String, Object> actualizaInfoCiudadanos(CiudadanoDatosModel ciudadanoDatosModel) {
		HashMap<String, Object> resultadosSP = new HashMap<String, Object>();
		String sql = ConstantsWS.SP_UPDATE_CIUDADANO;
		UtileriasHelper utileriasHelper = new UtileriasHelper();
		int idRol=Integer.parseInt(ciudadanoDatosModel.getRolesCiudadano().get(0).getIdRol());
		int idRol1=Integer.parseInt(ciudadanoDatosModel.getRolesCiudadano().get(0).getIdRol1());
		int idRol2=Integer.parseInt(ciudadanoDatosModel.getRolesCiudadano().get(0).getIdRol2());

		if((idRol==0 && idRol1==0 && idRol2==6)
				||(idRol<4 && (idRol1>3&&idRol1<6) && idRol2==7)
				||(idRol<4 && idRol1<4 && idRol2==0)
				||(idRol==0 && (idRol1>3&&idRol1<6) && idRol2==0)
				||(idRol<4 && idRol1==0 && idRol2==0)
				||(idRol==0 && idRol1==0 && idRol2==0)){

			String rol = idRol==0 ? "7" : Integer.toString(idRol);
			String rol1 = idRol==0 ? "7" : Integer.toString(idRol1);
			String rol2 = idRol==0 ? "7" : Integer.toString(idRol2);

			if(rol.equals("7") && rol1.equals("7") && rol2.equals("7")){
				rol2="6";
			}

			String[] parametros={
					ciudadanoDatosModel.getId(),
					ciudadanoDatosModel.getNombreCiudadano(),
					ciudadanoDatosModel.getTipoEspecieCiudadano(),
					ciudadanoDatosModel.getDescCiudadano(),
					ciudadanoDatosModel.getPesoEspecie().toString(),
					ciudadanoDatosModel.getAlturapecie().toString(),
					ciudadanoDatosModel.getUrlFotoCiudadano(),
					ciudadanoDatosModel.getTieneMascota(),
					rol,
					rol1,
					rol2

			};
			List<String[]> resultado= datos.ejecutaSP(sql,parametros);
			ArrayList<RolCiudadanosModel> r = new ArrayList<>();
			String respuesta="";
			if(!resultado.isEmpty()){
				if(resultado.get(0)[0].contains("ok")){
					resultadosSP.put("resultado", "ok");
				}else{
					resultadosSP.put("resultado", resultado.get(0)[0]);
				}
			}else{
				resultadosSP.put("resultado", "Algo salio mal al actualizar el aspirante");
			}
		}else{
			resultadosSP.put("resultado", "La combinacion de roles no es valida "+ciudadanoDatosModel.getNombreCiudadano());
		}
		return resultadosSP;
	}

}
