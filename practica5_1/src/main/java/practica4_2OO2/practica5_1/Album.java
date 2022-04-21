package practica4_2OO2.practica5_1;

import java.util.ArrayList;
import java.util.List;

public class Album {
	private String name;
	private List<Song> songs;
	
	
	public Album(String name) {
		this.name=name;
		this.songs= new ArrayList<Song>();
	}
	
	public void addSong(Song song) {
		this.songs.add(song);
		
	}
	public List<Song> getSongs(){
		return this.songs;
	}
	public String getName() {
		return this.name;
	}
}
