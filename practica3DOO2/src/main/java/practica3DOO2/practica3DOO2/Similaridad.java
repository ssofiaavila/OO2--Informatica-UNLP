package practica3DOO2.practica3DOO2;

import java.util.Comparator;
import java.util.List;

public class Similaridad implements Sugeridor{

	@Override
	public List<Pelicula> recomendar(List<Pelicula> vistas, List<Pelicula> disponibles) {
		List<Pelicula> noReproducidas= disponibles.stream().filter(m -> (vistas.contains(m))).toList().stream().sorted(Comparator.comparing(Pelicula :: getAnioEstreno).reversed()).toList();
		return noReproducidas.stream().filter(m -> vistas.stream().anyMatch(aux -> ((List<Pelicula>) aux).contains(m))).limit(3).toList();
	}

}
