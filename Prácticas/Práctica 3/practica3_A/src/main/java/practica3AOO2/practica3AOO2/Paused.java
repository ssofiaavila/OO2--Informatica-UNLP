package practica3AOO2.practica3AOO2;

public class Paused implements State{
	public Paused() {
	}
	
	public State start() {
		return this;
	}
	public State pause() {
		return new InProcess();
	}
	public State finish() {
		return new Finished();
	}
	public String getState() {
		return "Paused";
	}
}
