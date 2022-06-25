package practica2_4.practica2_4;

public abstract class Empleado {
	
	public double salary() {
		return this.basicSalary() + this.aditionalSalary() - this.discount();
	}
	
	public abstract double aditionalSalary();

	protected  double discount() {
		return (this.basicSalary()/0.13) + (this.aditionalSalary()/0.05);		
	}
	public  abstract double basicSalary();
}
