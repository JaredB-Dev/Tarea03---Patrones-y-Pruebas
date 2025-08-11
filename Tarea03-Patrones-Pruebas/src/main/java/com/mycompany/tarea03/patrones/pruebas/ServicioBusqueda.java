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

public class ServicioBusqueda {
    private final RepositorioPropiedades repo;

    public ServicioBusqueda(RepositorioPropiedades repo) {
        if (repo == null) throw new IllegalArgumentException("repo null");
        this.repo = repo;
    }

    public List<Propiedad> buscarPorUbicacion(String ubicacion) {
        String u = (ubicacion == null) ? "" : ubicacion.trim();
        if (u.isEmpty()) throw new IllegalArgumentException("Ubicación no puede estar vacía");
        if (!soloLetrasYEspacios(u)) throw new IllegalArgumentException("Ubicación inválida");

        List<Propiedad> out = new ArrayList<>();
        for (Propiedad p : repo.getAll()) {
            if (p.getUbicacion().equalsIgnoreCase(u)) {
                out.add(p);
            }
        }
        return out;
    }

    public List<Propiedad> buscarPorPrecio(double min, double max) {
        if (min < 0 || max < 0) throw new IllegalArgumentException("Precio no puede ser negativo");
        if (min > max) throw new IllegalArgumentException("Rango invertido");

        List<Propiedad> out = new ArrayList<>();
        for (Propiedad p : repo.getAll()) {
            double pr = p.getPrecioNoche();
            if (pr >= min && pr <= max) out.add(p);
        }
        return out;
    }

    public List<Propiedad> buscarPorTipo(String tipo) {
        String t = (tipo == null) ? "" : tipo.trim();
        if (t.isEmpty()) throw new IllegalArgumentException("Tipo no puede estar vacío");

        // plural simple
        if (t.endsWith("s") || t.endsWith("S")) t = t.substring(0, t.length() - 1);
        t = t.toLowerCase();

        Tipo esperado;
        if (t.equals("casa")) esperado = Tipo.CASA;
        else if (t.equals("departamento")) esperado = Tipo.DEPARTAMENTO;
        else if (t.equals("habitacion")) esperado = Tipo.HABITACION;
        else throw new IllegalArgumentException("Tipo inválido");

        List<Propiedad> out = new ArrayList<>();
        for (Propiedad p : repo.getAll()) {
            if (p.getTipo() == esperado) out.add(p);
        }
        return out;
    }

    private boolean soloLetrasYEspacios(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(Character.isLetter(c) || Character.isSpaceChar(c))) return false;
        }
        return true;
    }
}
