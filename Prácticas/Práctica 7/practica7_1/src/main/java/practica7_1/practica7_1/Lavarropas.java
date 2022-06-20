package practica7_1.practica7_1;

public class Lavarropas {
	
	private Lavado tipoLavado; // because i implement strategy pattern	
	
	public void setTipoLavado(Lavado tipo) {
		this.tipoLavado=tipo;
	}
	
	public int realizarLavado() {
		return this.tipoLavado.iniciarLavado(this);
	}
	
	public void agregarAgua(int porcentaje) {}
	public void agregarJabonEnPolvo() {}
	public void lavar(int minutos) {}
	public void vaciarAgua() {}
	public void agregarEnjuague() {}
	public void enjuaga(int minutos) {}
	public void centrifugar(int minutos) {}
}
