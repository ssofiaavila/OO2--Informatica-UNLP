package practica4_2OO2.practica5_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//debo buscar canciones cuyo titulo es igual al parametro name
public class titleMethod implements SearchMethod {

	@Override
	public List<Song> search(String name, List<Author> artists) {
		String buscado= name.toUpperCase();
		List<Song> collection= new ArrayList<Song>();
		artists.stream().forEach(i -> collection.addAll(i.getSongs()));
		return collection.stream().filter(i -> i.getName().contains(buscado)).collect(Collectors.toList());
}
}