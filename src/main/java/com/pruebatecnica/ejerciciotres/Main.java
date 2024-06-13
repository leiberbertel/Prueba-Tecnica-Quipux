package com.pruebatecnica.ejerciciotres;

import com.pruebatecnica.ejerciciotres.models.Equipo;
import com.pruebatecnica.ejerciciotres.models.Jugador;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.pruebatecnica.utils.Constantes.MagicNumber.*;


/**
 * <p>Desarrolle un programa que permite ingresar la siguiente información de un
 * equipo de futbol:</p>
 *  - Nombre del equipo
 *  - Estadio del equipo
 *  - Cantidad de títulos
 *  - Lista de jugadores titulares (Cada uno con nombre y posición)
 *  - Lista de jugadores suplentes (Cada uno con nombre y posición)
 *
 * <p>Después de ingresar la información, el programa debe dar la opción para
 * generar algunos de estos reportes: </p>
 *
 *  <p>1. Reporte básico (Nombre del equipo, títulos ganados y cantidad total de
 *  jugadores) </p>
 *
 *  <p>2. Reporte detallado (Nombre del equipo, listado con el detalle de
 *  los titulares y todos los suplentes)</p>
 *
 * <p>Al seleccionar la opción deseada el programa debe imprimir la información que
 * se pide en cada reporte.</p>
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        logger.info("Ingrese el nombre del equipo:");
        String nombreEquipo = scanner.nextLine();

        logger.info("Ingrese el estadio del equipo:");
        String estadio = scanner.nextLine();

        logger.info("Ingrese la cantidad de títulos:");
        int cantidadTitulos = Integer.parseInt(scanner.nextLine());

        Equipo equipo = new Equipo(nombreEquipo, estadio, cantidadTitulos);

        // Ingresar jugadores titulares
        logger.info("Ingrese la cantidad de jugadores titulares:");
        int cantidadTitulares = Integer.parseInt(scanner.nextLine());
        for (int i = CERO; i < cantidadTitulares; i++) {
            logger.info("Ingrese el nombre del jugador titular " + (i + UNO) + ":");
            String nombreJugador = scanner.nextLine();
            logger.info("Ingrese la posición del jugador titular " + (i + UNO) + ":");
            String posicion = scanner.nextLine();
            equipo.agregarTitular(new Jugador(nombreJugador, posicion));
        }

        // Ingresar jugadores suplentes
        logger.info("Ingrese la cantidad de jugadores suplentes:");
        int cantidadSuplentes = Integer.parseInt(scanner.nextLine());
        for (int i = CERO; i < cantidadSuplentes; i++) {
            logger.info("Ingrese el nombre del jugador suplente " + (i + UNO) + ":");
            String nombreJugador = scanner.nextLine();
            logger.info("Ingrese la posición del jugador suplente " + (i + UNO) + ":");
            String posicion = scanner.nextLine();
            equipo.agregarSuplente(new Jugador(nombreJugador, posicion));
        }

        // Generar reportes
        logger.info("Seleccione el tipo de reporte:");
        logger.info("1. Reporte básico");
        logger.info("2. Reporte detallado");
        int opcion = Integer.parseInt(scanner.nextLine());

        if (opcion == UNO) {
            logger.info(equipo.reporteBasico());
        } else if (opcion == DOS) {
            logger.info(equipo.reporteDetallado());
        } else {
            logger.log(Level.SEVERE,"Opción no válida.");
        }

        scanner.close();
    }
}

