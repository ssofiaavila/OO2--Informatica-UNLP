package ejercicio3_6;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pelicula {
	private String nombre;
	private String genero;
	private LocalDate fechaEstreno;
	private double costo;
	
	public Pelicula(String nombre, String genero, LocalDate fecha, double costo) {
		this.nombre=nombre;
		this.genero=genero;
		this.fechaEstreno=fecha;
		this.costo=costo;		
	}
	
	public double getCosto() {
		return this.costo;
	}
	
	public double calcularCargoExtraPorEstreno() {
		return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()))> 30 ? 0:300;
	}
}
