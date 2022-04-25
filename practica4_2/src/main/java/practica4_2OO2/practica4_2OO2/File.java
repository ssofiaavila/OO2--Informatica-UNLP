package practica4_2OO2.practica4_2OO2;

import java.time.LocalDate;

public interface File {
	public String getName();
	public String getExtenssion();
	public int getSize();
	public LocalDate getCreationDate();
	public LocalDate getModificationDate();
	public String getPermissions();
	public String prettyPrint();
}