package practica3COO2.practica3COO2;

public class Adapter4GConnection {
	private Connection4G adaptee;
	
	public String pict() {
		return adaptee.symb();
	}
}
