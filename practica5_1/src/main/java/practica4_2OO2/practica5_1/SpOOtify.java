package practica4_2OO2.practica5_1;

import java.util.ArrayList;
import java.util.List;

public class SpOOtify {
	private List<User> users;
	private List<Author> artists;
	private SearchMethod method;


public SpOOtify(SearchMethod method) {
	this.users= new ArrayList<User>();
	this.artists= new ArrayList<Author>();
	this.method=method;	
}

public SpOOtify() {
	this.users= new ArrayList<User>();
	this.artists= new ArrayList<Author>();
}

public void addArtist(Author artist) {
	this.artists.add(artist);
}

public void addUser(User user) {
	this.users.add(user);
}

public void setSeachMethod(SearchMethod method) {
	this.method=method;
}

public List<Author> getArtists(){
	return this.artists;
}

public List<Song> search(String name){
	return this.method.search(name,this.getArtists());
	
}
		
}