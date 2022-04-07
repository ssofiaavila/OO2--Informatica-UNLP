package practica3AOO2.practica3AOO2;

import java.time.Duration;
import java.time.LocalDateTime;

public class ToDoItem {
	private String name;
	private LocalDateTime dateStart;
	private String[] comments;
	private State estado;
	
	
	public ToDoItem ToDoItem(String name) {
		this.name=name;
		this.estado= new Pending();
		return this;
	}
	public void start() {
		estado=estado.start();			
	}
	
	public void togglePause() {
		estado=estado.pause();
	}
	public void finish() {
		estado=estado.finish();
	}
	public Duration workedTime() { //???
		
	}
	public void addComment(String comment) {
		if (!estado.getState().equals("Finished")) {
			this.comments[this.comments.length]= comment;
		}
		
	}
	
	public String[] getComments() {
		return this.comments;
	}
	public State getState() {
		return this.estado;
	}
}
