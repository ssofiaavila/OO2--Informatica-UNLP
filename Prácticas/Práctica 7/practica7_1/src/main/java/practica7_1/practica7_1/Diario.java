package practica7_1.practica7_1;

public class Diario implements Lavado {

	
	public int iniciarLavado(Lavarropas lavarropa) {
		this.preLavado(lavarropa, 50);
		return	this.lavado(lavarropa, 20) + this.postLavado(lavarropa, 7, 3);
	
	}

	@Override
	public void preLavado(Lavarropas lavarropas, int cantAgua) {
		lavarropas.agregarAgua(cantAgua);
		lavarropas.agregarJabonEnPolvo();
	}

	@Override
	public int lavado(Lavarropas lavarropas, int minLavado) {
		lavarropas.lavar(minLavado);
		return minLavado;
	}

	@Override
	public int postLavado(Lavarropas lavarropas, int minEnjuague, int minCentrifugado) {
		lavarropas.vaciarAgua();
		lavarropas.agregarEnjuague();
		lavarropas.enjuaga(minEnjuague);
		lavarropas.centrifugar(minCentrifugado);
		return minEnjuague + minCentrifugado;
	}
	

}
