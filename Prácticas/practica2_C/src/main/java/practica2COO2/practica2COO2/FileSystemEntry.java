package practica2COO2.practica2COO2;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class FileSystemEntry {

	private String nombre;
	private LocalDate fecha;
	private Integer tamano;
	
	public FileSystemEntry(String nombre, LocalDate fecha, Integer tamano) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.tamano = tamano;
	}
	
	public String getNombre() {
		return nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	public Integer getTamano() {
		return tamano;
	}
	
	public void agregar(FileSystemEntry entry) {
		throw new UnsupportedOperationException();
	}
	
	public FileSystemEntry archivoMasNuevo() {
		throw new UnsupportedOperationException();
	}
	
	public FileSystemEntry archivoMasGrande() {
		throw new UnsupportedOperationException();
	}
	
	public Integer tamanoTotalOcupado() {
		throw new UnsupportedOperationException();
	}
	
	public Boolean isFile() {
		return false;
	}
}
