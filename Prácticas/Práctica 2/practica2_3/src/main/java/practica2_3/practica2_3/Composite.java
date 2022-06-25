package practica2_3.practica2_3;

import java.time.LocalDate;

public abstract class Composite {
	private String name;
	private LocalDate date;
	private int size;
	
	public Composite(String name,int size) {
		this.name=name;
		this.date= LocalDate.now();
		this.size=size;
		
	}
	
	public int getSize() {
		return this.size;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public abstract File biggestFile();
	public abstract File newestFile();
	
	
}
