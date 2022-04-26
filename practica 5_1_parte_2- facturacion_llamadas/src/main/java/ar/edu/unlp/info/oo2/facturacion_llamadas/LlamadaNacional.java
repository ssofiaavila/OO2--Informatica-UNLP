package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class LlamadaNacional extends Llamada {
	
	public LlamadaNacional(String tipo, String emisor, String remitente, int duracion) {
		super(tipo,emisor,remitente,duracion);
	}
	public double getValor() {
		int duracion= this.getDuracion();
		return (duracion*3) + (duracion*3*0.21);
	}
}
