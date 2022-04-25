package practica2COO2.practica2COO2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Directorio extends FileSystemEntry {
	
	ArrayList<FileSystemEntry> entries = new ArrayList<FileSystemEntry>();

	public Directorio(String nombre, LocalDate fecha) {
		super(nombre, fecha, 32);
	}
	
	@Override
	public void agregar(FileSystemEntry entry) {
		entries.add(entry);
	}
	
	@Override
	public FileSystemEntry archivoMasGrande() {
		FileSystemEntry masGrande = null;
		for(FileSystemEntry entry : entries) {
			if (entry.isFile() && (masGrande == null || entry.getTamano() > masGrande.getTamano())) {
				masGrande = entry;
			} else if (entry.isFile() == false) {
				FileSystemEntry temp = entry.archivoMasGrande();
				if (temp != null && temp.getTamano() > masGrande.getTamano()) {
					masGrande = entry.archivoMasGrande();
				}
			}
		}
		return masGrande;
	}
	
	@Override
	public FileSystemEntry archivoMasNuevo() {
		FileSystemEntry masNuevo = null;
		for(FileSystemEntry entry : entries) {
			if (entry.isFile() && (masNuevo == null || entry.getFecha().isAfter(masNuevo.getFecha()))) {
				masNuevo = entry;
			} else if (entry.isFile() == false) {
				FileSystemEntry temp = entry.archivoMasNuevo();
				if (temp != null && temp.getFecha().isAfter(masNuevo.getFecha())) {
					masNuevo = temp;
				}
			}
		}
		return masNuevo;
	}
	
	@Override
	public Integer tamanoTotalOcupado() {
		Integer size = this.getTamano();
		for (FileSystemEntry entry : entries) {
			size += entry.tamanoTotalOcupado();
		}
		return size;
	}
}
