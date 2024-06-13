package com.pruebatecnica.ejerciciouno;

import java.util.logging.Level;
import java.util.logging.Logger;
import static com.pruebatecnica.utils.Constantes.MagicNumber.*;
import java.util.Scanner;

/**
 * Dado un número entero, lleve a cabo la siguientes condiciones: <br>
 * - Si es impar, imprimir "Quipux" <br>
 * - Si es par y está en el rango inclusivo de 2 y 5, imprima “No Quipux” <br>
 * - Si es par y está en el rango inclusivo de 6 y 20, imprima “Quipux” <br>
 * - Si es par y es mayor que 20, imprima “No Quipux” <br>
 */
public class EjercicioUno {
    public static final Logger logger = Logger.getLogger(EjercicioUno.class.getName());

    public static void main(String[] args) {
        logger.info("Introduce un número entero positivo:");

        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            int numero = Integer.parseInt(input);

            if (numero < UNO || numero > CIEN) {
                throw new IllegalArgumentException("El número debe estar entre 1 y 100.");
            }

            boolean esImpar = numero % DOS != CERO;
            boolean entreDosYCinco = numero >= DOS && numero <= CINCO;
            boolean entreSeisYVeinte = numero >= SEIS && numero <= VEINTE;
            boolean mayorQueVeinte = numero > VEINTE;

            if (esImpar) {
                logger.info("Quipux");
            } else if (entreDosYCinco) {
                logger.info("No Quipux");
            } else if (entreSeisYVeinte) {
                logger.info("Quipux");
            } else if (mayorQueVeinte) {
                logger.info("No Quipux");
            }

        } catch (NumberFormatException e) {
            logger.log(Level.SEVERE, "Error: La entrada no es un número entero.", e);
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
