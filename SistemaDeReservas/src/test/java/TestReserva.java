import org.example.SistemaDeReservas;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestReserva {
    SistemaDeReservas objeto = new SistemaDeReservas();

    @Test
    public void testSinReservas(){
        for (int i = 0; i<12; i++) {
            for (int j = 0; j<7; j++) {
                assertEquals("", objeto.getCell(i, j), false);
            }
        }
    }
}
