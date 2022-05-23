package ejercicio3_1;

public class EmpleadoTemporario extends Empleado{
	// olia mal las variable estén declaradas como públicas
	public double horasTrabajadas =0;
	public int cantidadHijos =0;
	
	
	public EmpleadoTemporario(String nombre, String apellido, double sueldo, int horasTrabajadas, int cantHijos) {
		super(nombre,apellido,sueldo);
		this.horasTrabajadas=horasTrabajadas;
		this.cantidadHijos=cantHijos;
	}
	
	public double calcularExtra() {
		return (this.horasTrabajadas *500) + (this.cantidadHijos*1000);
	}
	
	
	
	
}
