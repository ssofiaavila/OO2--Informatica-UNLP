package practica2COO2.practica2COO2;

import java.time.LocalDate;

public class Archivo extends FileSystemEntry {

	public Archivo(String nombre, LocalDate fecha, Integer tamano) {
		super(nombre, fecha, tamano);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Integer tamanoTotalOcupado() {
		return getTamano();
	}
	
	@Override
	public Boolean isFile() {
		return true;
	}
}
