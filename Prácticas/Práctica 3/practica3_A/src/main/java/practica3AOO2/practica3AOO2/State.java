package practica3AOO2.practica3AOO2;

public interface State {
	
	public State start();
	public State pause();
	public State finish();
	public String getState();
}
