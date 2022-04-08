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
	
	
}
