package data;

import logic.Comida;
import logic.Bebida;

/**
 * @author Alejandro García
 * Clase que contiene métodos estáticos para mostrar mensajes en la consola.
 */
public class Mensajes {

    /**
     * Muestra por pantalla un mensaje de bienvenida al usuario.
     */
    public static void mensajeInicio() {
        System.out.println("<<<<< ¡Bienvenido a pizzeria Alessandro! >>>>>\n");
        System.out.println("¿Que desea?\n");
    }

    /**
     * Muestra por pantalla un mensaje de despedida al usuario.
     */
    public static void mensajeFin() {
        System.out.println("\n\tGracias por su visita\nEsperamos que disfrute de su elección\n\t   I.V.A. Incluido");
    }
    
    /**
     * Muestra por pantalla las opciones para que el cliente elija si es un nuevo cliente o no,
     * de esta manera guardará el cliente el la BD o no.
     */
    public static void mensajeCliente() {
    	System.out.println("Ha seleccionado realizar un pedido:\n");
    	System.out.println("¿Eres un nuevo cliente o has realizado algún pedido anteriormente?");
    	System.out.println("- Seleccione 1. Si eres nuevo cliente. \n- Seleccione 2. Si ya has realizado algún pedido anteriormente.");
    }

    /**
     * Muestra por pantalla las opciones disponibles para el usuario.
     */
    public static void mensajeOpciones() {
        System.out.println("- Seleccione 1 para ver información sobre nuestra pizzeria.");
        System.out.println("- Seleccione 2 para ver nuestra carta de productos.");
        System.out.println("- Seleccione 3 para realizar un pedido.");
    }
    
    /**
     * Muestra por pantalla las opciones de tarjeta disponibles que puede seleccionar el usuario.
     */
    public static void mensajeTipoTarjeta() {
        System.out.println("Ha seleccionado pagar con tarjeta.");
        System.out.println("- Ingrese 3 si va a pagar con American Express.");
        System.out.println("- Ingrese 4 si va a pagar con Visa.");
        System.out.println("- Ingrese 5 si va a pagar con MasterCard.");
    }

    /**
     * Muestra por pantalla la información detallada sobre la pizzería.
     */
    public static void informacion() {
        System.out.println("¡Bienvenidos a Alessandro Pizzeria!\n\n");
        System.out.println("En el corazón de nuestra cocina late la pasión por la auténtica tradición \n"
        		+ "italiana y el amor por los sabores que despiertan los sentidos. En Alessandro, cada \n"
        		+ "pizza es una obra maestra artesanal, creada con ingredientes frescos y cuidadosamente \n"
        		+ "seleccionados para ofrecerte una experiencia gastronómica inolvidable.\n\n");
        System.out.println("Nuestro nombre, Alessandro, es un homenaje a la pasión y dedicación que inspira \n"
        		+ "cada bocado que servimos. Desde la masa perfectamente crujiente hasta la \n"
        		+ "mezcla de quesos derretidos y los ingredientes frescos de temporada, cada pizza lleva \n"
        		+ "consigo el sabor y la esencia de la verdadera Italia.\n\n");
        System.out.println("En nuestro acogedor establecimiento, te invitamos a disfrutar de una atmósfera cálida y familiar, \n"
        		+ "donde cada visita se convierte en un momento para compartir, reír y saborear la vida. \n"
        		+ "Ya sea que te deleites con nuestras clásicas pizzas margarita y pepperoni, o te aventures a probar \n"
        		+ "nuestras innovadoras creaciones gourmet, estamos aquí para satisfacer tus antojos más exigentes.\n\n");
        System.out.println("Alessandro Pizzeria no es solo un lugar para comer, es un destino para los amantes de la buena \n"
        		+ "comida y la hospitalidad italiana. Te invitamos a unirte a nosotros en este viaje culinario \n"
        		+ "y descubrir el auténtico sabor de Italia, aquí mismo, en tu vecindario.\n\n");
        System.out.println("¡Bienvenidos a Alessandro Pizzeria, donde cada pizza cuenta una historia de pasión y sabor!\n");
    }

