package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Persoonal {
	private GuiaTelefonica guiaTelefonica = new GuiaTelefonica();
	private List<Persoona> clientes= new ArrayList<Persoona>();
	private List<Llamada> llamadas = new ArrayList<Llamada>();



	public boolean agregarTelefono(String str) {
		return this.guiaTelefonica.agregarTelefono(str);
	}


	public Persoona crearUsuario(String data, String nombre, String tipo){
		Persoona nuevo;
		String nro= this.guiaTelefonica.getTelefono();
		if (tipo.equals("fisica")){
			nuevo= new PersoonaFisica(nombre,data,nro,tipo,this);
		}
		else
			nuevo= new PersoonaJuridica(nombre,data,nro,tipo,this);
		return nuevo;
	}


	public Persoona registrarUsuario(String data, String nombre, String tipo) {
				new Persoona nuevo= this.crearUsuario(data,nombre,tipo);
				this.clientes.add(nuevo);
				return nuevo;
	}

	public boolean eliminarUsuario(Persoona p){
		if (this.usuarios.contains(p)) {
			this.usuarios= usuarios.stream().filter(u -> u != p).collect(Collectors.toList());
			this.guiaTelefonica.agregarTelefono(p.getTelefono());
			return true;
		}
		return false;
	}
	}



	public Llamada registrarLlamada(Persoona q, Persoona q2, String t, int d){
		Llamada nueva;
		if (t.equals("nacional")){
			nueva= new LlamadaNacional(t,q.getTel(),q2.getTel(),d);
			}
		else
			nueva= new LlamadaInternacional(t,q.getTel(),q2.getTel(),d);
		this.llamadas.add(nueva);
		q.agregarLlamada(nueva);
		return nueva;
	}

	public double calcularMontoTotalLlamadas(Persoona p){
		double monto= p.calcularMontoTotalLlamadas();
		return monto;
}


	public int cantidadDeUsuarios() {
		return lista1.size();
	}

	public boolean existeUsuario(Persoona persona) {
		return clientes.contains(persona);
	}

}
