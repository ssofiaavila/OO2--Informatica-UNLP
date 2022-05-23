package practica1AOO2.practica1AOO2;

public class Tweet {
	private Tweet source;
	private boolean isRetweet;
	private String tweet;
	private User owner;
	
	public Tweet(String tweet, User ownwer) {
		if (tweet.length()<1 || tweet.length() > 140) {
			throw new IllegalArgumentException("Less than a char");
		}
		this.tweet=tweet;
		this.owner=owner;
	}
	//ver valores que tendria si llamo al primer constructor
	
	public Tweet( String tweet,Tweet source, User owner) {
		this(tweet, owner);
		this.source=source;
		this.isRetweet=true;
	}
	public boolean getIsRetweet() {
		return this.isRetweet;
	}
	public Tweet getSource() {
		return this.source;
	}
	public String getMessage() {
		return this.tweet;
	}

	public Object getOwner() {
		
		return this.owner;
	}

	public Object getParent() {
		return this.source;
	}
	
}
