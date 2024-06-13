package com.pruebatecnica.ejerciciodos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.pruebatecnica.utils.Constantes.MagicNumber.*;

/**
 * <p> 2. Dado una hora en números, debemos convertirla en palabras de la forma:</p>
 *  6:00 → seis en punto
 *  6:02 → seis y dos minutos
 *  6:10 → seis y diez minutos
 *  6:30 → seis y media
 *  6:45 → seis y cuarenta y cinco minutos
 *  6:55 → seis y cincuenta y cinco minutos
 *
 *  <p>Escribe un programa que imprima el tiempo en palabras para la entrada dada en
 *  el formato mencionado arriba.</p>
 *
 *  <p>Formato de entrada </p>
 *      Se requieren dos líneas de entrada:
 *      H, representando las horas
 *      M, representando los minutos
 *
 *  <p>Requisitos</p>
 *      1 ≤ 𝐻 < 12
 *      0 ≤ 𝑀< 60
 *   <p>Formato de salida</p>
 *      Mostrar el tiempo en palabras
 *
 *  <p>Ejemplo entrada</p>
 *     2
 *     40
 *  <p>Ejemplo salida</p>
 *     dos y cuarenta minutos
 */
public class EjercicioDos {
    private static final Logger logger = Logger.getLogger(EjercicioDos.class.getName());
    private static final Map<Integer, String> HOURS_MAP = createHoursMap();
    private static final Map<Integer, String> SPECIAL_MINUTES_MAP = createSpecialMinutesMap();

