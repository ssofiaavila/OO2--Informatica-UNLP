package practica4_2OO2.practica5_1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpOOtifyTest {
	private SpOOtify platform;
	private Album postmortem,antazena,trap;
	private Author dillom,ysy;
	
	
	@BeforeEach
	void setUp() {
		this.platform= new SpOOtify();
		
		postmortem= new Album("Post mortem");
		antazena= new Album("Antazena");
		trap= new Album("Trap de verdad");
		
		postmortem.addSong(new Song("Opa"));
		postmortem.addSong(new Song("Rocketpowers"));
		postmortem.addSong(new Song("Muevelo"));
		
		antazena.addSong(new Song("Linaje"));
		antazena.addSong(new Song("Muevelo"));
		antazena.addSong(new Song("Hidro"));
		
		
		dillom= new Author("Dillom");
		dillom.addAlbum(postmortem);
		ysy= new Author("Ysy");
		ysy.addAlbum(antazena);
		
		this.platform.addArtist(dillom);
		this.platform.addArtist(ysy);
		
		
	}
	
	@Test
	public void addingArtitsTest() {
		assertEquals(2,this.platform.getArtists().size());	
	}
	
	@Test //working
	public void titleSearchMethodTest() {
		this.platform.setSeachMethod(new titleMethod());
		assertEquals(2, this.platform.search("Muevelo").size());		
	}
	@Test
	public void authorSearchMethodTest() {
		this.platform.setSeachMethod(new authorMethod());
		assertEquals(3,this.platform.search("Ysy").size());
	}
	@Test
	public void albumSearchMetodTest() {
		this.platform.setSeachMethod(new AlbumMethod());
		assertEquals(3,this.platform.search("Antazena").size());
	}
	
}
