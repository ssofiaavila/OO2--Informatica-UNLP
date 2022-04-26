package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public class PersonaFisica extends Persoona{
	private String DNI;
	
	public PersonaFisica(String nombreYApellido,String telefono, String dni, String tipo, Persoonal sistema) {
		super(nombreYApellido,telefono,tipo, sistema);
		this.DNI=dni;
	}

	@Override
	public double generarCobro() {
		List<Llamada> calls= this.getLlamadas();
		total= calls.stream().mapToDouble(l -> l.getValor()).sum();
	}
}
