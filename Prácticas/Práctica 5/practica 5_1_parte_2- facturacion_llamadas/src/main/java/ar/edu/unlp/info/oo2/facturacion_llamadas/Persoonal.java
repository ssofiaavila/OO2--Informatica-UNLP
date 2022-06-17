package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* BAD SMELLS FOUND IN THIS CLASS 
 1. agregarTelefono method --> attribute class not neccesary
 2. registrarUsuario method --> switch sentences "fisica" or "juridica", replace conditional with 
 polymorphism
 3. calcularMontoTotalLLamadas method --> feature envy, move method applied // switch sentences found, polymorpishm applied
 4. eliminarUsuario method --> 
 * 
 */

public class Persoonal {
	List<Persoona> usuarios = new ArrayList<Persoona>();
	List<Llamada> llamadas = new ArrayList<Llamada>();
	private GuiaTelefonica guiaTelefonica = new GuiaTelefonica();
	
	
	// data class
	public boolean agregarTelefono(String str) {
		return this.guiaTelefonica.agregarTelefono(str);
	}
	
	
	
	
	public Persoona crearUsuario(String data, String nombre, String tipo, String telefono, Persoonal sistema) {
		if (tipo.equals("fisica")) {
			return new PersonaFisica(nombre,telefono,data,tipo,sistema);
		}
		else
			return new PersonaJuridica(nombre,telefono,data,tipo,sistema);
	}
	
	private String getNuevoNumero() {
		return this.guiaTelefonica.obtenerNumero();		
	}
	
	
	//long method --> decompose conditional
	// atribute envy
	// //switch sentences --> replace conditional with polymorphism
	public Persoona registrarUsuario(String data, String nombre, String tipo) {
		Persoona nuevo = this.crearUsuario(data,nombre,tipo,this.getNuevoNumero(),this);
		usuarios.add(nuevo);
		return nuevo;
		
	}
	
	public boolean eliminarUsuario(Persoona p) {
		if (this.existeUsuario(p)) {
			this.usuarios= usuarios.stream().filter(u -> u != p).collect(Collectors.toList());
			this.guiaTelefonica.agregarTelefono(p.getTelefono());
			return true;
		}
		return false;		
	}
	
	public Llamada generarLlamada(Persoona emisor, Persoona receptor, String tipo, int duracion) {
		if (tipo.equals("nacional")) {
			return new LlamadaNacional(tipo,emisor.getNombreYApellido(),receptor.getNombreYApellido(),duracion);
			
		}
		return new LlamadaInternacional(tipo,emisor.getNombreYApellido(),receptor.getNombreYApellido(),duracion);
	}
	
	
	public Llamada registrarLlamada(Persoona emisor, Persoona receptor, String tipo, int duracion) {
		Llamada nueva= this.generarLlamada(emisor,receptor,tipo,duracion);
		this.llamadas.add(nueva);
		emisor.registrarLlamada(nueva);
		return nueva;
		
	}
	//feature envy --> move method
	//sentencias switch --> replace confitional with polymorphism
	public double calcularMontoTotalLlamadas(Persoona usuario) {
		if (this.existeUsuario(usuario)) {
			return usuario.generarCobro();
		}		
		return 0;
	}

	public int cantidadDeUsuarios() {
		return usuarios.size();
	}

	public boolean existeUsuario(Persoona persona) {
		return usuarios.contains(persona);
	}
	
	
	
}
