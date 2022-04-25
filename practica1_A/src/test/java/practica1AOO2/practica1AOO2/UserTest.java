package practica1AOO2.practica1AOO2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
	
	User u1;
	User u2;
	
	@BeforeEach
	void setUp() throws Exception {
		u1 = new User("Matias");
		u2 = new User("Ezequiel");
	}
	
    @Test
    public void twoUsersShouldBeComparable() {
    	User u3 = new User("Matias");
    	
    	assertNotEquals(u1,  u2);
    	assertEquals(u1, u3);
    }
    
    @Test
    public void addTweetShouldAddANewTweet() {
    	Tweet t1 = u1.createTweet("Mensaje");
    	assertNotNull(t1);
    	assertEquals(t1.getOwner(), u1);
    	assertEquals(u1.getTweetsCount(), 1);
    }
    
    @Test
    public void addTweetsShouldAddAGroupOfTweets() {
    	Tweet t1 = u1.createTweet("Mensaje x");
    	Tweet t2 = u1.createTweet("Mensaje x");
    	Tweet t3 = u1.createTweet("Mensaje y");
    	Tweet t4 = u1.createTweet("Mensaje z");
    	assertEquals(u1.getTweetsCount(), 4);
    }
    
    @Test
    public void addRetweetShouldAddANewTweet() {
    	Tweet t1 = u1.createTweet("Mensaje x");
    	Tweet retweet = u1.retweet( t1,"A Retweet");
    	assertEquals(u1.getTweetsCount(), 2);
    	assertEquals(t1.getMessage(), "Mensaje x");
    	assertEquals(retweet.getMessage(), "A Retweet");
    	assertNotNull(retweet.getParent());
    	assertEquals(((Throwable) retweet.getParent()).getMessage(), "Mensaje x");
    }
    
    @Test
    public void addTweetWithWrongMessageShouldThrowAnException() {
    	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
    		Tweet t1 = u1.createTweet("");
        });
    	assertEquals(exception.getMessage(), "Message must be between 1 and 140 characters");
    }
}
