package logico;

public class Microprocesador extends Product {
	/**
	 * 
	 */
	private String tipoConexion;
	private float velocidadProcesamiento;
	private String tipoDeVelocidad;
	public Microprocesador(String id, String marca, String modelo,float costo, float precio, int cantidad, String numeroSerie,
			String tipoConexion, float velocidadProcesamiento, String tipoDeVelocidad ) {
		super(id, marca, modelo,costo, precio, cantidad, numeroSerie);
		this.tipoConexion = tipoConexion;
		this.velocidadProcesamiento = velocidadProcesamiento;
		this.tipoDeVelocidad = tipoDeVelocidad;
	}

	public String getTipoConexion() {
		return tipoConexion;
	}
	public float getVelocidadProcesamiento() {
		return velocidadProcesamiento;
	}
	public String getTipoDeVelocidad() {
		return tipoDeVelocidad;
	}
	
	
}
