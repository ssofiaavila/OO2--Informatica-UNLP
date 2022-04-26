package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

/*BAD SMELLS FOUND IN THIS CLASS 
 1. attibutes's  inappropriate intimacy
 * */

public abstract class Persoona {
	private List<Llamada> llamadas;
	private String nombreYApellido;
	private String telefono;
	private String tipoCliente;
	private Persoonal sistema;
	
	
	public Persoona(String nya, String tel, String tipo, Persoonal sistema) {
		this.nombreYApellido=nya;
		this.telefono=tel;
		this.sistema=sistema;
		this.tipoCliente= tipo;
		this.llamadas= new ArrayList<Llamada>();
	}
	
	public List<Llamada> getLlamadas() {
		return llamadas;
	}
	public void setLista1(List<Llamada> lista1) {
		this.llamadas = lista1;
	}
	public String getNombreYApellido() {
		return nombreYApellido;
	}
	public void setNombreYApellido(String nya) {
		this.nombreYApellido = nya;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String tel) {
		this.telefono = tel;
	}
	public void registrarLlamada(Llamada call) {
		this.llamadas.add(call);
	}
	
	public abstract double generarCobro();
	

	
}
