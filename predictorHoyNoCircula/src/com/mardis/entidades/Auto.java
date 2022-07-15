/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mardis.entidades;

//Clase entidad que define los parámetros del vehiculo que vamos a usar para el análisis
public class Auto {

    private String placa;
    private String fecha;
    private String hora;

    public Auto(String placa, String fecha, String hora) {
        this.placa = placa;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
