package practica2_4.practica2_4;

public class Pasante extends Empleado{

	private int exams;
	
	public Pasante(int examns) {
		super();
		this.exams=examns;
	}
	
	

	public double aditionalSalary() {
		return this.exams*2000;
	}

	
	public double basicSalary() {
		return 20000;
	}

}