    /**
     * Crea un mapa de horas con sus representaciones correspondientes en palabras en español.
     *
     * @return un mapa donde las claves son los valores de las horas (1-12) y los valores son sus representaciones en palabras en español.
     *         El mapa contiene las siguientes entradas:
     *         - 1: "una"
     *         - 2: "dos"
     *         - 3: "tres"
     *         - 4: "cuatro"
     *         - 5: "cinco"
     *         - 6: "seis"
     *         - 7: "siete"
     *         - 8: "ocho"
     *         - 9: "nueve"
     *         - 10: "diez"
     *         - 11: "once"
     *         - 12: "doce"
     */
    public static Map<Integer, String> createHoursMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(UNO, "una");
        map.put(DOS, "dos");
        map.put(TRES, "tres");
        map.put(CUATRO, "cuatro");
        map.put(CINCO, "cinco");
        map.put(SEIS, "seis");
        map.put(SIETE, "siete");
        map.put(OCHO, "ocho");
        map.put(NUEVE, "nueve");
        map.put(DIEZ, "diez");
        map.put(ONCE, "once");
        map.put(DOCE, "doce");
        return map;
    }

    /**
     * Crea un mapa de minutos especiales con sus representaciones correspondientes en palabras en español.
     *
     * @return un mapa donde las claves son los valores de minutos especiales (0, 15, 30) y los valores son sus representaciones en palabras en español.
     *         El mapa contiene las siguientes entradas:
     *         - 0: "en punto"
     *         - 15: "y cuarto"
     *         - 30: "y media"
     */
    public static Map<Integer, String> createSpecialMinutesMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(CERO, "en punto");
        map.put(QUINCE, "y cuarto");
        map.put(TREINTA, "y media");
        return map;
    }

    public static void main(String[] args) {
        logger.info("Introduce la hora (H):");
        try (Scanner scanner = new Scanner(System.in)) {
            int hour = scanner.nextInt();
            logger.info("Introduce los minutos (M):");
            int minute = scanner.nextInt();

            if (hour < CERO || hour >= VEINTICUATRO || minute < CERO || minute >= SESENTA) {
                throw new IllegalArgumentException("La hora debe estar entre 0 y 23 y los minutos entre 0 y 59.");
            }

            // Convertir formato de 24 horas a 12 horas
            int convertedHour = (hour == CERO || hour == DOCE) ? DOCE : hour % DOCE;
            String timeInWords = convertTimeToWords(convertedHour, minute);
            logger.info(timeInWords);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en la entrada la hora y minuto ingresado deben ser números enteros positivos: ", e);
        }
    }

    /**
     * Convierte un valor de hora y minutos dados en su representación correspondiente en palabras en español.
     *
     * @param hour el valor de la hora a convertir, que debe estar entre 1 y 12 inclusive.
     * @param minute el valor de los minutos a convertir, que debe estar entre 0 y 59 inclusive.
     * @return la representación en palabras en español del valor de la hora y los minutos dados.
     *         Si los minutos son 0, 15, 30, devuelve la representación especial correspondiente.
     *         En otros casos, devuelve la hora seguida de "y" y la representación en palabras de los minutos seguida de "minutos".
     */
    public static String convertTimeToWords(int hour, int minute) {
        String hourWord = HOURS_MAP.get(hour);

        if (SPECIAL_MINUTES_MAP.containsKey(minute)) {
            return hourWord + " " + SPECIAL_MINUTES_MAP.get(minute);
        } else {
            String minuteWord = getMinuteWord(minute);
            return hourWord + " y " + minuteWord + " minutos";
        }
    }

    /**
     * Convierte un valor de minutos dado en su representación correspondiente en palabras en español.
     *
     * @param minute el valor de los minutos a convertir, que debe estar entre 0 y 59 inclusive.
     * @return la representación en palabras en español del valor de los minutos dado.
     *         Si los minutos están entre 0 y 20, devuelve la palabra correspondiente al número.
     *         Si los minutos están entre 21 y 29, devuelve "veinti" seguido de la palabra correspondiente al valor de los minutos menos 20.
     *         Si los minutos son 30, devuelve "media".
     *         Si los minutos están entre 31 y 59, devuelve la palabra correspondiente al valor exacto de los minutos.
     *         Si los minutos están fuera del rango esperado, devuelve la representación en cadena del valor de los minutos.
     */
    public static String getMinuteWord(int minute) {
        if (minute <= VEINTE) {
            return switch (minute) {
                case UNO -> "un";
                case DOS -> "dos";
                case TRES -> "tres";
                case CUATRO -> "cuatro";
                case CINCO -> "cinco";
                case SEIS -> "seis";
                case SIETE -> "siete";
                case OCHO -> "ocho";
                case NUEVE -> "nueve";
                case DIEZ -> "diez";
                case ONCE -> "once";
                case DOCE -> "doce";
                case TRECE -> "trece";
                case CATORCE -> "catorce";
                case QUINCE -> "quince";
                case DIECISEIS -> "dieciséis";
                case DIECISIETE -> "diecisiete";
                case DIECIOCHO -> "dieciocho";
                case DIECINUEVE -> "diecinueve";
                case VEINTE -> "veinte";
                default -> Integer.toString(minute);
            };
        } else if (minute < TREINTA) {
            return "veinti" + getMinuteWord(minute - VEINTE);
        } else {
            return switch (minute) {
                case TREINTA_Y_UNO -> "treinta y uno";
                case TREINTA_Y_DOS -> "treinta y dos";
                case TREINTA_Y_TRES -> "treinta y tres";
                case TREINTA_Y_CUATRO -> "treinta y cuatro";
                case TREINTA_Y_CINCO -> "treinta y cinco";
                case TREINTA_Y_SEIS -> "treinta y seis";
                case TREINTA_Y_SIETE -> "treinta y siete";
                case TREINTA_Y_OCHO -> "treinta y ocho";
                case TREINTA_Y_NUEVE -> "treinta y nueve";
                case CUARENTA -> "cuarenta";
                case CUARENTA_Y_UNO -> "cuarenta y uno";
                case CUARENTA_Y_DOS -> "cuarenta y dos";
                case CUARENTA_Y_TRES -> "cuarenta y tres";
                case CUARENTA_Y_CUATRO -> "cuarenta y cuatro";
                case CUARENTA_Y_CINCO -> "cuarenta y cinco";
                case CUARENTA_Y_SEIS -> "cuarenta y seis";
                case CUARENTA_Y_SIETE -> "cuarenta y siete";
                case CUARENTA_Y_OCHO -> "cuarenta y ocho";
                case CUARENTA_Y_NUEVE -> "cuarenta y nueve";
                case CINCUENTA -> "cincuenta";
                case CINCUENTA_Y_UNO -> "cincuenta y uno";
                case CINCUENTA_Y_DOS -> "cincuenta y dos";
                case CINCUENTA_Y_TRES -> "cincuenta y tres";
                case CINCUENTA_Y_CUATRO -> "cincuenta y cuatro";
                case CINCUENTA_Y_CINCO -> "cincuenta y cinco";
                case CINCUENTA_Y_SEIS -> "cincuenta y seis";
                case CINCUENTA_Y_SIETE -> "cincuenta y siete";
                case CINCUENTA_Y_OCHO -> "cincuenta y ocho";
                case CINCUENTA_Y_NUEVE -> "cincuenta y nueve";
                default -> Integer.toString(minute);
            };
        }
    }
}