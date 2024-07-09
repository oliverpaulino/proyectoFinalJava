package logico;

public class TarjetaMadre extends Componente {
	private String tipoConector;
	private String TipoRAM;
	private String[] listConexionDiscoDuro;

	public TarjetaMadre(String id, String marca, String modelo, float precio, int cantidad, String numeroSerie,
			String tipoConector, String TipoRAM, String[] listConexionDiscoDuro ) {
		super(id, marca, modelo, precio, cantidad, numeroSerie);
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

	public String[] getListConexionDiscoDuro() {
		return listConexionDiscoDuro;
	}
	
	

}
