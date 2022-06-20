package practica7_2.practica7_2;

public class DineroMailGatewayAdaptee implements MedioDePago{
	private DebitoGateway adaptee;

	public boolean pagar(Pedido pedido) {
		return this.adaptee.pagarMontoConCBU(pedido.getMonto(), pedido.getCliente().getEmail());
	}

}
