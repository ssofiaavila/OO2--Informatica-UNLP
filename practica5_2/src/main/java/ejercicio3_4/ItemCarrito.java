package ejercicio3_4;

public class ItemCarrito {
	private int cantidad;
	private Producto producto;
	
	public ItemCarrito(Producto pdto) {
		this.producto=pdto;
	}
	public Producto getProducto() {
		return this.producto;
	}
	public int getCantidad() {
		return this.cantidad;
	}
	public double getTotal() {
		return this.producto.getPrecio()*this.cantidad;
	}
	
}
