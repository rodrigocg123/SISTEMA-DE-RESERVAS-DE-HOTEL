package main.ReservasHoteles;

import java.util.Scanner;

/*
    Qué es la clase Hotel?

    Es la clase principal

    Contiene el método main

    Es la única que:

    Usa Scanner

    Muestra mensajes por consola

    Gestiona el menú

    Llama a los métodos de GestionReservas

    IMPORTANTE!!!!

    NO contiene lógica, solo controla el flujo.
 */
public class Hotel {
    public static void main(String[] args) {
        // CREACION DE OBJETOS
        Scanner entrada = new Scanner(System.in);
        // este metodo sirve para manejar las reservas
        GestionReservas gestion = new GestionReservas();
        int opcion;
        do {
            // Creamos el menu con las opciones que queremos que realize
            System.out.println("-------Bienvenido a RODRAXHOTELGESTIONS:-------");
            System.out.println("1.Reservar Habitacion");
            System.out.println("2.Buscar reserva");
            System.out.println("3.Cancelar reserva");
            System.out.println("4.Listar reservas");
            System.out.println("0.Salir del menu");
            System.out.println("----------------------------------------------");
            // pedimos que introduzca la funcion que quiere realizar el usuario
            System.out.println("\nIntroduce la opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("\nDNI del cliente: ");
                    String dni = entrada.nextLine();

                    System.out.print("\nNombre del cliente: ");
                    String nombre = entrada.nextLine();

                    System.out.print("\nNúmero de habitación: ");
                    int numHab = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("\nDías de reserva: ");
                    int dias = entrada.nextInt();
                    entrada.nextLine();

                    if (gestion.añadirReserva(dni, nombre, numHab, dias)) {
                        System.out.println("----------------------------");
                        System.out.println("Reserva realizada con éxito");
                        System.out.println("----------------------------");
                    } else {
                        System.out.println("La habitación ya está ocupada");
                    }

                    break;
                case 2:
                    System.out.print("Introduce el DNI: ");
                    dni = entrada.nextLine();

                    Reserva reserva = gestion.BuscarReservaPorDNI(dni);
                    if (reserva != null) {
                        System.out.println(reserva);
                    } else {
                        System.out.println("No existe ninguna reserva con ese DNI");
                    }

                    break;
                case 3:
                    System.out.print("Introduce el DNI: ");
                    dni = entrada.nextLine();

                    if (gestion.cancelarReserva(dni)) {
                        System.out.println("Reserva cancelada correctamente");
                    } else {
                        System.out.println("No se encontró ninguna reserva con ese DNI");
                    }

                    break;
                case 4:
                    gestion.listarReservas();
                    break;

                case 0:
                    System.out.println("Saliendo del programa ...");
                    break;
            }
            // ejecutar opción
        } while (opcion != 0);
        /*
         * ¿Por qué do-while?
         * 
         * El menú se muestra al menos una vez
         * 
         * El programa se repite hasta que el usuario elija salir
         */

        entrada.close();
    }
}
