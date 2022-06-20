package practica7_3.practica7_3;

public class Project {
	
	private double currentAmount;
	private double targetAmount;
	private String title;
	private User owner;
	private State state;
	
	public Project(String name,User owner, double targetAmount ) {
		this.title=name;
		this.owner=owner;
		this.targetAmount=targetAmount;
		this.currentAmount=0;
		this.state= new Valid();
		
	}

	public void invest(double amount) {
		this.state.invest(this,amount);		
	}
	
	public double getCurrentAmount() {
		return this.currentAmount;
	}
	
	public double getTargetAmount() {
		return this.targetAmount;
	}
	
	public void addAmount(double amount) {
		this.currentAmount += amount;
	}
	
	public void setState(State state) {
		this.state=state;
	}
	public State getState() {
		return this.state;
	}

	public double getInvestedAmount() {
		return this.currentAmount;
	}
	
	public void cancell() {
		this.state.cancell(this);
	}
	
}
