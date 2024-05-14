package app;

import java.sql.Connection;
import database.ConexionBD;
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
        // Obtener conexión a la base de datos
        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = conexionBD.getConnection();
        
        //Verificar si la conexión se estableció correctamente
        if (conexion != null) {
            System.out.println("Conexión exitosa a la base de datos.\n");
        } else {
            System.out.println("Error al conectar a la base de datos.\n");
            return; // Terminar la ejecución si no se pudo establecer la conexión
        }
        
       Scanner scanner = new Scanner(System.in);        
       Mensajes.mensajeInicio();
        
        boolean opcionSeleccionada = false;
        GestionPedido gestionPedido = new GestionPedido(conexionBD);

       
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