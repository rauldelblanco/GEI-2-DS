package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AlquilerTest {

    Alquiler alquiler = new Alquiler();

    @BeforeEach
    void inicializar() {
        alquiler.getApartamentoList().clear();
    }


    @Test
    void ProbarBasicos() {
        Apartamento apartamento1 = new Apartamento(2333, 350, 50, 65, 35440, 2, 2);
        Apartamento apartamento2 = new Apartamento(2333, 340, 60, 75, 35441, 4, 1);
        assertNotEquals(apartamento1, apartamento2);
        assertNotEquals(apartamento1.hashCode(), apartamento2.hashCode());

        Apartamento apartamento3 = new Apartamento(2333, 350, 50, 65, 35440, 2, 2);
        Apartamento apartamento4 = new Apartamento(2336, 350, 50, 65, 35440, 2, 2);
        assertEquals(apartamento3, apartamento4);
        assertEquals(apartamento3.hashCode(), apartamento4.hashCode());

        assertThrows(IllegalArgumentException.class, () -> new Apartamento(-2335, 230, 70, 85, 35442, 6, 3));
        assertThrows(IllegalArgumentException.class, () -> new Apartamento(2335, 234, 70, 85, 354343442, 6, 1));
        assertThrows(IllegalArgumentException.class, () -> new Apartamento(2335, -234, 70, 85, 354343442, 6, 1));


    }

    @Test
    void CompHabitacionesTest() {

        Apartamento apartamento1 = new Apartamento(2333, 350, 50, 65, 35440, 2, 2);
        Apartamento apartamento2 = new Apartamento(2334, 340, 60, 75, 35441, 4, 1);
        Apartamento apartamento3 = new Apartamento(2335, 330, 70, 85, 35442, 6, 3);
        Apartamento apartamento4 = new Apartamento(2336, 320, 80, 95, 35443, 1, 4);

        CompHabitaciones CompHabitaciones = new CompHabitaciones();
        alquiler.setComparator(CompHabitaciones);
        alquiler.getApartamentoList().add(apartamento1);
        alquiler.getApartamentoList().add(apartamento2);
        alquiler.getApartamentoList().add(apartamento3);
        alquiler.getApartamentoList().add(apartamento4);
        Collections.sort(alquiler.getApartamentoList(), alquiler.getComparator());
        assertEquals(apartamento1, alquiler.getApartamentoList().get(1));
        assertEquals(apartamento2, alquiler.getApartamentoList().get(2));
        assertEquals(apartamento3, alquiler.getApartamentoList().get(3));
        assertEquals(apartamento4, alquiler.getApartamentoList().get(0));


    }

    @Test
    void CompBanosTest() {

        Apartamento apartamento1 = new Apartamento(2333, 350, 50, 65, 35440, 2, 2);
        Apartamento apartamento2 = new Apartamento(2334, 340, 60, 75, 35441, 4, 1);
        Apartamento apartamento3 = new Apartamento(2335, 330, 70, 85, 35442, 6, 3);
        Apartamento apartamento4 = new Apartamento(2336, 320, 80, 95, 35443, 1, 4);

        CompBanos CompBanos = new CompBanos();
        alquiler.setComparator(CompBanos);
        alquiler.getApartamentoList().add(apartamento1);
        alquiler.getApartamentoList().add(apartamento2);
        alquiler.getApartamentoList().add(apartamento3);
        alquiler.getApartamentoList().add(apartamento4);
        Collections.sort(alquiler.getApartamentoList(), alquiler.getComparator());
        assertEquals(apartamento1, alquiler.getApartamentoList().get(1));
        assertEquals(apartamento2, alquiler.getApartamentoList().get(0));
        assertEquals(apartamento3, alquiler.getApartamentoList().get(2));
        assertEquals(apartamento4, alquiler.getApartamentoList().get(3));


    }

    @Test
    void CompPrecioBaseTest() {

        Apartamento apartamento1 = new Apartamento(2333, 350, 50, 65, 35440, 2, 2);
        Apartamento apartamento2 = new Apartamento(2334, 340, 60, 75, 35441, 4, 1);
        Apartamento apartamento3 = new Apartamento(2335, 330, 70, 85, 35442, 6, 3);
        Apartamento apartamento4 = new Apartamento(2336, 320, 80, 95, 35443, 1, 4);

        CompPrecioBase CompBase = new CompPrecioBase();
        alquiler.setComparator(CompBase);
        alquiler.getApartamentoList().add(apartamento1);
        alquiler.getApartamentoList().add(apartamento2);
        alquiler.getApartamentoList().add(apartamento3);
        alquiler.getApartamentoList().add(apartamento4);
        Collections.sort(alquiler.getApartamentoList(), alquiler.getComparator());
        assertEquals(apartamento1, alquiler.getApartamentoList().get(3));
        assertEquals(apartamento2, alquiler.getApartamentoList().get(2));
        assertEquals(apartamento3, alquiler.getApartamentoList().get(1));
        assertEquals(apartamento4, alquiler.getApartamentoList().get(0));


    }

    @Test
    void CompPrecioTotalTest() {

        Apartamento apartamento1 = new Apartamento(2333, 390, 50, 65, 35440, 2, 2);
        Apartamento apartamento2 = new Apartamento(2334, 350, 60, 75, 35441, 4, 1);
        Apartamento apartamento3 = new Apartamento(2335, 360, 70, 85, 35442, 6, 3);
        Apartamento apartamento4 = new Apartamento(2336, 370, 80, 95, 35443, 1, 4);

        // 440 410 430 450

        CompPrecioTotal CompPrecioTotal = new CompPrecioTotal();
        alquiler.setComparator(CompPrecioTotal);
        alquiler.getApartamentoList().add(apartamento1);
        alquiler.getApartamentoList().add(apartamento2);
        alquiler.getApartamentoList().add(apartamento3);
        alquiler.getApartamentoList().add(apartamento4);
        Collections.sort(alquiler.getApartamentoList(), alquiler.getComparator());
        assertEquals(apartamento1, alquiler.getApartamentoList().get(2));
        assertEquals(apartamento2, alquiler.getApartamentoList().get(0));
        assertEquals(apartamento3, alquiler.getApartamentoList().get(1));
        assertEquals(apartamento4, alquiler.getApartamentoList().get(3));


    }

    @Test
    void CompNumReferenciaOrdenNatural() {

        Apartamento apartamento1 = new Apartamento(2333, 390, 50, 65, 35440, 2, 2);
        Apartamento apartamento2 = new Apartamento(2334, 350, 60, 75, 35441, 4, 1);
        Apartamento apartamento3 = new Apartamento(2335, 360, 70, 85, 35442, 6, 3);
        Apartamento apartamento4 = new Apartamento(2336, 370, 80, 95, 35443, 1, 4);


        alquiler.getApartamentoList().add(apartamento1);
        alquiler.getApartamentoList().add(apartamento2);
        alquiler.getApartamentoList().add(apartamento3);
        alquiler.getApartamentoList().add(apartamento4);
        Collections.sort(alquiler.getApartamentoList(), alquiler.getComparator());
        assertEquals(apartamento1, alquiler.getApartamentoList().get(0));
        assertEquals(apartamento2, alquiler.getApartamentoList().get(1));
        assertEquals(apartamento3, alquiler.getApartamentoList().get(2));
        assertEquals(apartamento4, alquiler.getApartamentoList().get(3));


    }
}