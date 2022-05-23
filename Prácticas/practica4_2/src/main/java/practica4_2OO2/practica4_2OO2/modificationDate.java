package practica4_2OO2.practica4_2OO2;

public class modificationDate extends Decorator{
	public modificationDate(File f) {
		super(f);
	}
	
	@Override
	public String prettyPrint() {
		return this.getFile().getModificationDate() +" - " + this.getFile().prettyPrint();
	}
}
