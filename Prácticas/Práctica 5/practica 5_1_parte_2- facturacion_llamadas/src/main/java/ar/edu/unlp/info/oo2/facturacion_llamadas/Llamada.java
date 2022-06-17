package ar.edu.unlp.info.oo2.facturacion_llamadas;
/*BAD SMELLS FOUND IN THIS CLASS 
 1. inappropiate intimacy de atributos
 * 
 * */
public abstract class Llamada {
	protected String tipoDeLlamada;
	private String emisor;
	private String remitente;
	private int duracion;
	
	public Llamada() {
		
	}
	public Llamada(String tipo, String emisor, String remitente, int duracion) {
		this.tipoDeLlamada = tipo;
		this.emisor= emisor;
		this.remitente= remitente;
		this.duracion = duracion;
	}

	public String getTipoDeLlamada() {
		return tipoDeLlamada;
	}

	public void setTipoDeLlamada(String tipoDeLlamada) {
		this.tipoDeLlamada = tipoDeLlamada;
	}
	public void setEmisor(String q) {
		emisor = q;
	}
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	
	//new method due to "dur" field refactoritation 
	public int getDuracion() {
		return this.duracion;
	}
	public abstract double getValor();
	
	
	
	
}
