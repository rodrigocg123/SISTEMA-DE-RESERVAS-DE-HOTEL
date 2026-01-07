ENUNCIADOS 

#ReservasHoteles

Se pide diseñar y desarrollar una aplicación que represente un sistema de reservas de
hotel simplificado.

El sistema debe permitir reservar, buscar, cancelar y listar reservas utilizando una lista.
Se deberán desarrollar las clases necesarias para el manejo de los objetos Reserva y
GestionReservas, además de una clase Hotel que ejecute pruebas sobre la lista.
La clase Hotel será la única que realice entrada y salida de datos por consola,
mostrando un menú con las siguientes opciones:

 Reservar habitación
 Buscar reserva
 Cancelar reserva
 Listar reservas

Clases y atributos

Clase Reserva:

int numeroHabitacion;
String dniCliente;
String nombreCliente;
int diasReserva;
double precioDia;

Descripción de los atributos:

 numeroHabitacion: número de la habitación reservada.
 dniCliente: DNI del cliente.
 nombreCliente: nombre del cliente.
 diasReserva: número de días que durará la reserva.
 precioDia: precio en € por cada día de reserva. Se asignara de forma aleatoria
entre 50€ y 100€ en el constructor ( (Math.random() * 51)+50)

Método de la clase Reserva

double precioTotal()

Funcionamiento:
 Devolverá el precio de la reserva multiplicando el precio diario por el número de
días. Las reservas de más de 7 días tendrán un 10% de descuento.

Clase GestionReservas:

ArrayList&lt;Reserva&gt; reservas;

Esta clase se encargará de gestionar todas las reservas del hotel.

Métodos de la clase GestionReservas:

Agregar reserva
boolean agregarReserva(String dniCliente, String nombreCliente,
int numeroHabitacion, int diasReserva);

Funcionamiento:
Recoger el DNI y nombre del cliente, el número de habitación y los días de
reserva.
Verificar si la habitación ya está reservada.

Si no está reservada:
o Crear un objeto Reserva.
o Marcarla como reservada (reservada = true).
o Añadirla a la lista de reservas.
o Devolver true.

Si ya está reservada:
o Informar al usuario de que la habitación está ocupada.
o Devolver false.

Buscar reserva por DNI del cliente:

Reserva buscarReservaPorDNI(String dniCliente);

Funcionamiento:
 Recoger el DNI del cliente.
 Buscar en la lista de reservas una que coincida con ese DNI.
 Devolver la reserva encontrada y mostrar su información.
 Si no se encuentra, informar al usuario.

Cancelar reserva:

boolean cancelarReserva(String dniCliente);

Funcionamiento:
 Recoger el DNI del cliente.
 Buscar la reserva correspondiente.

 Si se encuentra:
o Eliminar la reserva de la lista.
o Devolver true.

 Si no se encuentra:
o Informar al usuario.
o Devolver false.

Listar reservas actuales:

void listarReservas();

Funcionamiento:
 Recorrer la lista de reservas.

 Mostrar la información de cada reserva:
o Número de habitación
o Nombre del cliente
o DNI
o Días de reserva
o Precio total de la reserva.