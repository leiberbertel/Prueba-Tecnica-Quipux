package com.pruebapractica.ejerciciodos;
import com.pruebatecnica.ejerciciodos.EjercicioDos;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Map;

import static com.pruebatecnica.utils.Constantes.MagicNumber.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase encargada de probar los métodos de la clase EjercicioDos
 */
class EjercicioDosTest {

    @InjectMocks
    private EjercicioDos ejercicioDos;

    @Test
    void testCreateHoursMap() {
        Map<Integer, String> result = EjercicioDos.createHoursMap();

        assertNotNull(result, "El mapa no debe ser nulo");
        assertEquals(12, result.size(), "El mapa debe contener 12 entradas");

        assertEquals("una", result.get(UNO), "La entrada para 1 debe ser 'una'");
        assertEquals("dos", result.get(DOS), "La entrada para 2 debe ser 'dos'");
        assertEquals("tres", result.get(TRES), "La entrada para 3 debe ser 'tres'");
        assertEquals("cuatro", result.get(CUATRO), "La entrada para 4 debe ser 'cuatro'");
        assertEquals("cinco", result.get(CINCO), "La entrada para 5 debe ser 'cinco'");
        assertEquals("seis", result.get(SEIS), "La entrada para 6 debe ser 'seis'");
        assertEquals("siete", result.get(SIETE), "La entrada para 7 debe ser 'siete'");
        assertEquals("ocho", result.get(OCHO), "La entrada para 8 debe ser 'ocho'");
        assertEquals("nueve", result.get(NUEVE), "La entrada para 9 debe ser 'nueve'");
        assertEquals("diez", result.get(DIEZ), "La entrada para 10 debe ser 'diez'");
        assertEquals("once", result.get(ONCE), "La entrada para 11 debe ser 'once'");
        assertEquals("doce", result.get(DOCE), "La entrada para 12 debe ser 'doce'");
    }

    @Test
    void testCreateSpecialMinutesMap() {
        Map<Integer, String> result = EjercicioDos.createSpecialMinutesMap();

        assertNotNull(result, "El mapa no debe ser nulo");
        assertEquals(3, result.size(), "El mapa debe contener 3 entradas");

        assertEquals("en punto", result.get(CERO), "La entrada para 0 debe ser 'en punto'");
        assertEquals("y cuarto", result.get(QUINCE), "La entrada para 15 debe ser 'y cuarto'");
        assertEquals("y media", result.get(TREINTA), "La entrada para 30 debe ser 'y media'");
    }

    @Test
    void testConvertTimeToWords_SpecialMinutes() {
        assertEquals("una en punto", EjercicioDos.convertTimeToWords(UNO, CERO));
        assertEquals("dos y cuarto", EjercicioDos.convertTimeToWords(DOS, QUINCE));
        assertEquals("tres y media", EjercicioDos.convertTimeToWords(TRES, TREINTA));
    }

    @Test
    void testConvertTimeToWords_RegularMinutes() {
        assertEquals("cuatro y cinco minutos", EjercicioDos.convertTimeToWords(CUATRO, 5));
        assertEquals("cinco y veinte minutos", EjercicioDos.convertTimeToWords(CINCO, 20));
        assertEquals("seis y cuarenta y cinco minutos", EjercicioDos.convertTimeToWords(SEIS, 45));
    }

    @Test
    void testGetMinuteWord_SingleDigits() {
        assertEquals("un", EjercicioDos.getMinuteWord(1));
        assertEquals("dos", EjercicioDos.getMinuteWord(2));
        assertEquals("tres", EjercicioDos.getMinuteWord(3));
        assertEquals("cuatro", EjercicioDos.getMinuteWord(4));
        assertEquals("cinco", EjercicioDos.getMinuteWord(5));
        assertEquals("seis", EjercicioDos.getMinuteWord(6));
        assertEquals("siete", EjercicioDos.getMinuteWord(7));
        assertEquals("ocho", EjercicioDos.getMinuteWord(8));
        assertEquals("nueve", EjercicioDos.getMinuteWord(9));
    }

    @Test
    void testGetMinuteWord_Teens() {
        assertEquals("diez", EjercicioDos.getMinuteWord(10));
        assertEquals("once", EjercicioDos.getMinuteWord(11));
        assertEquals("doce", EjercicioDos.getMinuteWord(12));
        assertEquals("trece", EjercicioDos.getMinuteWord(13));
        assertEquals("catorce", EjercicioDos.getMinuteWord(14));
        assertEquals("quince", EjercicioDos.getMinuteWord(15));
        assertEquals("dieciséis", EjercicioDos.getMinuteWord(16));
        assertEquals("diecisiete", EjercicioDos.getMinuteWord(17));
        assertEquals("dieciocho", EjercicioDos.getMinuteWord(18));
        assertEquals("diecinueve", EjercicioDos.getMinuteWord(19));
        assertEquals("veinte", EjercicioDos.getMinuteWord(20));
    }
}
