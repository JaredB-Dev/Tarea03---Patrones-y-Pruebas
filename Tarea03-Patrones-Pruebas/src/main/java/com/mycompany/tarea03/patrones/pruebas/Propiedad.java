/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea03.patrones.pruebas;

/**
 *
 * @author Norman
 */
public class Propiedad {
    private final String id;
    private final String ubicacion;
    private final double precioNoche;
    private final Tipo tipo;

    public Propiedad(String id, String ubicacion, double precioNoche, Tipo tipo) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.precioNoche = precioNoche;
        this.tipo = tipo;
    }

    public String getId() { return id; }
    public String getUbicacion() { return ubicacion; }
    public double getPrecioNoche() { return precioNoche; }
    public Tipo getTipo() { return tipo; }
}
