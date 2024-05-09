package logic;

import java.util.Date;
import java.util.Calendar;

/**
 * @author Alejandro García
 * Esta clase representa un producto de bebida.
 * Extiende la clase Producto.
 */
public class Bebida extends Producto {
    // Atributos específicos de Bebida
    private boolean gaseoso;
    private boolean lacteo;
    private String medida;

    /**
     * Constructor de la clase Bebida.
     *
     * @param nombre   	El nombre del producto de bebida.
     * @param precio   	El precio del producto de bebida.
     * @param cantidad 	La cantidad seleccionada del producto de bebida.
     * @param estado
     * @param fecha_caducidad 	La fecha de caducidad del producto de bebida.
     * @param gaseoso 	Si el producto es gaseoso.
     * @param lacteo 	Si el producto es lacteo.
     * @param medida 	La medida de la bebida.
     */
    public Bebida(String nombre, double precio, int cantidad, Date fecha_caducidad, boolean gaseoso, boolean lacteo, String medida) {
        // Llama al constructor de la clase padre (Producto) con los parámetros proporcionados.
        super(nombre, precio, cantidad, fecha_caducidad);
        this.gaseoso = gaseoso;
        this.lacteo = lacteo;
        this.medida = medida;
    }
    
    @Override
    public Date obtener_caducidad() {
        // Obtiene fecha actual o fecha del pedido
        Date fechaPedido = new Date();

        // Crea un objeto Calendar y establecer la fecha del pedido
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaPedido);

        // Si el objeto bebida es lacteo, la fecha de caducidad será diez días más de la fecha de envase
        if (lacteo) {
            calendar.add(Calendar.DAY_OF_YEAR, 10);
        } else {
        // Si no es lácteo, se añaden 20 días a la fecha de caducidad actual
            calendar.add(Calendar.DAY_OF_YEAR, 20);
        }
        
       // Obtener la fecha de caducidad
        return calendar.getTime();
    }
    
    // Variables estáticas para las comidas
    public static final Bebida REFRESCO = new Bebida("Refresco", 1.80, 0, null, true, false, "33 cc");
    public static final Bebida AGUA = new Bebida("Agua", 1.00, 0, null, false, false, "50 cc");
    public static final Bebida PERONI = new Bebida("Cerveza Peroni", 3.00, 0, null, false, false, "33 cc");
    public static final Bebida MORETTI = new Bebida("Cerveza Moretti", 3.20, 0, null, false, false, "33 cc");
    public static final Bebida BATIDO = new Bebida("Batido casero", 4.00, 0, null, false, true, "50 cc");
    
	// Métodos Get and Set
	/**
	 * 
	 * @return
	 */
    public boolean getGaseoso() {
        return this.gaseoso;
    }

	/**
	 * 
	 * @param gaseoso
	 */
    public void setGaseoso(boolean gaseoso) {
        this.gaseoso = gaseoso;
    }

	/**
	 * 
	 * @return
	 */
    public boolean getLacteo() {
        return this.lacteo;
    }

	/**
	 * 
	 * @param lacteo
	 */
    public void setLacteo(boolean lacteo) {
        this.lacteo = lacteo;
    }
    

	/**
	 * 
	 * @return
	 */
	public String getMedida() {
		return this.medida;
	}

	/**
	 * 
	 * @param medida
	 */
	public void setMedida(String medida) {
		this.medida = medida;
	}

}