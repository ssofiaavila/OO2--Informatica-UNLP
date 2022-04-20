package practica4_2OO2.practica4_2OO2;

public class ExtenssionDecorator extends Decorator{
	public ExtenssionDecorator(File f) {
		super(f);
	}
	public String prettyPrint() {
		return this.getFile().getExtenssion()+ " "+ this.getFile().prettyPrint();
	}
}
