package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.TreeSet;
import java.util.SortedSet;

public class GuiaTelefonica {
	private SortedSet<String> guia;


	public GuiaTelefonica(){
			this.guia= new TreeSet<String>();
	}

	public boolean agregarTelefono(String str) {
		if (!this.guia.contains(str)){
			this.guia.add(str);
			return true
		}
		else
			return false;
		}

		public String getTelefono(){
			String tel = guia.last();
			guia.remove(tel);
			return tel;
		}






}
