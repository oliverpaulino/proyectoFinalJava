package logico;

public class Componente {
	private String id;
	private String marca;
	private String modelo;
	private float precio;
	private int cantidad;
	private String numeroSerie;
	
	public Componente(String id, String marca, String modelo, float precio, int cantidad, String numeroSerie) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.cantidad = cantidad;
		this.numeroSerie = numeroSerie;
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

	public float getPrecio() {
		return precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}
	
	
	
}
