package practica3AOO2.practica3AOO2;

public class Pending implements State{
	
	public Pending() {
		
	}
	public State start() {
		return new InProcess();
	}
	public State pause() {
		throw new RuntimeException("No puedo pausarlo porque aun no comenzo");

	}
	public State finish() {
		return this;
	}
	public String getState() {
		return "Pending";
	}

}
