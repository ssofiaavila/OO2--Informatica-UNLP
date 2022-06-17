package practica1AOO2.practica1AOO2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
	private String screenName;
	private List<Tweet> tweets;
	
	
	public User(String name) {
		this.screenName=name;
		this.tweets= new ArrayList<Tweet>();
	}


	public String getScreenName() {
		return this.screenName;
	}
	
	public void deleteAccount() {
		this.tweets.clear();
	}
	
	public Tweet createTweet(String tweet) { //idem
		Tweet tuit= new Tweet(tweet,this);
		this.tweets.add(tuit);
		return tuit;
		
	}
	public Tweet retweet(Tweet original, String tweet) { //idem
		Tweet tuit= new Tweet(tweet,original,this);
		this.tweets.add(tuit);
		return tuit;
	}
	public List<Tweet> getTweets(){
		return this.tweets;
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


	public Integer getTweetsCount() {
		return this.tweets.size();
	}
	
	
	
}
