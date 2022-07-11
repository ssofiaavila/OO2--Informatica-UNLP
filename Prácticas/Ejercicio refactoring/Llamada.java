package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class Llamada {
	protected String tipoDeLlamada;
	private String emisor;
	private String remitente;
	public int dur;
	
	public Llamada() {
		
	}
	public Llamada(String s, String p, String p2, Persoona p3, int dur) {
		this.tipoDeLlamada = s;
		this.emisor= p;
		this.remitente= p2;
		this.dur = dur;
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
	
	
	
	
}
