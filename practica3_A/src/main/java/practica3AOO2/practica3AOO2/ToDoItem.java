package practica3AOO2.practica3AOO2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoItem {
	private String name;
	private LocalDateTime inicio;
	private LocalDateTime fin;
	private List<String> comments;
	private State estado;
	
	
	public ToDoItem ToDoItem(String name) {
		this.name=name;
		this.estado= new Pending();
		this.inicio=null;
		this.fin=null;
		this.comments= new ArrayList<String>();
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
	
	
	public LocalDateTime getFinishDate() {
		return this.fin;
	}
	public void setFinishDate(LocalDateTime fin) {
		this.fin=fin;
	}
	
	public LocalDateTime getStartDate() {
		return this.inicio;
	}
	public void setStartDate(LocalDateTime inicio) {
		this.inicio=inicio;
	}
	
	public Duration workedTime() { //???
		if (this.getStartDate() == null) {
			throw new RuntimeException("Aun no ha iniciado la tarea");
		}
		if (this.getFinishDate()== null) {
			throw new RuntimeException("La tarea no finalizó");
		}
		return Duration.between(this.getStartDate(), this.getFinishDate());
		
	}
	public void addComment(String comment) {
		if (!estado.getState().equals("Finished")) {
			this.comments.add(comment);
		}
		
	}
	
	public List<String> getComments() {
		return this.comments;
	}
	public State getState() {
		return this.estado;
	}
}
