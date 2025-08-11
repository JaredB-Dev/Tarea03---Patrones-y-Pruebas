/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea03.patrones.pruebas;

/**
 *
 * @author Norman
 */
import java.time.LocalDateTime;

public interface PoliticaReserva {
    boolean permiteCheckIn(LocalDateTime fechaHora);
    boolean permiteCheckOut(LocalDateTime fechaHora);
    boolean validarCancelacion(LocalDateTime inicioReserva);
}
