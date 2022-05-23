package ejercicio3_6;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private int telefono;
	private Subscripcion tipoSubscripcion;
	private String email;
	private List<Pelicula> peliculasCompradas;
	
	public Usuario(String nombre, int telefono, Subscripcion tipo, String email) {
		this.nombre=nombre;
		this.telefono=telefono;
		this.tipoSubscripcion=tipo;
		this.email=email;
		this.peliculasCompradas= new ArrayList<Pelicula>();
	}
	
	public void setTipoSubscripcion(Subscripcion subs) {
		this.tipoSubscripcion=subs;
	}
	
	public double calcularCostoDePelicula(Pelicula pelicula) {
		return tipoSubscripcion.calcularCostoDePelicula(pelicula);
	}
}
