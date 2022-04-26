package ejercicio3_5;

public class Direccion {
	private String localidad, calle, numero, departamento;
	
	public Direccion(String localidad, String calle, String numero, String departamento) {
		this.localidad=localidad;
		this.calle=calle;
		this.numero=numero;
		this.departamento=departamento;
	}
	public String getDireccionFormateada() {
		return this.localidad+ ", "+ this.calle+ ", "+ this.numero +", "+ this.departamento;
	}

}
