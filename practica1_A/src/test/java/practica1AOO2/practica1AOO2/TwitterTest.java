/**
 * 
 */
package practica1AOO2.practica1AOO2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwitterTest {
	
	Twitter twitter;
	
	@BeforeEach
	void setUp() throws Exception {
		twitter = new Twitter();
	}
	
    @Test
    public void addUserShouldReturnAnUser() {
    	User u = twitter.addUser("Matias");
    	assertNotNull(u);
        assertEquals("Matias", u.getScreenName());
    }
    
    @Test
    public void shouldBeAbleToAddMultipleUsers() {
    	User u1 = twitter.addUser("Matias");
    	User u2 = twitter.addUser("Ezequiel");
    	assertNotNull(u1);
    	assertNotNull(u2);
    	assertEquals(twitter.getUsersCount(), 2);
    }
    
    @Test
    public void addRepeatedUserShouldReturnNull() {
    	User u1 = twitter.addUser("Matias");
    	User u2 = twitter.addUser("Matias");
    	assertNotNull(u1);
    	assertNull(u2);
    	assertEquals(twitter.getUsersCount(), 1);
    }
    
    @Test
    public void shouldBeAbleToRemoveAnExistingUser() {
    	User u1 = twitter.addUser("Matias");
    	User u2 = twitter.addUser("Ezequiel");
    	User u3 = twitter.addUser("Mia");
    	assertEquals(twitter.getUsersCount(), 3);
    	
    	Boolean result = twitter.deleteUser("Matias");
    	assertTrue(result);
    	assertEquals(twitter.getUsersCount(), 2);
    }
    
    @Test
    public void removeAnUnexistingUserShouldReturnFalse() {
    	User u1 = twitter.addUser("Matias");
    	User u2 = twitter.addUser("Ezequiel");
    	User u3 = twitter.addUser("Mia");
    	assertEquals(twitter.getUsersCount(), 3);
    	
    	Boolean result = twitter.deleteUser("Ricardo");
    	assertFalse(result);
    	assertEquals(twitter.getUsersCount(), 3);
    }
}
