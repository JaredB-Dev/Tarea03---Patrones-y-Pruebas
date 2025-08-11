/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea03.patrones.pruebas;

/**
 *
 * @author Norman
 */
import java.util.ArrayList;
import java.util.List;

public class RepositorioPropiedades {
    private final List<Propiedad> data = new ArrayList<>();

    public RepositorioPropiedades() {
        data.add(new Propiedad("P1","Quito", 60,  Tipo.HABITACION));
        data.add(new Propiedad("P2","Quito", 95,  Tipo.CASA));
        data.add(new Propiedad("P3","Guayaquil",150, Tipo.DEPARTAMENTO));
        data.add(new Propiedad("P4","Cuenca",  85,  Tipo.CASA));
        data.add(new Propiedad("P5","Quito",  200, Tipo.DEPARTAMENTO));
    }

    public List<Propiedad> getAll() {
        return new ArrayList<>(data);
    }
}