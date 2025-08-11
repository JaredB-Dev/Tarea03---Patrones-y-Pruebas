/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.tarea03.patrones.pruebas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class ServicioBusquedaTest {

    private ServicioBusqueda svc;

    @BeforeEach
    void setUp() {
        svc = new ServicioBusqueda(new RepositorioPropiedades());
        assertNotNull(svc); // extra assertion de sanidad
    }

    // BP1: Quito
    @Test
    void BP1_buscarPorUbicacion_Quito() {
        List<Propiedad> res = svc.buscarPorUbicacion("Quito");

        // IDs esperados según dataset del repositorio (orden estable)
        List<String> ids = res.stream().map(Propiedad::getId).collect(Collectors.toList());
        assertAll(
            () -> assertFalse(res.isEmpty(), "Debe encontrar propiedades"),
            () -> assertTrue(res.stream().allMatch(p -> p.getUbicacion().equalsIgnoreCase("Quito"))),
            () -> assertNotNull(res.get(0)),
            () -> assertIterableEquals(List.of("P1","P2","P5"), ids) // orden y contenido
        );
    }

    // BP2: ubicación vacía
    @Test
    void BP2_buscarPorUbicacion_Vacia() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> svc.buscarPorUbicacion(""));
        assertEquals("Ubicación no puede estar vacía", ex.getMessage());
    }

    // BP3: ubicación inválida (caracteres no válidos)
    @Test
    void BP3_buscarPorUbicacion_Invalida() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> svc.buscarPorUbicacion("@@r"));
        assertEquals("Ubicación inválida", ex.getMessage());
    }

    // BP4: rango válido [50,100]
    @Test
    void BP4_buscarPorPrecio_RangoValido() {
        List<Propiedad> res = svc.buscarPorPrecio(50, 100);
        assertAll(
            () -> assertFalse(res.isEmpty()),
            () -> assertTrue(res.stream().allMatch(p -> {
                double pr = p.getPrecioNoche();
                return pr >= 50 && pr <= 100;
            }))
        );
    }

    // BP5: precio negativo
    @Test
    void BP5_buscarPorPrecio_Negativo() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> svc.buscarPorPrecio(-50, 200));
        assertEquals("Precio no puede ser negativo", ex.getMessage());
    }

    // BP6: rango invertido
    @Test
    void BP6_buscarPorPrecio_RangoInvertido() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> svc.buscarPorPrecio(600, 200));
        assertEquals("Rango invertido", ex.getMessage());
    }

    // BP7: tipo "Casas" (plural)
    @Test
    void BP7_buscarPorTipo_Casas() {
        List<Propiedad> res = svc.buscarPorTipo("Casas");
        List<String> ids = res.stream().map(Propiedad::getId).collect(Collectors.toList());
        assertAll(
            () -> assertFalse(res.isEmpty()),
            () -> assertTrue(res.stream().allMatch(p -> p.getTipo() == Tipo.CASA)),
            () -> assertIterableEquals(List.of("P2","P4"), ids) // casas en el dataset
        );
    }

    // BP8: tipo inexistente
    @Test
    void BP8_buscarPorTipo_Invalido() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> svc.buscarPorTipo("Castillo"));
        assertEquals("Tipo inválido", ex.getMessage());
    }

    // BP9: tipo vacío
    @Test
    void BP9_buscarPorTipo_Vacio() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> svc.buscarPorTipo(" "));
        assertEquals("Tipo no puede estar vacío", ex.getMessage());
    }
}