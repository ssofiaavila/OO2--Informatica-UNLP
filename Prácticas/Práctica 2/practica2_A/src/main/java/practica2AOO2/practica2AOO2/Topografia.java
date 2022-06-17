package practica2AOO2.practica2AOO2;

public abstract class Topografia {

	public Topografia() {
	
	}
	
	public void addElementos(Topografia primer, Topografia segundo, Topografia tercer, Topografia cuarto) 
	{
		throw new UnsupportedOperationException();
	}
	
	public void clearElementos() {
		throw new UnsupportedOperationException();
	}
	
	public Topografia getElemento(int index) {
		throw new UnsupportedOperationException();
	}
	
	public abstract double getProportion();
}
