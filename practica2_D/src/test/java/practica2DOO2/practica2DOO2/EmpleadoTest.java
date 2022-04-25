/**
 * 
 */
package practica2DOO2.practica2DOO2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {
	
	Empleado temp1;
	Empleado temp2;
	Empleado planta1;
	Empleado planta2;
	Empleado pasante1;
	Empleado pasante2;
	
	
	@BeforeEach
	void setUp() throws Exception {
		temp1 = new Temporario("Matias Romero", true, 2, 145);
		temp2 = new Temporario("Luis Perez", false, 0, 80);
		
		planta1 = new Planta("Felipe Melo", false, 0, 2);
		planta2= new Planta("Maria Lopez", true, 1, 10);
		
		pasante1 = new Pasante("Facundo Macia", 0);
		pasante2 = new Pasante("Federico Grosso", 7);
	}
	
    @Test
    public void testSueldos() {
    	
    	assertEquals(81205, temp1.sueldo());
    	assertEquals(49720, temp2.sueldo());
    	assertEquals(60700, planta1.sueldo());
    	assertEquals(84850, planta2.sueldo());
    	assertEquals(22600, pasante1.sueldo());
    	assertEquals(37300, pasante2.sueldo());
        
    }
}
