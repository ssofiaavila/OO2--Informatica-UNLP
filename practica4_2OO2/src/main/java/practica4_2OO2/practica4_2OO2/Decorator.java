package practica4_2OO2.practica4_2OO2;

import java.time.LocalDate;

public abstract class Decorator implements File {
	protected File file;
	
	public Decorator(File file) {
		this.file=file;
	}

	public File getFile() {
		return file;
	}
	@Override
	public String getName() {
		return this.file.getName();
	}
	@Override
	public String getExtenssion() {
		return this.file.getExtenssion();
	}
	@Override
	public int getSize() {
		return this.file.getSize();
	}
	@Override
	public LocalDate getCreationDate() {
		return this.file.getCreationDate();
	}
	@Override
	public LocalDate getModificationDate() {
		return this.file.getModificationDate();
	}
	@Override
	public String getPermissions() {
		return file.getPermissions();
	}

	@Override
	public abstract String prettyPrint();
}
