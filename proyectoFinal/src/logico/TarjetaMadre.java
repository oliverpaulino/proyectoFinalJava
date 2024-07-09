package logico;

public class TarjetaMadre {
	
	private String id;
	private String marca;
	private String modelo;
	private String tipoConector;
	private String tipoMemoria;
	private String[] listConexionesDiscoDuro;
	public TarjetaMadre(String id, String marca, String modelo, String tipoConector, String tipoMemoria,
			String[] listConexionesDiscoDuro) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.tipoConector = tipoConector;
		this.tipoMemoria = tipoMemoria;
		this.listConexionesDiscoDuro = listConexionesDiscoDuro;
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
	public String getTipoConector() {
		return tipoConector;
	}
	public String getTipoMemoria() {
		return tipoMemoria;
	}
	public String[] getListConexionesDiscoDuro() {
		return listConexionesDiscoDuro;
	}
	
	
	
}
