package practica3COO2.practica3COO2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDispositivo {
	private Dispositivo disp;
	
	@BeforeEach
	void setUp() {
		disp= new Dispositivo(new CRC32_Calculator(), new Adapter4GConnection());
	}
	
	@Test
	void testSend() {
		Connection nueva= new WifiConn();
		disp.setConnection(nueva);
		String enviado= disp.send("Hola");
		assertEquals("Hola", enviado);
	}
	@Test
	public void connectTest() {
		assertEquals(disp.changeConnection(new WifiConn()),"Metodo de conexion cambiado");
	}
	@Test
	public void setCRCTest() {
		assertEquals(disp.setCRC(new CRC16_Calculator()),"Configuracion CRC cambiada");
	}
}
