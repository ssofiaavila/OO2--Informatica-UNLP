package practica4_2OO2.practica5_1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthorTest {
	private Author ysy;
	
	@BeforeEach
	void setUp() {
		this.ysy= new Author("Ysy");
	}
	
	@Test
	public void addAlbumTest() {
		Album antazena= new Album("Antazena");
		antazena.addSong(new Song("Muevelo"));
		antazena.addSong(new Song("Linaje"));
		antazena.addSong(new Song("Hidro"));		
		this.ysy.addAlbum(antazena);
		
		assertEquals(3,this.ysy.getSongs().size());
		
	}
	
}
