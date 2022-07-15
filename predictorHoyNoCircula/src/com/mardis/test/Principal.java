/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mardis.test;

import com.mardis.conexion.Conexion;
import com.mardis.conexion.IngresoDatos;
import com.mardis.controlador.Predictor;
import com.mardis.entidades.Auto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author mat-i
 */
public class Principal {

    //CLASE EJECUTABLE
    public static void main(String[] args) {
        Auto vehiculo = null;
        Predictor predictor = new Predictor();
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        String placa = "";
        String fecha = "";
        String hora = "";
        boolean resultado;
        IngresoDatos datos = new IngresoDatos();

        //Conexion a la base de datos
        //Conexion conectar = new Conexion();
        //conectar.establecerConexion();
        //Connection con = Conexion.establecerConexion();
        //Válido para placas de automóviles y motos
        //Tanto placas antiguas como nuevas
        System.out.println("**** BIENVENIDO AL SISTEMA DE CONSULTA DE CIRCULACIÓN (HOY NO CIRCULA) ****");
        System.out.println("");
        do {
            System.out.println("Ingrese el número de la opción que desee seleccionar: ");
            System.out.println("1. Consultar");
            System.out.println("2. Salir");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();

            if (opcion == 1) {
                System.out.println("");
                System.out.print("Ingrese la placa completa del vehículo. Ejemplo: PPP0000 o PPP-0000: ");
                placa = entrada.next();
                System.out.print("Ingrese una fecha. Formato: (dia-mes-año). Ejemplo: 14-07-2022: ");
                fecha = entrada.next();
                System.out.print("Ingrese una hora. Formato: (00:00 hasta 24:00). Ejemplo: 13:30: ");
                hora = entrada.next();

                vehiculo = new Auto(placa, fecha, hora);
                resultado = predictor.verificar(vehiculo);

                //Insertamos los datos en la BD
                datos.insertar(placa, fecha, hora, resultado);

                if (resultado == true) {
                    System.out.println("****** Su vehículo puede transitar libremente. ******");
                } else {
                    System.out.println("****** Su vehículo no puede circular en el momento indicado ******");
                }
            }
            System.out.println("");
        } while (opcion != 2);
        System.out.println("Fin del sistema");
    }
}
