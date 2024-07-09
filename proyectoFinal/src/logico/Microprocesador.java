package logico;

public class Microprocesador {
	private String id;
	private String marca;
	private String modelo;
	private String tipoConexion;
	private int velocidadProcesamiento;
	private String tipoDeVelocidad;
	public Microprocesador(String id, String marca, String modelo, String tipoConexion, int velocidadProcesamiento,
			String tipoDeVelocidad) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.tipoConexion = tipoConexion;
		this.velocidadProcesamiento = velocidadProcesamiento;
		this.tipoDeVelocidad = tipoDeVelocidad;
	}
	public String getId() {
		return id;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public String getTipoConexion() {
		return tipoConexion;
	}
	public int getVelocidadProcesamiento() {
		return velocidadProcesamiento;
	}
	public String getTipoDeVelocidad() {
		return tipoDeVelocidad;
	}
	
	
}
