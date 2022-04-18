package practica3DOO2.practica3DOO2;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private String titulo;
	private int anioEstreno;
	private double puntaje;
	private List<Pelicula> similares;
	
	public Pelicula(String titulo, int anio, double puntaje) {
		this.titulo=titulo;
		this.anioEstreno=anio;
		this.puntaje=puntaje;
		this.similares= new ArrayList<Pelicula>();
	}
	
	public void addSPeliculaSimilar(Pelicula nueva) {
		if (!this.similares.contains(nueva)) {
			this.similares.add(nueva);
			nueva.addSPeliculaSimilar(this);
		}
	}
	public int getAnioEstreno() {
		return this.anioEstreno;
	}
	public double getPuntaje() {
		return puntaje;
	}
	public String getTitulo() {
		return this.titulo;
	}
	
}
