package practica7_1.practica7_1;

public interface Lavado {
	
	
	
	public int iniciarLavado(Lavarropas lavarropas);
	
	public void preLavado(Lavarropas lavarropas, int cantAgua);
	public int lavado(Lavarropas lavarropas,int minLavado);
	public int postLavado(Lavarropas lavarropas, int minEnjuague, int minCentrifugado);

}
