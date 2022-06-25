package practica2_4.practica2_4;

public class Planta extends Empleado{
	private int years;
	private boolean married;
	private int childs;
		
	
	public Planta(int years, boolean married, int childs) {
		super();
		this.years=years;
		this.married=married;
		this.childs=childs;
		
		
	}
	
	
	public double aditionalSalary() {
		if (married) {
			return 5000 + ((this.childs+ this.years)*2000);
		}
		else
			return (this.childs+ this.years)*2000;
	}

	
	public double basicSalary() {
		return 50000;
	}
	
}
