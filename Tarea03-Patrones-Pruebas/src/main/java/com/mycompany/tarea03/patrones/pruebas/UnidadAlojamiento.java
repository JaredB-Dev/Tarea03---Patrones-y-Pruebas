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
import java.util.Objects;

public abstract class UnidadAlojamiento {
    protected final String id;
    protected EstadoUnidad estado = EstadoUnidad.DISPONIBLE;
    protected PoliticaReserva politica;

    protected UnidadAlojamiento(String id, PoliticaReserva politica){
        this.id = id; setPolitica(politica);
    }
    public String getId(){ return id; }
    public EstadoUnidad getEstado(){ return estado; }
    public void setEstado(EstadoUnidad e){ this.estado = e; }
    public void setPolitica(PoliticaReserva p){ this.politica = Objects.requireNonNull(p); }
    public PoliticaReserva getPolitica(){ return politica; }

    public boolean reservar(LocalDateTime inicio, LocalDateTime fin){
        if (estado!=EstadoUnidad.DISPONIBLE) return false;
        if (fin.isBefore(inicio)) throw new IllegalArgumentException("Fechas inválidas");
        estado = EstadoUnidad.RESERVADA; return true;
    }
    public boolean validarCheckIn(LocalDateTime fh){ return politica.permiteCheckIn(fh); }
    public boolean validarCheckOut(LocalDateTime fh){ return politica.permiteCheckOut(fh); }
    public boolean cancelar(LocalDateTime inicio){ return politica.validarCancelacion(inicio); }
}