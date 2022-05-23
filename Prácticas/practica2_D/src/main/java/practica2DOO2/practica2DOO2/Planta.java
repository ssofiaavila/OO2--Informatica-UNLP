package practica2DOO2.practica2DOO2;

public class Planta extends Empleado {
	
	private Boolean esCasado;
	private Integer hijos;
	private Integer antiguedad;

	public Planta(String nombre, Boolean esCasado, Integer cantHijos, Integer antiguedad) {
		super(nombre);
		this.esCasado = esCasado;
		this.hijos = cantHijos;
		this.antiguedad = antiguedad;
	}
	
	@Override
	public double getBasico() {
		return 50000;
	}
	
	@Override
	public double getAdicional() {
		return (esCasado ? 5000 : 0) + 2000 * hijos + 2000 * antiguedad;
	}
}
