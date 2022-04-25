package practica2DOO2.practica2DOO2;

public class Pasante extends Empleado {
	
	private Integer examenesRendidos;

	public Pasante(String nombre, Integer examenesRendidos) {
		super(nombre);
		// TODO Auto-generated constructor stub
		this.examenesRendidos = examenesRendidos;
	}

	@Override
	public double getBasico() {
		return 20000;
	}
	
	@Override
	public double getAdicional() {
		return 2000*examenesRendidos;
	}
}
