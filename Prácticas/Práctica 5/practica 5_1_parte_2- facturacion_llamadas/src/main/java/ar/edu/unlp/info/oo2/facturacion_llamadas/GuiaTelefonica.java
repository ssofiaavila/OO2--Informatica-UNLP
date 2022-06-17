package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.TreeSet;
import java.util.SortedSet;
/*BAD SMELLS FOUND IN THIS CLASS 
 1. data class
 
 * */
public class GuiaTelefonica {
	private  SortedSet<String> guia = new TreeSet<String>(); //refactored

	public boolean agregarTelefono(String str) {
		if (this.existeTelefono(str)) {
			return false;
		}
		else {
			this.guia.add(str);
			return true;
		}
		
	}
	public boolean existeTelefono(String num) {
		return this.guia.contains(num);
	}
	public String obtenerNumero() {
		if (!guia.isEmpty()) {
			String nro= this.guia.last();
			this.guia.remove(nro);
			return nro;
		}
		else return null;
		
	}
	

}
