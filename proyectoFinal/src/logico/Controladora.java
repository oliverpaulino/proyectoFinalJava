package logico;

import java.util.ArrayList;

public class Controladora {
	
	public static int idfactura = 1;
	public static int iduser = 1;
	public static int idcomponente = 1;
//	public static int id = 1;
	
	private ArrayList<Usuario>misUsuarios;
	private ArrayList<Componente>misComponentes;
//	private ArrayList<Factura>misFacturas;
	private static Controladora miControladora = null;

	private Controladora() {
		super();
		misUsuarios = new ArrayList<>();
		misComponentes = new ArrayList<>();
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
	
	public Usuario findUserById(String userId) {
		Usuario user = null;
		boolean found = false;

		int i = 0;
		while (!found && i < misUsuarios.size()) {
			if (misUsuarios.get(i).getId().equalsIgnoreCase(userId)) {
				user = misUsuarios.get(i);
				found = true;
			}
			i++;
		}

		return user;
	}
	
	public void addUser(Usuario user) {
		misUsuarios.add(user);
		iduser++;
	}
	
	public void deleteUser(String userId) {
		Usuario user = findUserById(userId);
		misUsuarios.remove(user);
	}
	
	public void addComponente(Componente c1) {
		misComponentes.add(c1);
		idcomponente++;
		
	}

	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
		
	}

	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}

	public static Controladora getMiControladora() {
		return miControladora;
	}

	public static void setMiControladora(Controladora miControladora) {
		Controladora.miControladora = miControladora;
	}

	public Usuario buscarUsuarioByCorreo(String email) {
		Usuario user = null;
		boolean encontrado = true;
		int i = 0;
		while(encontrado && misUsuarios.size() > i) {
			if(misUsuarios.get(i).getEmail().equalsIgnoreCase(email)) {
				user = misUsuarios.get(i);
				encontrado = false;
			}
			i++;
		}
		return user;
	}
	
	
	
	
	

}