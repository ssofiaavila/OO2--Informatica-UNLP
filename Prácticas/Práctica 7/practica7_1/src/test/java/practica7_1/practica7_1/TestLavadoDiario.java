package practica7_1.practica7_1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLavadoDiario {
	private Lavarropas lavarropas;
	private Lavado tipoLavado;
	
	@BeforeEach
	void setUp() {
		this.lavarropas= new Lavarropas();
		this.tipoLavado= new Diario();
		this.lavarropas.setTipoLavado(tipoLavado);
	}
	
	@Test
	void testIniciarLavado() {
		assertEquals(30,this.lavarropas.realizarLavado());
	}
}
