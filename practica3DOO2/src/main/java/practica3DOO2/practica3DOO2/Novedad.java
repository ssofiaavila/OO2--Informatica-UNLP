package practica3DOO2.practica3DOO2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Novedad implements Sugeridor {

	public List<Pelicula> recomendar(List<Pelicula> vistas, List<Pelicula> disponibles) {
		List<Pelicula> noReproducidas= disponibles.stream().filter(m -> !(vistas.contains(m))).collect(Collectors.toList());
		return noReproducidas.stream().sorted(Comparator.comparing(Pelicula:: getAnioEstreno).reversed()).limit(3).collect(Collectors.toList());
	}

}
