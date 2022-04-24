package ejercicio3_6;

public class BasicoSuscripcion implements Subscripcion{

	
	public double calcularCostoDePelicula(Pelicula pelicula) {
		return pelicula.getCosto()+ pelicula.calcularCargoExtraPorEstreno();
	}

}
