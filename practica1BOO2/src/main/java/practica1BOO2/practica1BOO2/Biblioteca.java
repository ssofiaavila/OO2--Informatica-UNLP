package practica1BOO2.practica1BOO2;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<Socio> socios; //tengo coleccion de socios
	private VoorheesExporter exporter;

	public Biblioteca() {
		socios = new ArrayList<>();
		exporter= new VoorheesExporter(); 
	}

	public void agregarSocio(Socio socio) { //agrego socio a la coleccion
		socios.add(socio); 
	}

	/**
	 * Retorna la representación JSON de la colección de socios.
	 */
	public String exportarSocios() {
		return exporter.exportar(socios);
	}

	public VoorheesExporter getExporter() { //obtengo clase exportadora
		return exporter;
	}

	public void setExporter(VoorheesExporter exporter) { 
		this.exporter = exporter;
	}
	
}
