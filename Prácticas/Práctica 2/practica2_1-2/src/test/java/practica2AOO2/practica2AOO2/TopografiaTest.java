/**
 * 
 */
package practica2AOO2.practica2AOO2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TopografiaTest {
	
	Topografia topografiaA;
	Topografia topografiaB;
	Topografia topografiaC;
	Topografia topografiaD;
	
	Topografia topografiaD_bis;
	Topografia topografiaF;
	
	Topografia topografiaConPantano1;
	Topografia topografiaConPantano2;
	Topografia topografiaMixtaConPantano3;
	
	@BeforeEach
	void setUp() throws Exception {
		Agua agua = new Agua();
		Tierra tierra = new Tierra();
		
		topografiaA = agua;
		topografiaB = tierra;
		topografiaC = new ConjuntoElementos(agua, tierra, tierra, agua);
		topografiaD = new ConjuntoElementos(agua, tierra, tierra, new ConjuntoElementos(agua, tierra, tierra, agua));
		
		topografiaD_bis = new ConjuntoElementos(agua, tierra, tierra, new ConjuntoElementos(tierra, agua, agua, tierra));
		
		topografiaF = new ConjuntoElementos(agua, tierra, tierra, new ConjuntoElementos(agua, tierra, tierra, agua));
		
		topografiaConPantano1 = new Pantano();
		topografiaConPantano2 = new Pantano();
		topografiaMixtaConPantano3 = new ConjuntoElementos(new Agua(), new Tierra(), new Pantano(), new ConjuntoElementos(new Agua(), new Tierra(), new Tierra(), new Pantano()));
	}
	
    @Test
    public void checkProporciones() {
    	double proporcionA = topografiaA.getProportion();
    	double proporcionB = topografiaB.getProportion();
    	double proporcionC = topografiaC.getProportion();
    	double proporcionD = topografiaD.getProportion();
    	
    	double proporcionPantano = topografiaConPantano1.getProportion();
    	double proporcionMixtaConPantanoD = topografiaMixtaConPantano3.getProportion();
    	
        assertEquals(1, proporcionA);
        assertEquals(0, proporcionB);
        assertEquals(0.5, proporcionC);
        assertEquals(0.375, proporcionD);
        assertEquals(0.7, proporcionPantano);
        assertEquals(0.53125, proporcionMixtaConPantanoD);
    }
    
    @Test
    public void checkearIgualdad() {
        assertFalse(topografiaA.equals(topografiaB));
        assertTrue(topografiaA.equals(new Agua()));
        assertTrue(topografiaB.equals(new Tierra()));
        assertFalse(topografiaA.equals(topografiaC));
        assertFalse(topografiaC.equals(topografiaD));
        assertFalse(topografiaD.equals(topografiaD_bis));
        assertTrue(topografiaC.equals(new ConjuntoElementos(new Agua(), new Tierra(), new Tierra(), new Agua())));
        assertTrue(topografiaD.equals(topografiaF));
        assertTrue(topografiaConPantano1.equals(topografiaConPantano2));
        assertFalse(topografiaMixtaConPantano3.equals(topografiaC));
    }
}
