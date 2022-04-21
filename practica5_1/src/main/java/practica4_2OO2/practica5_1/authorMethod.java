package practica4_2OO2.practica5_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//buscar por autor: dado un String retorna una lista con los temas cuyo nombre de autor contiene o es igual al String recibido como parámetro. La búsqueda es case insensitive
public class authorMethod implements SearchMethod{

	public List<Song> search(String name, List<Author> artists) {
		String searched= name.toUpperCase();
		List<Song> songs= new ArrayList<Song>();
		List <Author> authors= new ArrayList<Author>();
		authors= artists.stream().filter(i -> i.getName().contains(searched)).collect(Collectors.toList());
		authors.stream().forEach(i-> songs.addAll(i.getSongs()));
		return songs;
	}

	
}
