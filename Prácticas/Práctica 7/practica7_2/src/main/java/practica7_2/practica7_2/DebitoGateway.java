package practica7_2.practica7_2;

import java.util.List;

public class DebitoGateway {
	
	
	private boolean autorizarMontoConCBU(double unMonto, String cbu) {
		return true; ///no dice como implementar
	}
	
	
	public boolean pagarMontoConCBU(double unMonto, String cbu) {
		
		if (this.autorizarMontoConCBU(unMonto, cbu)) return true;
		else
			return false;
		
	}
}
