package logico;

public class MemoriaRAM extends Componente{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3333090851637920183L;
	private int cantMemoria;
	private String medidaDeMemoria;// gb o mb
	private String tipoMemoria;
	
	public MemoriaRAM(String id, String marca, String modelo,float costo, float precio, int cantidad,
			String numeroSerie, int cantMemoria, String medidaDeMemoria, String tipoMemoria) {
		super(id, marca, modelo, costo, precio, cantidad, numeroSerie);
		
		this.cantMemoria = cantMemoria;
		this.medidaDeMemoria = medidaDeMemoria;
		this.tipoMemoria = tipoMemoria;
	}

	public int getCantMemoria() {
		return cantMemoria;
	}

	public String getMedidaDeMemoria() {
		return medidaDeMemoria;
	}

	public String getTipoMemoria() {
		return tipoMemoria;
	}
	
	
	
}
