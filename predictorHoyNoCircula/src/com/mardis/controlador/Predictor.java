package com.mardis.controlador;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.mardis.entidades.Auto;

public class Predictor {

    //Fecha (dd-MM-yyyy)
    public int diaDeLaSemana(String fecha) {

        String partes[] = fecha.split("-");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);

        TimeZone timezone = TimeZone.getDefault();
        Calendar calendar = new GregorianCalendar(timezone);
        calendar.set(ano, mes - 1, dia);

        //Con la fecha procesada nos interesa obtener únicamente el dia para saber si puede o no circular
        int diaHoyNoCircula = calendar.get(Calendar.DAY_OF_WEEK);
        return diaHoyNoCircula;

        /*Retorna un número que representa lo siguiente:
		 * 1 = Domingo
		 * 2 = Lunes
		 * 3 = Martes
		 * 4 = Míercoles
		 * 5 = Jueves
		 * 6 = Viernes
		 * 7 = Sábado
         */
    }

    //Formato de la hora (HH:mm)
    public boolean horaRestriccion(String hora) {

        String partes[] = hora.split(":");
        String numeroAComparar = partes[0] + partes[1];
        int hora_analizada = Integer.parseInt(numeroAComparar);

        //Verificamos si la hora ingresada esta dentro del rango del Hoy No Circula
        if ((hora_analizada >= 600 && hora_analizada <= 930) || (hora_analizada >= 1600 && hora_analizada <= 2100)) {
            return false; //False significa que no puede circular
        } else {
            return true; //True significa que si puede circular
        }

    }

    public boolean verificar(Auto a) {
        int ultimoDigito = 0;
        char ultimoCaracter = 'a';
        String convertir = "";

        int diaHoyNoCircula = diaDeLaSemana(a.getFecha()); //Obtenemos el dia de la fecha ingresada
        boolean horaHoyNoCircula = horaRestriccion(a.getHora()); //Obtenemos la respuesta a si dentro de la hora ingresada puede o no circular

        ultimoCaracter = a.getPlaca().charAt(a.getPlaca().length() - 1);

        //Las placas de motos tienen una particularidad, terminan en una letra y no en un dígito
        //En caso que se ingresara una placa de moto, el algoritmo debe validar el digito que esta antes de dicha letra
        //Si se trata de la placa de un carro entonces toma el último dígito y lo valida
        if (Character.isLetter(ultimoCaracter)) {
            ultimoCaracter = a.getPlaca().charAt(a.getPlaca().length() - 2);
            convertir = String.valueOf(ultimoCaracter);
            ultimoDigito = Integer.parseInt(convertir);
        } else {
            convertir = String.valueOf(ultimoCaracter);
            ultimoDigito = Integer.parseInt(convertir);
        }

        //Validación para Hoy No Circula
        if ((diaHoyNoCircula == 2) && (horaHoyNoCircula == false)) { //Regulación para el dia lunes
            if (ultimoDigito == 1 || ultimoDigito == 2) {
                return false;
            }
        } else if ((diaHoyNoCircula == 3) && (horaHoyNoCircula == false)) { //Regulación para el dia martes
            if (ultimoDigito == 3 || ultimoDigito == 4) {
                return false;
            }
        } else if ((diaHoyNoCircula == 4) && (horaHoyNoCircula == false)) { //Regulación para el día miércoles
            if (ultimoDigito == 5 || ultimoDigito == 6) {
                return false;
            }
        } else if ((diaHoyNoCircula == 5) && (horaHoyNoCircula == false)) { //Regulación para el día jueves
            if (ultimoDigito == 7 || ultimoDigito == 8) {
                return false;
            }
        } else if ((diaHoyNoCircula == 6) && (horaHoyNoCircula == false)) { //Regulación para el día viernes
            if (ultimoDigito == 9 || ultimoDigito == 0) {
                return false;
            }
        }

        return true;
    }
}
