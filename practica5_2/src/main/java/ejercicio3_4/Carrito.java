package ejercicio3_4;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private List<ItemCarrito> items;
	
	public Carrito() {
		this.items= new ArrayList<ItemCarrito>();
	}
	
	public double total() {
		return this.items.stream().mapToDouble(item -> item.getTotal()).sum();
	}
}
