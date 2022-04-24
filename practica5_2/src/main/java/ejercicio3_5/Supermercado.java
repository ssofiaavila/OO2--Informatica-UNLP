package ejercicio3_5;

import java.text.MessageFormat;

public class Supermercado {
	
	public void notificarPedido(int nroPedido, Cliente cliente) {
		String notificacion= MessageFormat.format("Estimado cliente, se le informa que hemos recibido su pedido con nuemero {0}, el cual será enviado a la direccion {1}", new Object[] {nroPedido, cliente.getDireccionFormateada()});
		System.out.println(notificacion);
	}
}
