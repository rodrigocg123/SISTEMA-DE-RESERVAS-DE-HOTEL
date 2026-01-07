package main.ReservasHoteles;

/*
Para que sirve esta clase:
    Representa una única reserva de hotel.

    Cada vez que alguien reserva una habitación → se crea un objeto Reserva.
*/
public class Reserva {
    /*
     * Estos atributos:
     * 
     * Identifican la habitación
     * 
     * Identifican al cliente
     * 
     * Indican duración
     * 
     * Permiten calcular el precio total
     */
    private int numeroHabitacion;
    private String dniCliente;
    private String nombreCliente;
    private int diasReserva;
    private double precioDia;

    /*
     * El constructor debe:
     * 
     * Recibir todos los datos excepto precioDia
     * 
     * Asignar precioDia de forma aleatoria entre 50 y 100
     */
    public Reserva(int numeroHabitacion, String dniCliente, String nombreCliente, int diasReserva) {
        this.numeroHabitacion = numeroHabitacion;
        this.dniCliente = dniCliente;
        this.nombreCliente = nombreCliente;
        this.diasReserva = diasReserva;
        // queremos que genere un precio aleatorio entre 50 y 100
        this.precioDia = (Math.random() * 51) + 50;
        /*
         * Porque:
         * 
         * El precio se asigna cuando se crea la reserva
         * 
         * No depende del usuario
         * 
         * Todas las reservas deben tener un precio desde el inicio
         */
    }

    public double precioTotal() {
        double precioTotal = diasReserva * precioDia;
        if (diasReserva >= 7) {

            precioTotal = precioTotal * 0.9;
        }
        return precioTotal;
    }

    // GETTERS Y SETTERS
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getDiasReserva() {
        return diasReserva;
    }

    public void setDiasReserva(int diasReserva) {
        this.diasReserva = diasReserva;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }

}