    /**
     * Muestra la carta de productos
     */
    public static void carta() {
        System.out.println("\nComida:\n");
    	System.out.println(Comida.NAPOLITANA.getNombre() + ", Calorías: " + Comida.NAPOLITANA.getCalorias() + " Calorías" + ", Vegano: " + (Comida.NAPOLITANA.getVegano() ? "Sí" : "No") + ", Precio: " + Comida.NAPOLITANA.getPrecio() + "€");
        System.out.println(Comida.CARBONARA.getNombre() + ", Calorías: " + Comida.CARBONARA.getCalorias() + " Calorías" + ", Vegano: " + (Comida.CARBONARA.getVegano() ? "Sí" : "No")  + ", Precio: " + Comida.CARBONARA.getPrecio() + "€");
        System.out.println(Comida.FUGAZZA.getNombre() + ", Calorías: " + Comida.FUGAZZA.getCalorias() + " Calorías" + ", Vegano: " + (Comida.FUGAZZA.getVegano() ? "Sí" : "No")  + ", Precio: " + Comida.FUGAZZA.getPrecio() + "€");
        System.out.println(Comida.CALZONE.getNombre() + ", Calorías: " + Comida.CALZONE.getCalorias() + " Calorías" + ", Vegano: " + (Comida.CALZONE.getVegano() ? "Sí" : "No")  + ", Precio: " + Comida.CALZONE.getPrecio() + "€");
        System.out.println(Comida.PROSCIUTTO.getNombre() + ", Calorías: " + Comida.PROSCIUTTO.getCalorias() + " Calorías" + ", Vegano: " + (Comida.PROSCIUTTO.getVegano() ? "Sí" : "No")  + ", Precio: " + Comida.PROSCIUTTO.getPrecio() + "€");
        System.out.println("\nBebida:\n");
        System.out.println(Bebida.REFRESCO.getNombre() + ", Gaseoso: " + (Bebida.REFRESCO.getGaseoso() ? "Sí" : "No") + ", Lácteo: " + (Bebida.REFRESCO.getLacteo() ? "Sí" : "No") + ", Medida: " + Bebida.REFRESCO.getMedida() + ", Precio: " + Bebida.REFRESCO.getPrecio() + "€");
        System.out.println(Bebida.AGUA.getNombre() + ", Gaseoso: " + (Bebida.AGUA.getGaseoso() ? "Sí" : "No") + ", Lácteo: " + (Bebida.AGUA.getLacteo() ? "Sí" : "No") + ", Medida: " + Bebida.AGUA.getMedida() + ", Precio: " + Bebida.AGUA.getPrecio() + "€");
        System.out.println(Bebida.PERONI.getNombre() + ", Gaseoso: " + (Bebida.PERONI.getGaseoso() ? "Sí" : "No") + ", Lácteo: " + (Bebida.PERONI.getLacteo() ? "Sí" : "No") + ", Medida: " + Bebida.PERONI.getMedida() + ", Precio: " + Bebida.PERONI.getPrecio() + "€");
        System.out.println(Bebida.MORETTI.getNombre() + ", Gaseoso: " + (Bebida.MORETTI.getGaseoso() ? "Sí" : "No") + ", Lácteo: " + (Bebida.MORETTI.getLacteo() ? "Sí" : "No") + ", Medida: " + Bebida.MORETTI.getMedida() + ", Precio: " + Bebida.MORETTI.getPrecio() + "€");
        System.out.println(Bebida.BATIDO.getNombre() + ", Gaseoso: " + (Bebida.BATIDO.getGaseoso() ? "Sí" : "No") + ", Lácteo: " + (Bebida.BATIDO.getLacteo() ? "Sí" : "No") + ", Medida: " + Bebida.BATIDO.getMedida() + ", Precio: " + Bebida.BATIDO.getPrecio() + "€\n");
    }

    /**
     * Muestra por pantalla las opciones de comida disponibles.
     */
    public static void mostrarOpcionesComida() {
        System.out.println("\nSelecciona entre una de nuestras opciones:\n");
        System.out.println("Marque 1 para: " + Comida.NAPOLITANA.getNombre() + ", Calorías: " + Comida.NAPOLITANA.getCalorias() + " Calorías" + ", Vegano: " + (Comida.NAPOLITANA.getVegano() ? "Sí" : "No") + ", Fecha de caducidad: " + Comida.NAPOLITANA.obtener_caducidad() + ", Precio: " + Comida.NAPOLITANA.getPrecio() + "€");
        System.out.println("Marque 2 para: " + Comida.CARBONARA.getNombre() + ", Calorías: " + Comida.CARBONARA.getCalorias() + " Calorías" + ", Vegano: " + (Comida.CARBONARA.getVegano() ? "Sí" : "No") + ", Fecha de caducidad: " + Comida.CARBONARA.obtener_caducidad()  + ", Precio: " + Comida.CARBONARA.getPrecio() + "€");
        System.out.println("Marque 3 para: " + Comida.FUGAZZA.getNombre() + ", Calorías: " + Comida.FUGAZZA.getCalorias() + " Calorías" + ", Vegano: " + (Comida.FUGAZZA.getVegano() ? "Sí" : "No") + ", Fecha de caducidad: " + Comida.FUGAZZA.obtener_caducidad()  + ", Precio: " + Comida.FUGAZZA.getPrecio() + "€");
        System.out.println("Marque 4 para: " + Comida.CALZONE.getNombre() + ", Calorías: " + Comida.CALZONE.getCalorias() + " Calorías" + ", Vegano: " + (Comida.CALZONE.getVegano() ? "Sí" : "No") + ", Fecha de caducidad: " + Comida.CALZONE.obtener_caducidad()  + ", Precio: " + Comida.CALZONE.getPrecio() + "€");
        System.out.println("Marque 5 para: " + Comida.PROSCIUTTO.getNombre() + ", Calorías: " + Comida.PROSCIUTTO.getCalorias() + " Calorías" + ", Vegano: " + (Comida.PROSCIUTTO.getVegano() ? "Sí" : "No") + ", Fecha de caducidad: " + Comida.PROSCIUTTO.obtener_caducidad()  + ", Precio: " + Comida.PROSCIUTTO.getPrecio() + "€");
    }

