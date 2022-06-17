package practica3DOO2.practica3DOO2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Year;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDecodificador {
	
	Decodificador decoder;
	List<Pelicula> dataBaseMovies;
	
	Pelicula thor = new Pelicula("Thor", 2007, 7.9);
	Pelicula capitanAmerica = new Pelicula("Capitan America", 2016, 7.8);
	Pelicula ironMan = new Pelicula("Iron Man",2010, 7.9);
	Pelicula dunkirk = new Pelicula("Dunkirk", 2017, 7.9);
	Pelicula rocky = new Pelicula("Rocky", 1976, 8.1);
	Pelicula rambo = new Pelicula("Rambo", 1979, 7.8);
	
 	@BeforeEach
	void setUp() throws Exception {
		decoder = new Decodificador();
		// BASE DE DATOS 
		thor.addSPeliculaSimilar(capitanAmerica);
		thor.addSPeliculaSimilar(ironMan);
		capitanAmerica.addSPeliculaSimilar(ironMan);
		rocky.addSPeliculaSimilar(rambo);
		decoder.agregarPelicula(thor);
		decoder.agregarPelicula(capitanAmerica);
		decoder.agregarPelicula(ironMan);
		decoder.agregarPelicula(dunkirk);
		decoder.agregarPelicula(rocky);
		decoder.agregarPelicula(rambo);
		// Peliculas reproducidas
		decoder.agregarReproducida(thor);
		decoder.agregarReproducida(rocky);
 	}
    
 	@Test
    public void testNoveltyStrategy() {
    	decoder.setCriterio(new Similaridad());
    	assertEquals("Dunkirk", decoder.recomendar().get(0).getTitulo());
    	assertEquals("Capitan America", decoder.recomendar().get(1).getTitulo());
    	assertEquals("Iron Man", decoder.recomendar().get(2).getTitulo());
    }
    
    @Test
    public void testSimilarStrategy() {
    	decoder.setCriterio(new Similaridad());
    	assertEquals("Capitan America", decoder.recomendar().get(0).getTitulo());
    	assertEquals("Iron Man", decoder.recomendar().get(1).getTitulo());
    	assertEquals("Rambo", decoder.recomendar().get(2).getTitulo());
    }
    
    @Test
    public void testScoreStrategy() {
    	decoder.setCriterio(new Puntaje());
    	assertEquals("Dunkirk", decoder.recomendar().get(0).getTitulo());
    	assertEquals("Iron Man", decoder.recomendar().get(1).getTitulo());
    	assertEquals("Capitan America", decoder.recomendar().get(2).getTitulo());
    }
}