package practica4_2OO2.practica5_1;

import java.util.ArrayList;
import java.util.List;
//canciones de igual album
public class AlbumMethod implements SearchMethod{

	@Override
	public List<Song> search(String name, List<Author> artists) {
		String searched= name.toUpperCase();
		List <Song> songs= new ArrayList<Song>();
		List<Album> albums = new ArrayList<Album>();
		artists.stream().forEach(a -> albums.addAll(a.getAlbums()));
		albums.stream().filter(a -> a.getName().contains(name)).forEach(a -> songs.addAll(a.getSongs()));
		return songs;
	}
	
}
