package practica7_2.practica7_2;

public class Pedido {
	private Cliente cliente;
	private double monto;
	
	
	
	public Pedido(Cliente cliente, double monto) {
		super();
		this.cliente = cliente;
		this.monto = monto;
	}
	
	public boolean pagarCon(MedioDePago medio) {
		
		return medio.pagar(this);
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public double getMonto() {
		return this.monto;
	}
}
