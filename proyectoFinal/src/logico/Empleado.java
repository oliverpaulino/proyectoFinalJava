package logico;


public class Empleado extends Usuario  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float salario;
    private boolean manager;
    private String password; // Marcar como transient si no se debe serializar

    public Empleado(String id, String nombre, String email, String numero, String direccion, String password, float salario, boolean manager) {
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

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    // Getter and setter for 'password' (if needed), marked transient
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

