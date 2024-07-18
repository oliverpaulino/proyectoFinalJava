package logico;

import java.io.Serializable;

public class Cliente extends Usuario implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7422145305466558312L;

	// agregar arraylist de computadoras o facturas determinar con alonso
	public Cliente(String id, String nombre, String email, String numero, String direccion) {
		super(id, nombre, email, numero, direccion);
		// TODO Auto-generated constructor stub
	}

}
