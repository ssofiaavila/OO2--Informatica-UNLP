package practica7_3.practica7_3;

public class Cancelled extends State{

	@Override
	public void invest(Project project, double amount) {
		throw new RuntimeException("No se puede invertir en este proyecto porque está cancelado");
		
	}

	@Override
	public void cancell(Project project) {
		throw new RuntimeException("No se puede cancelar porque ya lo está");
		
	}

}
