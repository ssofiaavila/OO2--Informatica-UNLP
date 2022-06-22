package practica1_1.practica1_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

	private String screenName;
	private List<Tweet> tweets;
	

	public User(String nombre) {
		this.screenName=nombre;
		this.tweets= new ArrayList<Tweet>();		
	}
	
	public Tweet crearTweet(String mensaje) {
		Tweet nuevo= new Tweet(mensaje,this);
		this.tweets.add(nuevo);
		return nuevo;
	}
	
	public Tweet retwittear(String mensaje, Tweet origen) {
		Tweet nuevo= new Tweet(mensaje,this,origen);
		this.tweets.add(nuevo);
		return nuevo;		
	}
	

	public void eliminarTweets() {
		this.tweets.removeAll(tweets);		
	}
	
	

	public String getScreenName() {
		return this.screenName;
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;

	    User user = (User) o;

	    return screenName == user.screenName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(screenName);
	}

	

}
