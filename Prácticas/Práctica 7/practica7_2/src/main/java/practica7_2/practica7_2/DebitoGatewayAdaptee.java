package practica7_2.practica7_2;

public class DebitoGatewayAdaptee implements MedioDePago {
	private DebitoGateway adaptee;

	public boolean pagar(Pedido pedido) {
		return adaptee.pagarMontoConCBU(pedido.getMonto(), pedido.getCliente().getCBU());
	}

}
