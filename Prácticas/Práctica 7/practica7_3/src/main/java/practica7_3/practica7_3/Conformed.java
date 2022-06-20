package practica7_3.practica7_3;

public class Conformed extends State{

	@Override
	public void invest(Project project, double amount) {
		project.addAmount(amount);
		
	}

	@Override
	public void cancell(Project project) {
		throw new RuntimeException("No se puede cancelar porque ya está conformado");
		
	}

}
