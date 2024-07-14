package logico;

public class Microprocesador extends Componente {
	private String tipoConexion;
	private int velocidadProcesamiento;
	private String tipoDeVelocidad;
	public Microprocesador(String id, String marca, String modelo,float costo, float precio, int cantidad, String numeroSerie,
			String tipoConexion, int velocidadProcesamiento, String tipoDeVelocidad ) {
		super(id, marca, modelo,costo, precio, cantidad, numeroSerie);
		this.tipoConexion = tipoConexion;
		this.velocidadProcesamiento = velocidadProcesamiento;
		this.tipoDeVelocidad = tipoDeVelocidad;
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
