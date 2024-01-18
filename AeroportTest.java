import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AeroportTest {

    @Test
    public void testNrAvioane() throws Exception {
        Aeroport aeroport = new Aeroport("AeroportTest", 5, 5);

        Avioane A1501 = new Avioane("RyanAir", "Boeing757", 100);
        Avioane A1601 = new Avioane("RyanAir", "AirBus", 100);
        Elicoptere E1101 = new Elicoptere("MAI", "BlackHawk", 12);

        aeroport.aterizeazaAeronava(A1501);
        aeroport.aterizeazaAeronava(A1601);
        aeroport.aterizeazaAeronava(E1101);

        assertEquals(3, aeroport.getNrAeronaveParcate());

        aeroport.decoleazaAeronava(A1501);

        assertEquals(2, aeroport.getNrAeronaveParcate());

    }
}