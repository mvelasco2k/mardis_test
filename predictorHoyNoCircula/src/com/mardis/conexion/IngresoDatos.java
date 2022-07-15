/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mardis.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author mat-i
 */
public class IngresoDatos {
    
    public void insertar(String placa, String fecha, String hora, boolean resultado){
        try{
            //Conexion con = new Conexion();
            //con.establecerConexion();
            Connection con = Conexion.establecerConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO predicciones (placa, fecha, hora, resultado) VALUES (?,?,?,?)");
            ps.setString(1, placa);
            ps.setString(2, fecha);
            ps.setString(3, hora);
            ps.setString(4, String.valueOf(resultado));
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
