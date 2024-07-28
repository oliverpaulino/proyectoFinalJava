package logico;

import java.util.ArrayList;

public class TarjetaMadre extends Product {
	private String tipoConector;
	private String TipoRAM;
	private ArrayList<String> listConexionDiscoDuro;

	public TarjetaMadre(String id, String marca, String modelo,float costo, float precio, int cantidad, String numeroSerie,
			String tipoConector, String TipoRAM, ArrayList<String> listConexionDiscoDuro ) {
		super(id, marca, modelo,costo, precio, cantidad, numeroSerie);
		this.listConexionDiscoDuro = listConexionDiscoDuro;
		this.TipoRAM = TipoRAM;
		this.tipoConector=tipoConector; 
	}

	public String getTipoConector() {
		return tipoConector;
	}

	public String getTipoRAM() {
		return TipoRAM;
	}

	public ArrayList<String> getListConexionDiscoDuro() {
		return listConexionDiscoDuro;
	}
	
	

}
