package logico;

public class Usuario {
	private String id;
	private String nombre;
	private String email;
	private String numero;
	private String direaccion;
	private String password;
	public Usuario(String id, String nombre, String email, String numero, String direaccion, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.numero = numero;
		this.direaccion = direaccion;
		this.password = password;
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
	public String getDireaccion() {
		return direaccion;
	}
	public void setDireaccion(String direaccion) {
		this.direaccion = direaccion;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	
	
	
	
	
	
	
}
