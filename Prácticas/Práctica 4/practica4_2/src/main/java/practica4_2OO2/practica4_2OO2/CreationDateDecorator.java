package practica4_2OO2.practica4_2OO2;

public class CreationDateDecorator extends Decorator{
	
	public CreationDateDecorator(File f) {
		super(f);
	}
	
	@Override
	public String prettyPrint() {
		return this.getFile().getCreationDate() +" - " + this.getFile().prettyPrint();
	}
}