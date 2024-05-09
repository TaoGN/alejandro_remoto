package pago;

import java.util.InputMismatchException;
import java.util.Scanner;
import data.Mensajes;

/**
 * 
 * @author Alejandro García
 * Clase para gestionar el pago del pedido
 */
public class PasarelaDePago {

    public static void procesarPago(double importeTotal) {
        Scanner sc = new Scanner(System.in);

        boolean seleccionValida = false;

        while (!seleccionValida) {
            try {
                System.out.println("Selecciona la forma de pago \n 1. Efectivo \n 2. Tarjeta");
                int forma = sc.nextInt(); // Escoge la opcion de pago
                sc.nextLine();

                switch (forma) {
                    case 1:
                        pagoEnEfectivo(importeTotal, sc);
                        seleccionValida = true;
                        break;
                    case 2:
                        pagoConTarjeta(sc);
                        seleccionValida = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un valor numérico válido.");
                sc.nextLine();
            }
        }
        
        sc.close();
    }

    private static void pagoEnEfectivo(double importeTotal, Scanner sc) {
        do {
            try {
                System.out.println("Ha seleccionado pagar en efectivo \nPor favor indique la cantidad que va entregar");
                double cantidadEntrega = sc.nextDouble(); // Toma la cantidad que entrega el cliente para pagar en efectivo

                if (cantidadEntrega < importeTotal) {
                	System.out.println("Importe insuficiente. Por favor, asegúrese de entregar la cantidad correcta.\n");
                } else {

                double resultado = (cantidadEntrega - importeTotal);
                resultado = Math.round(resultado * 100.0) / 100.0;

                System.out.println("Su cambio es " + resultado + " euros");

                // Calculamos los billetes que vamos a entregar
                double[] valoresBilletes = {500, 200, 100, 50, 20, 10, 5};
                for (double valor : valoresBilletes) {
                    if (resultado >= valor) {
                        double cantidadBilletes = Math.floor(resultado / valor);
                        System.out.println("Número de billetes de " + valor + " euros: " + (int) cantidadBilletes);
                        resultado -= cantidadBilletes * valor;
                        resultado = Math.round(resultado * 100.0) / 100.0;
                    }
                }

                // Calculamos las monedas que vamos a entregar
                double[] valoresMonedas = {2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
                for (double valor : valoresMonedas) {
                    if (resultado >= valor) {
                        double cantidadMonedas = Math.floor(resultado / valor);
                        System.out.println("Número de monedas de " + valor + " euros: " + (int) cantidadMonedas);
                        resultado -= cantidadMonedas * valor;
                        resultado = Math.round(resultado * 100.0) / 100.0;
                    }
                }
                break; // Salir del bucle si la cantidad entregada es suficiente
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un valor numérico válido.");
                sc.nextLine();
            }
        } while (true);

        sc.close();
    }
    
    private static void pagoConTarjeta(Scanner sc) {
        String tarjeta = "";

        while (true) {
            Mensajes.mensajeTipoTarjeta();

            tarjeta = sc.nextLine();

            switch (tarjeta) {
                case "3":
                    validarTarjeta(sc, "American Express");
                    return;
                case "4":
                    validarTarjeta(sc, "Visa");
                    return;
                case "5":
                    validarTarjeta(sc, "MasterCard");
                    return;
                default:
                    System.out.println("La opción seleccionada no es válida.\n\nPor favor, seleccione una de las opciones propuestas.\n");
            }
        }
    }

    private static void validarTarjeta(Scanner sc, String tipoTarjeta) {
        boolean esValida = false;
        
        while (!esValida) {
            System.out.println("Por favor, introduzca el número de tarjeta " + tipoTarjeta + ":");
            String numeroTarjeta = sc.nextLine();
            
            switch (tipoTarjeta) {
                case "American Express":
                    esValida = numeroTarjeta.matches("[0-9]{15}");
                    break;
                case "Visa":
                    esValida = numeroTarjeta.matches("[0-9]{16}");
                    break;
                case "MasterCard":
                    esValida = numeroTarjeta.matches("[0-9]{16}");
                    break;
                default:
                    esValida = false;
                    break;
            }
            
            if (esValida) {
                System.out.println("Número de tarjeta " + numeroTarjeta + " es válido.\n");
            } else {
                System.out.println("Número de tarjeta " + numeroTarjeta + " no es válido. Por favor, inténtelo de nuevo.");
            }
        }
   }
    
}