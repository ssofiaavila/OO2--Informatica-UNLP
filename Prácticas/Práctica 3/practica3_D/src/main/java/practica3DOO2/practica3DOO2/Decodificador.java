package practica3DOO2.practica3DOO2;

import java.util.ArrayList;
import java.util.List;

public class Decodificador {
	private List<Pelicula> reproducidas;
	private List<Pelicula> disponibles;
	private Sugeridor recomendador;
	
	public Decodificador() {
		this.reproducidas= new ArrayList<Pelicula>();
		this.disponibles= new ArrayList<Pelicula>();
	}
	public void setCriterio(Sugeridor nuevo) {
		this.recomendador=nuevo;
	}
	
	public List<Pelicula> recomendar(){
		return this.recomendador.recomendar(this.reproducidas, this.disponibles);
		
	}
	public void agregarPelicula (Pelicula nueva) {
		this.disponibles.add(nueva);
	}
	public void agregarReproducida(Pelicula nueva) {
		this.reproducidas.add(nueva);
	}
	
}
