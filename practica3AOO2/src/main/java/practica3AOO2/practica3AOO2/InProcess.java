package practica3AOO2.practica3AOO2;

public class InProcess implements State {
	
	public InProcess() {
		
	}
	public State start() {
		return this;
	}
	public State pause() {
		return new Paused();
	}
	public State finish() {
		return new Finished();
	}
	public String getState() {
		return "In Process";
	}
}
