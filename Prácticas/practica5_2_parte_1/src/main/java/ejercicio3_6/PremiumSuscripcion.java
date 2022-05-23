package ejercicio3_6;

public class PremiumSuscripcion implements Subscripcion{

	
	public double calcularCostoDePelicula(Pelicula pelicula) {
		
		return pelicula.getCosto()*0.75;
	}

}
