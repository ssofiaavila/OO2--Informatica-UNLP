package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaJuridica extends Persoona{
	private String cuit;
	
	public PersonaJuridica(String nombreYApellido, String telefono,String cuit, String tipo, Persoonal sistema) {
		super(nombreYApellido, telefono, tipo, sistema);
		this.cuit=cuit;
	}
	@Override
	public double getDescuento() {
		return 0.15;
	}

	
	
	

}
