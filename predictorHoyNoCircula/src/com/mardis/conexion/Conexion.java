/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mardis.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mat-i
 */
public class Conexion {
    static Connection conectar = null;
    
    //Cambiar valores
    static String usuario = "user";
    static String constraseña = "1234";
    String bd = "registros";
    String ip = "localhost";
    String puerto = "1433";
    
    String cadena = "jdbc:sqlserver://"+ip+":"+puerto+"/"+bd;
    
    public static Connection establecerConexion(){
        try{
            
            String conexionUrl = "jdbc:sqlserver://DESKTOP-DS903BR;" //Cambiar el servidor
                + "database=registros;"
                + "user=user;"
                + "password=1234;"
                + "loginTimeout=30;";
            conectar = DriverManager.getConnection(conexionUrl,usuario,constraseña);
            System.out.println("Conexion a la base de datos Exitosa!!");
            
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return conectar;
    }
    /*public static Connection getConexion(){
        String conexionUrl = "jdbc:sqlserver://DESKTOP-DS903BR\\SQLEXPRESS;" //Cambiar el servidor
                + "database=registros;"
                + "user=user;"
                + "password=12345678;"
                + "loginTimeout=30;";
        
        try{
            Connection con = DriverManager.getConnection(conexionUrl);
            return con;
        }catch(SQLException ex){
            System.out.println(ex.toString());
            return null;
        }
    }*/
}
