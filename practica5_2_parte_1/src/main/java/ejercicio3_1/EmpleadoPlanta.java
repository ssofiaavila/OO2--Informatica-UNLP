package ejercicio3_1;

public class EmpleadoPlanta extends Empleado {
	private int cantidadHijos=0;
	
	public EmpleadoPlanta(String nombre, String apellido, double sueldoBasico, int cantHijos) {
		super(nombre,apellido,sueldoBasico);
		this.cantidadHijos=cantHijos;
	}

	@Override
	public double calcularExtra() {
		return this.cantidadHijos*2000;
	}
	

	
	
}
