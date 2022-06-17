package ejercicio3_1;

/* ya que los empleados temporarios, de planta y pasantes tenían igual comportamiento 
 * y algunas variables iguales, era mas facil implementar polimorfismo y ahorrar codigo
 */

public abstract class Empleado {
	private String nombre;
	private String apellido; 
	private double sueldoBasico;
	
	public Empleado(String nombre, String apellido, double sueldo) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.sueldoBasico=sueldo;
	}


	public double sueldo() {
		return this.sueldoBasico + this.calcularExtra() - (this.sueldoBasico *0.13);
	}
	
	
	public abstract double calcularExtra();
	
	public double getSueldoBasico() {
		return this.sueldoBasico;
	}
	public void setSueldoBasico(double sueldo) {
		this.sueldoBasico=sueldo;
	}
}
