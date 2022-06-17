package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class LlamadaInternacional extends Llamada{
	
	public LlamadaInternacional(String tipo, String emisor, String remitente, int duracion) {
		super(tipo,emisor,remitente,duracion);
	}
	
	public double getValor() {
		int duracion= this.getDuracion();
		return (duracion*200) + (duracion*200*0.21);
	}
}

