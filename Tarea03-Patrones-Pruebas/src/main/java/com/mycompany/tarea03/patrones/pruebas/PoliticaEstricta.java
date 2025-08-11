/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea03.patrones.pruebas;

/**
 *
 * @author Norman
 */
import java.time.Duration;
import java.time.LocalDateTime;

public class PoliticaEstricta implements PoliticaReserva {
    @Override public boolean permiteCheckIn(LocalDateTime fh){
        int h = fh.getHour(); return h>=14 && h<=20;
    }
    @Override public boolean permiteCheckOut(LocalDateTime fh){ return fh.getHour()<=11; }
    @Override public boolean validarCancelacion(LocalDateTime inicio){
        long horas = Duration.between(LocalDateTime.now(), inicio).toHours();
        return horas >= 48; 
    }
}
