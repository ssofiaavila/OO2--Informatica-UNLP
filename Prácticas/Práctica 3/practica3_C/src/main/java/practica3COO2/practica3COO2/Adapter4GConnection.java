package practica3COO2.practica3COO2;

public class Adapter4GConnection implements Connection{
	private Connection4G adaptee;
	
	
	public Adapter4GConnection() {
		this.adaptee= new Connection4G();
	}
	public String pict() {
		return adaptee.symb();
	}

	@Override
	public String sendData(String data, int crc) {
		return adaptee.transmit(data, crc);
	}
}
