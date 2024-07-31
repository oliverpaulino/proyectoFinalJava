package logico;

import java.io.Serializable;

public class Product implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4354380039011536968L;
	private String id;
	private String marca;
	private String modelo;
	private float costo;
	private float precio;
	private int cantidad;
	private String numeroSerie;
	
	public Product(String id, String marca, String modelo,float costo, float precio, int cantidad, String numeroSerie) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.costo = costo;
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

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public float getTotalCost() {
		return this.costo + this.precio;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
