package practica4_2OO2.practica5_1;

import java.util.ArrayList;
import java.util.List;

public class Author {
	private String name;
	private List<Album> albums;
	
	public Author(String name) {
		this.albums= new ArrayList<Album>();
		this.name=name;
	}
public void addAlbum(Album newAlbum) {
	this.albums.add(newAlbum);
}
public List<Album> getAlbums(){
	return this.albums;
}
public List<Song> getSongs(){
	 List<Song> songs = new ArrayList<Song>();
	 this.getAlbums().stream().forEach(s -> songs.addAll(s.getSongs()));
	 return songs;	 
}
public String getName() {
	return this.name;
}

}
