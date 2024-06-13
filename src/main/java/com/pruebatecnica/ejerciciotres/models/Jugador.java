package com.pruebatecnica.ejerciciotres.models;

/**
 * Clase que representa un jugador en la lógica de negocio.
 */
public class Jugador {
    private String nombre;
    private String posicion;

    public Jugador(String nombre, String posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    @Override
    public String toString() {
        return nombre + " (" + posicion + ")";
    }
}