    /**
     * Muestra por pantalla las opciones de bebida disponibles.
     */
    public static void mostrarOpcionesBebida() {
        System.out.println("\nSeleccione una opción de bebida:");
        System.out.println("1. " + Bebida.REFRESCO.getNombre() + ", Gaseoso: " + (Bebida.REFRESCO.getGaseoso() ? "Sí" : "No") + ", Lácteo: " + (Bebida.REFRESCO.getLacteo() ? "Sí" : "No") + ", Medida: " + Bebida.REFRESCO.getMedida()  + ", Fecha de caducidad: " + Bebida.REFRESCO.obtener_caducidad() + ", Precio: " + Bebida.REFRESCO.getPrecio() + "€");
        System.out.println("2. " + Bebida.AGUA.getNombre() + ", Gaseoso: " + (Bebida.AGUA.getGaseoso() ? "Sí" : "No") + ", Lácteo: " + (Bebida.AGUA.getLacteo() ? "Sí" : "No") + ", Medida: " + Bebida.AGUA.getMedida()  + ", Fecha de caducidad: " + Bebida.AGUA.obtener_caducidad() + ", Precio: " + Bebida.AGUA.getPrecio() + "€");
        System.out.println("3. " + Bebida.PERONI.getNombre() + ", Gaseoso: " + (Bebida.PERONI.getGaseoso() ? "Sí" : "No") + ", Lácteo: " + (Bebida.PERONI.getLacteo() ? "Sí" : "No") + ", Medida: " + Bebida.PERONI.getMedida()  + ", Fecha de caducidad: " + Bebida.PERONI.obtener_caducidad() + ", Precio: " + Bebida.PERONI.getPrecio() + "€");
        System.out.println("4. " + Bebida.MORETTI.getNombre() + ", Gaseoso: " + (Bebida.MORETTI.getGaseoso() ? "Sí" : "No") + ", Lácteo: " + (Bebida.MORETTI.getLacteo() ? "Sí" : "No") + ", Medida: " + Bebida.MORETTI.getMedida()  + ", Fecha de caducidad: " + Bebida.MORETTI.obtener_caducidad() + ", Precio: " + Bebida.MORETTI.getPrecio() + "€");
        System.out.println("5. " + Bebida.BATIDO.getNombre() + ", Gaseoso: " + (Bebida.BATIDO.getGaseoso() ? "Sí" : "No") + ", Lácteo: " + (Bebida.BATIDO.getLacteo() ? "Sí" : "No") + ", Medida: " + Bebida.BATIDO.getMedida()  + ", Fecha de caducidad: " + Bebida.BATIDO.obtener_caducidad() + ", Precio: " + Bebida.BATIDO.getPrecio() + "€");
    }

    /**
     * Muestra por pantalla la combinación de comida y bebida seleccionada.
     *
     * @param cantidadComida Cantidad de comida seleccionada.
     * @param comidaSeleccionada Comida seleccionada.
     * @param precioComida Precio total de la comida seleccionada.
     * @param cantidadBebida Cantidad de bebida seleccionada.
     * @param bebidaSeleccionada Bebida seleccionada.
     * @param precioBebida Precio total de la bebida seleccionada.
     */
    public static void combinacionElegida(int cantidadComida, Comida comidaSeleccionada, double precioComida, 
            int cantidadBebida, Bebida bebidaSeleccionada, double precioBebida) {
        double total = precioComida + precioBebida;
        total = Math.round(total * 100.0) / 100.0; // Redondea 2 decimales
        System.out.println("\nCombinación elegida:\n");
        System.out.println("CANT.\tPRODUCTO\t\tPRECIO UD.\tTOTAL");
        System.out.println("=====   =========\t\t=========\t=====");
        System.out.println(cantidadComida + "\t" + comidaSeleccionada.getNombre() + "\t\t" + comidaSeleccionada.getPrecio() + " €\t\t" + precioComida + " €");
        System.out.println(cantidadBebida + "\t" + bebidaSeleccionada.getNombre() + "\t\t" + bebidaSeleccionada.getPrecio() + " €\t\t" + precioBebida + " €");
        System.out.println("TOTAL ----------------------------------------> " + (total) + " €\n");
    }
}