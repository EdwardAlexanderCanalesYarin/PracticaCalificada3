# PracticaCalificada4
PREGUNTA 3
Asumimo que el horario de atención es de lunes a domingo de 8 a.m - 8 p.m

Dentro de la clase SistemaDeReserva se tiene el atributo Array_Reserva[][] de tipo boolean
Dicho array de orden 12x7 tiene el siguiente significado:
- Las filas representan las horas en que se está reservado
  fila 1: 8 - 9 
  fila 2: 9 - 10 
  ...
  fila 12: 19 - 20
- Las columnas representan el día de la semana en que se hizo la reservación (0-6)
   0: lunes, 1: martes, ..., 6: domingo

  package org.example;


// CLASE SISTEMA DE RESERVAS
public class SistemaDeReservas {
    String recurso;
    String hora;
    boolean Array_Reserva[][] = new boolean[12][7];
    // Array_Reserva[0][0] si es true, significa que la hora de 8 - 9 am del lunes está reservado
    // caso contrario no lo está
    // Array_Reserva[11][6] si es true, significa que la hora de 19 - 20 pm del domingo está reservado
    // caso contrario no lo está
    void LlenarArray(){
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 7; j++){
                Array_Reserva[i][j] = false;
            }
        }
    }
    String Equipment(String recurso_) {
        recurso = recurso_;
        return recurso;
    }
    // El metodo Hora
    String Hora_Dia(String h_inicio, String h_fin, String meridiano, int dia){
        if (Integer.parseInt(h_inicio) >= 8 & Integer.parseInt(h_inicio) <= 19 &
                Integer.parseInt(h_fin) >= 9 & Integer.parseInt(h_fin) <= 20 &
                Integer.parseInt(h_inicio) == Integer.parseInt(h_fin) + 1){
            hora = h_inicio + " - " + h_fin + " " + meridiano;    // por ejemplo 4 - 5 pm
            return hora;
        }
        return null;
    }
    boolean AulaReservada(String aulaReservada){
        if(aulaReservada == "SI") {return true;}
        else {return false;}
    }
    void reservar(String h_inicio, int dia){
        if (Integer.parseInt(h_inicio) >= 8 & Integer.parseInt(h_inicio) <= 19 & dia >= 0 & dia <= 6){
            Array_Reserva[Integer.parseInt(h_inicio)-8][dia] = true;
        }
    }
    boolean getCell(String h_inicio, int dia){
        return Array_Reserva[Integer.parseInt(h_inicio)-8][dia];
    }
}


// CLASE MAIN
package org.example;

public class Main {
    public static void main(String[] args) {
        SistemaDeReservas obj = new SistemaDeReservas();
        obj.reservar(String.valueOf(14),5); // reservo el día sábado de 2 a 3 pm
        System.out.println("RESERVAS DE LA SEMANA\n");
        System.out.println("            L       M       X       J       V       S       D\n");
        for(int i = 0; i < 12; i++){
            System.out.print(i+8 + " - " + (i+9) + "     ");
            for(int j = 0; j < 7; j++){
                if(obj.Array_Reserva[i][j]){
                    System.out.print("Sí      ");
                }else{
                    System.out.print("No      ");
                }
            }
            System.out.println("\n");
        }
    }
}

// TEST RESERVA 
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
