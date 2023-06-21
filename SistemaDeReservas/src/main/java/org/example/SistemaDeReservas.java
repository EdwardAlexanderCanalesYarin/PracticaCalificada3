package org.example;

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

