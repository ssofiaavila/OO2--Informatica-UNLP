package practica4_2OO2.practica5_1;

import java.util.ArrayList;
import java.util.List;
//canciones de igual album
public class AlbumMethod implements SearchMethod{

	@Override
	public List<Song> search(String name, List<Author> artists) {
		String searched= name.toUpperCase();
		List<Song> collection= new ArrayList();
		List<Album> sameAlbumName= new ArrayList<Album>();
		artists.stream().forEach(i -> sameAlbumName.addAll(i.getAlbums())); //obtengo todos los albumes
		sameAlbumName.stream().filter(i -> i.getName().contains(searched)).forEach(i -> collection.addAll(i.getSongs())); 
		return collection;
	}
	
}
