package practica4_2OO2.practica5_1;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private List<Song> myMusic;
	
	
	
	public User(String name) {
		this.name=name;
		this.myMusic= new ArrayList<Song>();
	}
	public String getName() {
		return this.name;
	}
	public void addSong(Song songs) {
		this.myMusic.add(songs);
	}
	public boolean deleteSong(Song song) {
		return this.myMusic.remove(song);
	}
}
