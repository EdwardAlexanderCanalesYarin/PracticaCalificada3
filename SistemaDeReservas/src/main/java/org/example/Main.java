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