package data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import data.Mensajes;
import java.util.Scanner;
import logic.Bebida;
import logic.Cliente;
import logic.Comida;
import pago.PasarelaDePago;
import ticket.Ticket;
import database.ConexionBD;


/**
 * @author Alejandro García
 * Clase que gestiona el pedido realizado por un cliente.
 */
public class GestionPedido {
    
    private Cliente cliente;
    private GestionClientes gestionClientes;
    private ConexionBD conexionBD;
    
    /**
     * Constructor por defecto de la clase GestionPedido.
     */
    public GestionPedido(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    	gestionClientes = new GestionClientes();
    }
    
    /**
     * Método para realizar un pedido.
     */
    public void realizarPedido() {
    	Scanner scanner = new Scanner(System.in);

        while (true) {
            Mensajes.mensajeCliente();
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();
        
                if (opcion == 1) {
                    // Proceso para nuevo cliente
                    cliente = gestionClientes.crearCliente();
                    break;
                } else if (opcion == 2) {
                    // Proceso para cliente existente
                    System.out.println("Por favor, ingresa tu número de teléfono:");
                    String telefono = scanner.nextLine();
                    cliente = conexionBD.consultarClientePorTelefono(telefono);
                    if (cliente == null) {
                        System.out.println("Lo siento, no te hemos encontrado en nuestro sistema.");
                        System.out.println("¿Deseas registrarte como un nuevo cliente? (S/N)");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("S")) {
                            cliente = gestionClientes.crearCliente();
                        } else {
                            System.out.println("Gracias por visitarnos.");
                            return;
                        }
                    }
                    break;
                } else {
                    // Opción no válida
                    System.out.println("¡Opción seleccionada no válida! Por favor elija una de las opciones mostradas.\n");
                }
            } catch (InputMismatchException e) {
                // Captura la excepción si se ingresa un valor que no es un número
                System.out.println("¡Opción seleccionada no válida! Por favor ingrese un número válido.\n");
                scanner.nextLine();
            }
        }
        
        asociarClientePedido(cliente); 
        seleccionarProductos();
    }
    /**
     * Método para seleccionar los productos.
     */
    public void seleccionarProductos() {
        Scanner scanner = new Scanner(System.in);

        Mensajes.mostrarOpcionesComida();
        Comida comidaSeleccionada = seleccionarComida(scanner);
        int cantidadComida = cantidadComida(scanner);

        Mensajes.mostrarOpcionesBebida();
        Bebida bebidaSeleccionada = seleccionarBebida(scanner);
        int cantidadBebida = cantidadBebida(scanner);

        double precioComida = comidaSeleccionada.getPrecio() * cantidadComida;
        double precioBebida = bebidaSeleccionada.getPrecio() * cantidadBebida;
        
        Mensajes.combinacionElegida(cantidadComida, comidaSeleccionada, precioComida, cantidadBebida, bebidaSeleccionada, precioBebida);
        
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        
        String nombreArchivo = "pedido_" + cliente.getNombre().toLowerCase() + "_" + cliente.getApellidos().toLowerCase() + "_" + formatoFecha.format(fechaActual);
                
        PasarelaDePago.procesarPago(precioComida + precioBebida);
        
        Ticket.generarDocumento(cliente, comidaSeleccionada, cantidadComida, bebidaSeleccionada, cantidadBebida, precioComida + precioBebida, nombreArchivo);
                
       //scanner.close();  
    }

    /**
     * Método para seleccionar una comida.
     * 
     * @param scanner Scanner para leer la entrada del usuario.
     * @return Comida seleccionada por el usuario.
     */
    private Comida seleccionarComida(Scanner scanner) {
        Comida comidaSeleccionada = null;
        
        while (true) {
        	if (scanner.hasNext("[1-5]")) {
		        int opcionComida = scanner.nextInt();
		        scanner.nextLine();
		                
		        switch (opcionComida) {
		            case 1:
		                comidaSeleccionada = Comida.NAPOLITANA;
		                break;
		            case 2:
		                comidaSeleccionada = Comida.CARBONARA;
		                break;
		            case 3:
		                comidaSeleccionada = Comida.FUGAZZA;
		                break;
		            case 4:
		                comidaSeleccionada = Comida.CALZONE;
		                break;
		            case 5:
		                comidaSeleccionada = Comida.PROSCIUTTO;
		                break;
		        }
		        break;
	        } else {
	        	System.out.println("¡Opción seleccionada no válida! Por favor elija una de las opciones mostradas");
                Mensajes.mostrarOpcionesComida();
                scanner.next();
	        }
        }  
	    return comidaSeleccionada;
    }

    /**
     * Método para solicitar la cantidad de comida.
     * 
     * @param scanner Scanner para leer la entrada del usuario.
     * @return Cantidad de comida solicitada por el usuario.
     */
    private int cantidadComida(Scanner scanner) {
        while (true) {
            System.out.println("Ingrese la cantidad que desea (máximo 20):");
            
            if (scanner.hasNextInt()) {
                int cantidad = scanner.nextInt();
                scanner.nextLine();
                
                if (cantidad >= 1 && cantidad <= 20) {
                    return cantidad;
                } else {
                    System.out.println("¡Opción no admitida! Por favor ingrese una cantidad válida.");
                }
            } else {
                System.out.println("¡Opción no admitida! Por favor ingrese una cantidad válida.");
                scanner.next();
            }
        }
    }	        

    /**
     * Método para seleccionar una bebida.
     * 
     * @param scanner Scanner para leer la entrada del usuario.
     * @return Bebida seleccionada por el usuario.
     */
    private Bebida seleccionarBebida(Scanner scanner) {
        Bebida bebidaSeleccionada = null;
        
        while (true) {
        	 if (scanner.hasNext("[1-5]")) {       
		        int opcionBebida = scanner.nextInt();
		        scanner.nextLine();
        
		        switch (opcionBebida) {
		            case 1:
		                bebidaSeleccionada = Bebida.REFRESCO;
		                break;
		            case 2:
		                bebidaSeleccionada = Bebida.AGUA;
		                break;
		            case 3:
		                bebidaSeleccionada = Bebida.PERONI;
		                break;
		            case 4:
		                bebidaSeleccionada = Bebida.MORETTI;
		                break;
		            case 5:
		            	bebidaSeleccionada = Bebida.BATIDO;
		        }
		        break;
        	 } else {
                 System.out.println("¡Opción seleccionada no válida! Por favor elija una de las opciones mostradas");
                 Mensajes.mostrarOpcionesBebida();
                 scanner.next();
        	 }
        }
        return bebidaSeleccionada;
    }

    /**
     * Método para solicitar la cantidad de bebida.
     * 
     * @param scanner Scanner para leer la entrada del usuario.
     * @return Cantidad de bebida solicitada por el usuario.
     */
    private int cantidadBebida(Scanner scanner) {
        while (true) {
            System.out.println("Ingrese la cantidad que desea (máximo 20):");
            
            if (scanner.hasNextInt()) {
                int cantidad = scanner.nextInt();
                scanner.nextLine();
                
                if (cantidad >= 1 && cantidad <= 20) {
                    return cantidad;
                } else {
                    System.out.println("¡Opción no admitida! Por favor ingrese una cantidad válida.");
                }
            } else {
                System.out.println("¡Opción no admitida! Por favor ingrese una cantidad válida.");
                scanner.next();
            }
        }
    }
    
    /**
     * Método para asociar un cliente a un pedido.
     * 
     * @param cliente Cliente que realiza el pedido.
     */
    public void asociarClientePedido(Cliente cliente) {
        this.cliente = cliente;
    }
}