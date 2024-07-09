package logico;

public class MemoriaRAM extends Componente{
	
	private int cantMemoria;
	private String medidaDeMemoria;// gb o mb
	private String tipoMemoria;
	
	public MemoriaRAM(String id, String marca, String modelo, float precio, int cantidad,
			String numeroSerie, int cantMemoria, String medidaDeMemoria, String tipoMemoria) {
		super(id, marca, modelo, precio, cantidad, numeroSerie);
		
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
