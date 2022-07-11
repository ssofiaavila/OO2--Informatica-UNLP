package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public abstract class Persoona {
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private String t;
	private String nya;
	private String tel;
	private Persoonal sis;


	public Persoona(String nombre,String nro, String tipo, Persoonal empresa){
		this.t=tipo;
		this.nya=nombre;
		this.tel=nro;
		this.sis=empresa;
	}

	public void agregarLlamada(Llamada nueva){
		this.llamadas.add(nueva);
	}

	public abstract double calcularMontoTotalLlamadas();



	public List<Llamada> getLlamadas() {
		return llamadas;
	}
	public void setLlamadas(List<Llamada> lista1) {
		this.lista1 = lista1;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public String getNya() {
		return nya;
	}
	public void setNya(String nya) {
		this.nya = nya;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}



}
