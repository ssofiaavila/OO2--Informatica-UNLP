package practica4_2OO2.practica4_2OO2;

public class sizeDecorator extends Decorator{
	public sizeDecorator(File f) {
		super(f);
	}
	
	@Override
	public String prettyPrint() {
		return this.getFile().getSize() + " - " + this.getFile().prettyPrint();
	}
}