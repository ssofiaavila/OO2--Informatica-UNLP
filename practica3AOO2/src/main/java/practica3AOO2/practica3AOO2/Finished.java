package practica3AOO2.practica3AOO2;

public class Finished implements State {
	public Finished() {
		
	}
	public State start() {
		return this;
	}
	public State pause() {
		throw new RuntimeException("No es posible pausarlo porque ya finalizo");

	}
	public State finish() {
		return this;
	}
	public String getState() {
		return "Finished";
	}
}
