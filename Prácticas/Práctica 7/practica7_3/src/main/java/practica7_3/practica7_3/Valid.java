package practica7_3.practica7_3;

public class Valid extends State{

	@Override
	public void invest(Project project, double amount) {
		project.addAmount(amount);
		if (project.getCurrentAmount() >= project.getTargetAmount()) {
			project.setState(new Conformed());
		}
		
	}

	@Override
	public void cancell(Project project) {
		project.setState(new Cancelled());
		
	}

}
