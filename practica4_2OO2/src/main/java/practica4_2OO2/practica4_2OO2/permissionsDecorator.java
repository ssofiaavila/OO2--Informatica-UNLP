package practica4_2OO2.practica4_2OO2;

import java.time.LocalDate;

public class permissionsDecorator extends Decorator{
	public permissionsDecorator(File f) {
		super(f);
	}
	
	@Override
	public String prettyPrint() {
		return this.getFile().getPermissions() + " - " + this.getFile().prettyPrint();
	}
}