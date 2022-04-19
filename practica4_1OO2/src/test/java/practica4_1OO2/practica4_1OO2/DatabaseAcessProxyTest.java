package practica4_1OO2.practica4_1OO2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class DatabaseAcessProxyTest {
	private DatabaseAccessProxy proxy;
	private DatabaseRealAccess database;
	@BeforeEach
	public void setUp() {
		this.database = new DatabaseRealAccess();
		this.proxy= new DatabaseAccessProxy("1234",database);
	}
	@Test
	public void testLogIn() {
		this.proxy.logIn("1234");
		assertTrue(this.proxy.getLogged());		
	}
	@Test
	public void testGetSearchResults() {
		this.proxy.logIn("abcd");
		assertEquals(null, this.proxy.getSearchResults("select * from comics where id=1"));
		
		this.proxy.logIn("1234");
		assertEquals(Arrays.asList("Spiderman", "Marvel"), this.proxy.getSearchResults("select * from comics where id=1"));
	}
	@Test
	public void testInsertNewRow() {
		this.proxy.logIn("abcd");
		assertEquals(-1,this.proxy.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
		this.proxy.logIn("1234");
		 assertEquals(3, this.proxy.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
		
	}
	
	
}
