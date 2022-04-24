package practica2DOO2.practica2DOO2;

public class Temporario extends Empleado {

	private Boolean esCasado;
	private Integer hijos;
	private Integer horasTrabajo;

	public Temporario(String nombre, Boolean esCasado, Integer cantHijos, Integer horasTrabajo) {
		super(nombre);
		this.esCasado = esCasado;
		this.hijos = cantHijos;
		this.horasTrabajo = horasTrabajo;
	}
	
	@Override
	public double getBasico() {
		return 20000 + 300*horasTrabajo;
	} 
	
	@Override
	public double getAdicional() {
		return (esCasado ? 5000 : 0) + 2000 * hijos;
	}
}
