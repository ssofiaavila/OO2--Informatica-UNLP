package practica7_1.practica7_1;

public class Delicada implements Lavado{

	@Override
	public int iniciarLavado(Lavarropas lavarropas) {
		this.preLavado(lavarropas, 100);
		return this.lavado(lavarropas, 40) + this.postLavado(lavarropas, 15, 0);
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
