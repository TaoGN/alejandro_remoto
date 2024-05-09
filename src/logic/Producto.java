/**
 * 
 */
package logic;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Alejandro García 
 *
 */
public abstract class Producto {

	// Atributos
	private String nombre;
	private double precio;
	private int cantidad;
	private Date fecha_caducidad;
	String estado;
	// Constructores
	/**
	 * 
	 */
	public Producto() {
	}
	/**
	 * Constructor clase producto con 3 parametros
	 * 
	 * @param nombre
	 * @param precioUnit
	 * @param cantidad
	 * @param fecha_caducidad
	 */
	public Producto(String nombre, double precio, int cantidad, Date fecha_caducidad) {

		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.fecha_caducidad = fecha_caducidad;
	}

	// Métodos Get and Set

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public double getPrecio() {
		return this.precio;
	}

	/**
	 * 
	 * @param precioUnit
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * 
	 * @return
	 */
	public int getCantidad() {
		return this.cantidad;
	}

	/**
	 * 
	 * @param cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * 
	 * @return
	 */
    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }
    
	/**
	 * 
	 * @param fecha de caducidad
	 */
    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }
    
    public abstract Date obtener_caducidad();
    
    // Método para verificar la caducidad del producto
    public String verificarCaducidad() {
        Calendar fechaCaducidad = Calendar.getInstance();
        fechaCaducidad.setTime(this.getFecha_caducidad());
        Calendar hoy = Calendar.getInstance();
        hoy.add(Calendar.DAY_OF_YEAR, 5); // Agrega 5 días a la fecha actual

        if (fechaCaducidad.before(hoy)) {
            this.setPrecio(this.getPrecio() * 0.7); // Aplica el descuento del 30%
            return "OFERTA";
        } else if (fechaCaducidad.before(Calendar.getInstance())) {
            return "CADUCADO";
        } else {
            return "VÁLIDO";
        }
    }
    
  }
