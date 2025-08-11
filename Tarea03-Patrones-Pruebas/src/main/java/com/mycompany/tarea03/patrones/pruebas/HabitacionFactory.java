/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea03.patrones.pruebas;

/**
 *
 * @author Norman
 */
public class HabitacionFactory implements UnidadAlojamientoFactory {
    @Override public UnidadAlojamiento crearUnidad(String id){
        return new UnidadHabitacion(id, new PoliticaFlexible());
    }
}
