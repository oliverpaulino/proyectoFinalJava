package logico;

import java.util.ArrayList;

public class Controladora {
	
	public static int codCliente = 1;
	
	private ArrayList<Usuario>misUsuarios;
	private static Controladora miControladora = null;

	private Controladora() {
		super();
		misUsuarios = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	
	public static Controladora getInstance () {
		if (miControladora==null) {
			miControladora = new Controladora();
		}
		return miControladora;
		
	}

	public ArrayList<Usuario> getMisUsuarios() {
		return misUsuarios;
	}
	
	
	
	
	

}
