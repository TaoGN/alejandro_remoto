package app;

import data.GestionPedido;
import data.Mensajes;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Alejandro García
 * La clase Aplicacion representa la aplicación principal de la pizzería.
 * Permite a los usuarios interactuar con la aplicación, realizar pedidos y procesar pagos.
 */
public class Aplicacion {
    /**
     * Método principal de la aplicación.
     * Permite a los usuarios interactuar con la aplicación, realizar pedidos y procesar pagos.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);        
       Mensajes.mensajeInicio();
        
        boolean opcionSeleccionada = false;        
        GestionPedido gestionPedido = new GestionPedido();

        // Bucle principal para manejar las opciones del menú
        while (!opcionSeleccionada) {
            Mensajes.mensajeOpciones();
            
            try {
	            int seleccion = scanner.nextInt();
	            scanner.nextLine();
	
	            switch (seleccion) {
	            	case 1:
	            		Mensajes.informacion();
	            		break;
	                case 2:
	                	Mensajes.carta();
	                    break;
	                case 3:
	                	gestionPedido.realizarPedido();
	                    opcionSeleccionada = true; // Establecer la opción seleccionada como verdadera para salir del bucle
	                    break;
	                default:
	                    System.out.println("¡Opción seleccionada no válida! Por favor elija una de las opciones mostradas");
	                    break;
	            }    
            }catch (InputMismatchException e) {
	           System.out.println("Error: Ingrese un valor numérico válido.");
	           scanner.nextLine();
	        }
        }
        
        Mensajes.mensajeFin();  
        scanner.close();
    }
}