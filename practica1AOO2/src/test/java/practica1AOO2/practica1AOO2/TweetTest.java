package practica1AOO2.practica1AOO2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TweetTest {
	User u1;
	Tweet t1;
	
	@BeforeEach
	void setUp() throws Exception {
		u1 = new User("Matias");
		t1 = new Tweet("Mensaje", u1);
	}
	
    @Test
    public void testMessage() {
        assertEquals("Mensaje", t1.getMessage());
    }
}
