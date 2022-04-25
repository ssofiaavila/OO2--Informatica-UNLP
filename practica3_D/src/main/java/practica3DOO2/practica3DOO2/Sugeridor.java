package practica3DOO2.practica3DOO2;

import java.util.List;

public interface Sugeridor {
	public List<Pelicula> recomendar(List<Pelicula> vistas, List<Pelicula> disponibles);
}
