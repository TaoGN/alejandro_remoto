/**
 * 
 */
package logic;

import java.util.Date;
import java.io.Serializable;

/**
 * @author Alejandro García
 *
 */
public class Cliente implements Serializable {

	// Atributos
	private int id;
	private String nombre;
	private String apellidos;
	private Date fechaDeAlta;
	private String telefono;
	private String direccion;
	private String historial;

	// Constructores
	/**
	 * 
	 */
	public Cliente() {

	}

	/**
	 * Constructor clase producto con 6 parámetros
	 * 
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param fechaDeAlta
	 * @param telefono
	 * @param direccion
	 * @param historial
	 */
	public Cliente(int id, String nombre, String apellidos, Date fechaDeAlta, String telefono, String direccion, String historial) {
		this.id = id; 
		this.nombre = nombre.toLowerCase();
		this.apellidos = apellidos.toUpperCase();
		this.fechaDeAlta = (fechaDeAlta != null) ? fechaDeAlta : new Date();
		this.telefono = telefono;
		this.direccion = direccion;
		this.historial = "";
	}

	// Métodos Get and Set

	/**
	 * 
	 * @return
	 */
    public int getId() {
        return this.id;
    }
    
	/**
	 * 
	 * @param id
	 */
    public void setId(int id) {
        this.id = id;
    }
	
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
	public String getApellidos() {
		return this.apellidos;
	}

	/**
	 * 
	 * @param apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	/**
	 * 
	 * @return
	 */
	public Date getFechaDeAlta() {
		return this.fechaDeAlta;
	}

	/**
	 * 
	 * @param fechaDeAlta
	 */
	public void setFechaDeAlta(Date fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	/**
	 * 
	 * @return
	 */
	public String getTelefono() {
		return this.telefono;
	}

	/**
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * 
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getHistorial() {
		return this.historial;
	}

	/**
	 * 
	 * @param historial
	 */
	public void setHistorial(String historial) {
		this.historial = historial;
	}

}
