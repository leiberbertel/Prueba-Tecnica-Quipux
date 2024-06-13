package com.pruebatecnica.ejerciciotres.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Equipo en la lógica de negocio.
 */
public class Equipo {
    private String nombre;
    private String estadio;
    private int cantidadTitulos;
    private List<Jugador> titulares;
    private List<Jugador> suplentes;

    public Equipo(String nombre, String estadio, int cantidadTitulos) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.cantidadTitulos = cantidadTitulos;
        this.titulares = new ArrayList<>();
        this.suplentes = new ArrayList<>();
    }

    public void agregarTitular(Jugador jugador) {
        titulares.add(jugador);
    }

    public void agregarSuplente(Jugador jugador) {
        suplentes.add(jugador);
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstadio() { return estadio; }

    public int getCantidadTitulos() {
        return cantidadTitulos;
    }

    public List<Jugador> getTitulares() {
        return titulares;
    }

    public List<Jugador> getSuplentes() {
        return suplentes;
    }

    /**
     * Genera un reporte básico del equipo de fútbol.
     *
     * El reporte incluye el nombre del equipo, la cantidad de títulos ganados y la cantidad total de jugadores.
     *
     * @return una cadena de texto que contiene el reporte básico del equipo.
     *         El formato del reporte es el siguiente:
     *         - Nombre del equipo
     *         - Títulos ganados
     *         - Cantidad total de jugadores (titulares y suplentes)
     */
    public String reporteBasico() {
        return "Nombre del equipo: " + nombre + "\n" +
                "Títulos ganados: " + cantidadTitulos + "\n" +
                "Cantidad total de jugadores: " + (titulares.size() + suplentes.size());
    }

    /**
     * Genera un reporte detallado del equipo de fútbol.
     *
     * El reporte incluye el nombre del equipo, el listado de los jugadores titulares y suplentes con sus detalles.
     *
     * @return una cadena de texto que contiene el reporte detallado del equipo.
     *         El formato del reporte es el siguiente:
     *         - Nombre del equipo
     *         - Lista de jugadores titulares (cada uno en una nueva línea)
     *         - Lista de jugadores suplentes (cada uno en una nueva línea)
     */
    public String reporteDetallado() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("Nombre del equipo: ").append(nombre).append("\n");
        reporte.append("Titulares:\n");
        for (Jugador jugador : titulares) {
            reporte.append(" - ").append(jugador).append("\n");
        }
        reporte.append("Suplentes:\n");
        for (Jugador jugador : suplentes) {
            reporte.append(" - ").append(jugador).append("\n");
        }
        return reporte.toString();
    }
}

