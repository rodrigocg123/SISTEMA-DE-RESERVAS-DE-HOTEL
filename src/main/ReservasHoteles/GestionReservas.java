package main.ReservasHoteles;

import java.util.ArrayList;

/*
¿Qué hace esta clase?

Es la encargada de manejar la lista de reservas:

Añadir

Buscar

Cancelar

Listar 
*/
public class GestionReservas {
    /*
     * -¿Por qué necesitamos este atributo?
     * 
     * Porque el programa debe:
     * 
     * Guardar reservas
     * 
     * Buscar reservas
     * 
     * Eliminar reservas
     * 
     * Listar reservas
     * 
     * -Todas estas operaciones necesitan una estructura donde almacenar los
     * datos.
     * 
     * -La estructura correcta es un ArrayList porque:
     * 
     * El número de reservas no es fijo
     * 
     * Se pueden añadir y eliminar fácilmente
     * 
     * Permite recorrer los elementos
     */
    private ArrayList<Reserva> reservas;
    /*
     * He añadido private:
     * 
     * Mejora encapsulación
     * 
     * Es buena práctica
     * 
     * Suma puntos
     */

    public GestionReservas() {
        // despues de crear este constructor vacio generamos una lista en la que ya si
        // que se pueden
        // añadir reservas
        reservas = new ArrayList<>();
    }

    public boolean añadirReserva(String dniCliente, String nombreCliente, int numeroHabitacion, int diasReserva) {
        /*
         * Se recorre el ArrayList
         * 
         * Se compara el numeroHabitacion
         */
        for (Reserva reserva : reservas) {
            if (reserva.getNumeroHabitacion() == numeroHabitacion) {
                // Si existe una reserva con ese número → no se puede reservar
                // no se crea nada simplemente se devuelve false
                return false;
            }
        }
        /*
         * Se comprueba si el DNI del cliente tiene alguna reserva y en el caso de que
         * la tenga
         * devuelve falso ya que su DNI ya aparece en la lista de reservas
         */
        if (BuscarReservaPorDNI(dniCliente) != null) {
            return false;
        }

        // Se crea un objeto Reserva
        Reserva nuevaReserva = new Reserva(numeroHabitacion, dniCliente, nombreCliente, diasReserva);
        // Se añade al ArrayList
        reservas.add(nuevaReserva);
        // Se devuelve true
        return true;
        /*
         * “Si la habitación no está reservada, creo un nuevo objeto Reserva, lo añado
         * al ArrayList y devuelvo true para indicar que la reserva se ha realizado
         * correctamente.”
         */
    }
    /*
     * “El método devuelve el objeto Reserva y es la clase Hotel la encargada de
     * mostrar su información por consola.”
     */

    public Reserva BuscarReservaPorDNI(String dniCliente) {
        // Recorre la lista de reservas
        for (Reserva reserva : reservas) {
            // Compara dniCliente
            if (reserva.getDniCliente().equals(dniCliente)) {
                /*
                 * Si coincide:
                 * 
                 * Devuelve la Reserva
                 */
                return reserva;
            }
        }
        /*
         * Si no encuentra:
         * 
         * Devuelve null
         */
        return null;
        /*
         * IMPORTANTE!!!!!!!!!!!
         * La clase Hotel será la encargada de:
         * 
         * Comprobar si es null
         * 
         * Mostrar los datos
         */
    }

    /*
     * Funcionamiento
     * 
     * Buscar la reserva por DNI
     * 
     * Si existe:
     * 
     * Se elimina del ArrayList
     * 
     * Devuelve true
     * 
     * Si no existe:
     * 
     * Devuelve false
     * 
     * 📌 Importante:
     * Se elimina el objeto Reserva, no solo el DNI.
     */
    public boolean cancelarReserva(String dniCliente) {
        // recorre el arrayList
        for (Reserva reserva : reservas) {
            // Se busca por DNI
            if (reserva.getDniCliente().equals(dniCliente)) {
                // si es igual se elimina el objeto Reserva
                reservas.remove(reserva);
                return true;
            }
        }
        return false;
    }

    /*
     * Objetivo del método listarReservas()
     * 
     * Recorrer todas las reservas almacenadas
     * 
     * Mostrar la información de cada una
     * 
     * Si no hay reservas, informarlo
     */
    public void listarReservas() {
        // Comprobar si la lista está vacía
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }
        /*
         * Explicación
         * 
         * isEmpty() → devuelve true si la lista no tiene elementos
         * 
         * return → evita seguir ejecutando el método
         */
        int numeroReserva = 1;
        for (Reserva reserva : reservas) {
            System.out.println("---------------------------");
            System.out.println("==== Reserva numero " + numeroReserva + " ====");
            System.out.println("---------------------------");
            System.out.println("Habitación: " + reserva.getNumeroHabitacion());
            System.out.println("Cliente: " + reserva.getNombreCliente());
            System.out.println("DNI: " + reserva.getDniCliente());
            System.out.println("Días de reserva: " + reserva.getDiasReserva());
            System.out.println(String.format("Precio total: %.2f", reserva.precioTotal()));

            numeroReserva++;
        }

    }

    public void mostrarReserva(String dniCliente) {
        // Busca la reserva por DNI
        Reserva reserva = BuscarReservaPorDNI(dniCliente);

        // Comprueba si la reserva existe
        if (reserva != null) {
            System.out.println("---------------------------");
            System.out.println("==== RESERVA ENCONTRADA ====");
            System.out.println("---------------------------");
            System.out.println("Habitación: " + reserva.getNumeroHabitacion());
            System.out.println("Cliente: " + reserva.getNombreCliente());
            System.out.println("DNI: " + reserva.getDniCliente());
            System.out.println("Días de reserva: " + reserva.getDiasReserva());
            System.out.println(String.format("Precio total: %.2f \u20AC", reserva.precioTotal()));
            System.out.println("---------------------------");
        } else {
            System.out.println("No existe ninguna reserva con ese DNI");
        }
    }

}
