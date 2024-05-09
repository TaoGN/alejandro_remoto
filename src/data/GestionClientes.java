package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import logic.Cliente;

/**
 * @author Alejandro García
 * La clase GestionClientes proporciona métodos para gestionar la creación de clientes.
 * Permite la creación de objetos Cliente con información ingresada por el usuario.
 */
public class GestionClientes{
    
    private List<Cliente> clientes;

    public GestionClientes() {
        this.clientes = new ArrayList<>();
    }
    
    /**
     * Crea un nuevo cliente con la información ingresada por el usuario.
     *
     * @return El cliente creado.
     */
    public Cliente crearCliente() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Por favor ingrese su nombre:");
        String nombre = scanner.nextLine().toLowerCase();

        System.out.println("Por favor ingrese sus apellidos:");
        String apellidos = scanner.nextLine().toUpperCase();

        String telefono = validarTelefono(scanner);

        System.out.println("Por favor ingrese su dirección:");
        String direccion = scanner.nextLine();
        
        Cliente nuevoCliente = new Cliente(nombre, apellidos, new Date(), telefono, direccion, "");

        this.clientes.add(nuevoCliente);

        return nuevoCliente;
    }

    /**
     * Valida el formato del número de teléfono ingresado por el usuario.
     *
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     * @return El número de teléfono validado.
     */
    private String validarTelefono(Scanner scanner) {
        String telefono;
        
        do {
            System.out.println("Por favor ingrese su número de teléfono:");
            telefono = scanner.nextLine();
            
            try {
            	if (!esTelefonoValido(telefono)) {
            		throw new TelefonoInvalidoException("Número de teléfono no válido, el teléfono ha de tener una longitud de 9 dígitos y empezar por 6, 7, 8 o 9. Por favor, inténtelo de nuevo.");
            	}
            }catch (TelefonoInvalidoException e) {
            	System.out.println(e.getMessage());
            }
        }while (!esTelefonoValido(telefono));
        
        return telefono;
    }

    /**
     * Verifica si el formato del número de teléfono es válido.
     *
     * @param telefono El número de teléfono a validar.
     * @return true si el número de teléfono es válido, false de lo contrario.
     */
    private boolean esTelefonoValido(String telefono) {
        if (telefono.length() != 9) {
            return false;
        }

        char primerDigito = telefono.charAt(0);
        if (primerDigito != '6' && primerDigito != '7' && primerDigito != '8' && primerDigito != '9') {
            return false;
        }

        return true;
    }
    
    private static class TelefonoInvalidoException extends Exception {
        public TelefonoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }
}