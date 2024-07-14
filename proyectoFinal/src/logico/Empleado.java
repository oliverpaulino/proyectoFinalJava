package logico;

public class Empleado extends Usuario {

	private float salario;
	private boolean manager;
	private String password;
	public Empleado(String id, String nombre, String email, String numero, String direccion, String password, float salario, boolean manager ) {
		// TODO Auto-generated constructor stub
		super(id, nombre, email, numero, direccion);
		this.password = password;
		this.manager = manager;
		this.salario = salario;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isManager() {
		return manager;
	}
	public void setManager(boolean manager) {
		this.manager = manager;
	}
	
	
	

}
