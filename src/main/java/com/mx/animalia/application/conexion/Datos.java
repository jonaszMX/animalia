package com.mx.animalia.application.conexion;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class Datos {

    @Value("${database.driver}")
    private static String driver;
    @Value("${database.username}")
    private static String user;
    @Value("${database.password}")
    private static String pass;
    @Value("${database.url}")
    private static String url;

    private static Connection conexion;

    PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;

    public static Connection conector() {
        conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://34.134.3.159:3306/animaliabase","root","animaliaroot");

            if (conexion != null) {
                System.out.println("conexion establecida");
            }
        } catch (Exception ex) {
            System.out.println("Error de conexion:" + ex.toString());
        }
        return conexion;
    }

    private List convertir(ResultSet rs) {
        List<String[]> datos = null;
        String[] tupla = null;
        try {
            //rs.last();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numCols = rsmd.getColumnCount();
            datos = new ArrayList<String[]>();
            //rs.beforeFirst();
            while (rs.next()) {
                tupla = new String[numCols];
                for (int i = 0; i < numCols; i++) {
                    tupla[i] = rs.getString(i + 1);
                }
                datos.add(tupla);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return datos;

    }

    public List ejecutaSP(String sp) {
        List<String[]> d = new ArrayList<String[]>();
        String[] tupla;
        //conexion = null;

        String buscar = "call " + sp + "();";
        System.out.println(buscar);
        conexion = conector();
        try {
            sentencia_preparada = conexion.prepareStatement(buscar);
            resultado = sentencia_preparada.executeQuery();
            d = convertir(resultado);
            sentencia_preparada.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return d;
    }

    public List ejecutaSP(String sp, String[] parametros) {
        List<String[]> datos = new ArrayList<String[]>();
        String[] tupla;
        conexion = null;
        String aux = "";
        for (String parametro : parametros) {
            if (!parametro.equals("")) {
                aux += "'" + parametro + "',";
            } else {
                aux += "NULL,";
            }
        }
        if (aux != "") {
            aux = aux.substring(0, aux.length() - 1);
        }
        String buscar = "call " + sp + "(" + aux + ");";
        System.out.println(buscar);
        conexion = conector();
        try {
            sentencia_preparada = conexion.prepareStatement(buscar);
            resultado = sentencia_preparada.executeQuery();
            datos = convertir(resultado);
            sentencia_preparada.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return datos;
    }

}
