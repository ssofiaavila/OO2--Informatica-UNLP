package practica3COO2.practica3COO2;
import java.util.zip.CRC32;
public class Dispositivo {
	private CRC crcCalculator;
	private Ring ringer;
	private Display display;
	private Connection connection;
	
	public Dispositivo() {
		
	}
	public String send(String data) {
		int crc= crcCalculator.crcFor(data);
		String sent= connection.sendData(data, crc);
		return sent;
	}
	public void changeConnection(Connection nuevo) {
		display.showBanner(connection.pict());
		this.connection=nuevo;
		this.ringer.ring();
	}
	public void setConnection(Connection nuevo) {
		this.connection=nuevo;
	}
	
}
