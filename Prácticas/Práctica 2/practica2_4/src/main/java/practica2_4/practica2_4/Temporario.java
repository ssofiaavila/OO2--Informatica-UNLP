package practica2_4.practica2_4;

public class Temporario extends Empleado{

	private int workedHours;
	private boolean married;
	private int childs;
	
	public Temporario(int hours, boolean married, int childs) {
		super();
		this.workedHours=hours;
		this.married=married;
		this.childs=childs;
	}
	
	
	public double basicSalary() {
		return 20000+ (this.workedHours *300);
	}


	public double aditionalSalary() {
		if (this.married) {
			return 5000+ (this.childs*2000);
		}
		else
			return (this.childs*2000);
	}

}
