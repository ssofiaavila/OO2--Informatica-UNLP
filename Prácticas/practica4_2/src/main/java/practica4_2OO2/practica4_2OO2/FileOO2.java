package practica4_2OO2.practica4_2OO2;

import java.time.LocalDate;

public class FileOO2 implements File{
	private String name;
	private String extenssion;
	private int size;
	private LocalDate fechaCreacion;
	private LocalDate fechaModificacion;
	private String permissions;
	
	
	
	public FileOO2(String nombre, String extension, int tamaño, LocalDate fechaCreacion, LocalDate fechaModificacion,
			String permisos) {
		super();
		this.name = nombre;
		this.extenssion = extension;
		this.size = tamaño;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.permissions = permisos;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public String getExtenssion() {
		return extenssion;
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public LocalDate getCreationDate() {
		return fechaCreacion;
	}
	@Override
	public LocalDate getModificationDate() {
		return fechaModificacion;
	}
	@Override
	public String getPermissions() {
		return permissions;
	}
	
	@Override
	public String prettyPrint() {
		return "";
	}
	
	
}