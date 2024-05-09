package logic;

import java.util.Date;
import java.util.Calendar;

/**
 * @author Alejandro García 
 * Esta clase representa un producto de comida.
 * Extiende la clase Producto.
 */
public class Comida extends Producto {
    // Atributos específicos de Comida
    private boolean perecedero;
    private float calorias;
    private boolean vegano;
    private Date fecha_envase;
	
    /**
     * Constructor de la clase Comida.
     *
     * @param nombre   			El nombre del producto de comida.
     * @param precio   			El precio del producto de comida.
     * @param cantidad 			La cantidad seleccionada del producto de comida.
     * @param fecha_caducidad 	La fecha de caducidad del producto de comida.
     * @param perecedero     	Si el alimento es perecedero.
     * @param calorias      	Las calorías del alimento.
     * @param vegano        	Si el alimento es vegano.
     * @param fecha_envase  	La fecha de envasado del alimento.
     */
    public Comida(String nombre, double precio, int cantidad, Date fecha_caducidad, boolean perecedero, float calorias, boolean vegano, Date fecha_envase) {
        // Llama al constructor de la clase padre (Producto) con los parámetros proporcionados.
        super(nombre, precio, cantidad, fecha_caducidad);
        this.perecedero = perecedero;
        this.calorias = calorias;
        this.vegano = vegano;
        this.fecha_envase = fecha_envase;   
    }
    
    @Override
    public Date obtener_caducidad() {
        // Obtiene fecha actual o fecha del pedido
        Date fechaPedido = new Date();

        // Crea un objeto Calendar y establecer la fecha del pedido
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaPedido);

        // Si el objeto comida es perecedero, la fecha de caducidad será diez días más de la fecha de envase
        if (perecedero) {
            calendar.add(Calendar.DAY_OF_YEAR, 10);
        } else {
            // Si no es perecedero, devuelve la fecha actual como fecha de caducidad
            return fechaPedido;
        }

        // Obtener la fecha de caducidad
        return calendar.getTime();
    }
   
    // Variables estáticas para las comidas
    public static final Comida NAPOLITANA = new Comida("Pizza Napolitana", 10.00, 0, null, true, 500, false, null);
    public static final Comida CARBONARA = new Comida("Pizza Carbonara", 10.50, 0, null, true, 540, false, null);
    public static final Comida FUGAZZA = new Comida("Pizza Fugazza", 10.50, 0, null, true, 520, false, null);
    public static final Comida CALZONE = new Comida("Calzone", 13.50, 0, null, true, 600, true, null);
    public static final Comida PROSCIUTTO = new Comida("Pizza Prosciutto", 9.80, 0, null, true, 480, false, null);
    
	// Métodos Get and Set
	/**
	 * 
	 * @return
	 */
    public boolean getPerecedero() {
        return this.perecedero;
    }

	/**
	 * 
	 * @param perecedero
	 */
    public void setPerecedero(boolean perecedero) {
        this.perecedero = perecedero;
    }

	/**
	 * 
	 * @return
	 */
    public float getCalorias() {
        return calorias;
    }

	/**
	 * 
	 * @param calorias
	 */
    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }

	/**
	 * 
	 * @return
	 */
    public boolean getVegano() {
        return this.vegano;
    }

	/**
	 * 
	 * @param vegano
	 */
    public void setVegano(boolean vegano) {
        this.vegano = vegano;
    }

	/**
	 * 
	 * @return
	 */
    public Date getFecha_envase() {
        return this.fecha_envase;
    }

	/**
	 * 
	 * @param fecha_envase
	 */
    public void setFecha_envase(Date fecha_envase) {
        this.fecha_envase = fecha_envase;
    }

}