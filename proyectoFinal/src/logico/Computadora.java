package logico;

import java.util.ArrayList;

public class Computadora extends Product {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<DiscoDuro> misDiscoDuros;
	private ArrayList<MemoriaRAM> misMemoriaRAMs;
	private TarjetaMadre miTarjetaMadre;
	private Microprocesador microprocesador;
	private float mountCost;
	private ArrayList<String> adicionales; //esto es una idea mientras tanto, aqui estaran los monitores, teclado, raton, etc...
	

	public Computadora(String id, String marca, String modelo, float costo, float precio, int cantidad, String numeroSerie, ArrayList<DiscoDuro> misDiscoDuros, ArrayList<MemoriaRAM> misMemoriaRAMs,
			TarjetaMadre miTarjetaMadre, Microprocesador microprocesador, float mountCost, ArrayList<String> adicionales) {
		super(id, marca, modelo, costo, precio, cantidad, numeroSerie);
		
		this.misDiscoDuros = misDiscoDuros;
		this.misMemoriaRAMs = misMemoriaRAMs;
		this.miTarjetaMadre = miTarjetaMadre;
		this.microprocesador = microprocesador;
		this.mountCost = mountCost;
		this.adicionales = adicionales;
	}
	
	public ArrayList<DiscoDuro> getMisDiscoDuros() {
		return misDiscoDuros;
	}
	public void setMisDiscoDuros(ArrayList<DiscoDuro> misDiscoDuros) {
		this.misDiscoDuros = misDiscoDuros;
	}
	public ArrayList<MemoriaRAM> getMisMemoriaRAMs() {
		return misMemoriaRAMs;
	}
	public void setMisMemoriaRAMs(ArrayList<MemoriaRAM> misMemoriaRAMs) {
		this.misMemoriaRAMs = misMemoriaRAMs;
	}
	public TarjetaMadre getMiTarjetaMadre() {
		return miTarjetaMadre;
	}
	public void setMiTarjetaMadre(TarjetaMadre miTarjetaMadre) {
		this.miTarjetaMadre = miTarjetaMadre;
	}
	public Microprocesador getMicroprocesador() {
		return microprocesador;
	}
	public void setMicroprocesador(Microprocesador microprocesador) {
		this.microprocesador = microprocesador;
	}
	
	public float getMountCost() {
		return mountCost;
	}

	public void setMountCost(float mountCost) {
		this.mountCost = mountCost;
	}
	
	public ArrayList<String> getAdicionales() {
		return adicionales;
	}
	public void setAdicionales(ArrayList<String> adicionales) {
		this.adicionales = adicionales;
	}

}
