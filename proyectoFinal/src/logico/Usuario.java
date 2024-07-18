package logico;

import java.io.Serializable;

public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6792504556452117296L;
	private String id;
	private String nombre;
	private String email;
	private String numero;
	private String direccion;
	
	public Usuario(String id, String nombre, String email, String numero, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.numero = numero;
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direaccion) {
		this.direccion = direaccion;
	}

	public String getId() {
		return id;
	}
	
	
	
	
	
	
	
}
