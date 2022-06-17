package practica4_2OO2.practica4_2OO2;

public class nameDecorator extends Decorator{
	
	public nameDecorator(File f) {
		super(f);
	}
	
	@Override
	public String prettyPrint() {
		return this.getFile().getName() +" - " + this.getFile().prettyPrint();
	}

}