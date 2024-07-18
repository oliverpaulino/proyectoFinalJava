package logico;

public class DiscoDuro extends Componente {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9082250312294122917L;
	private int maxAlmacenamiento;
	private String medidaAlmacenamiento;//gb p tb
	private String tipoConexion;
	

	public DiscoDuro(String id, String marca, String modelo,float costo, float precio, int cantidad, String numeroSerie, 
			int maxAlmacenamiento, String medidaAlmacenamiento, String tipoConexion) {
		super(id, marca, modelo, costo,precio, cantidad, numeroSerie);
		this.maxAlmacenamiento = maxAlmacenamiento;
		this.medidaAlmacenamiento = medidaAlmacenamiento;
		this.tipoConexion = tipoConexion;
	}


	public int getMaxAlmacenamiento() {
		return maxAlmacenamiento;
	}


	public String getMedidaAlmacenamiento() {
		return medidaAlmacenamiento;
	}


	public String getTipoConexion() {
		return tipoConexion;
	}

	
}
