package ejercicio3_6;

public class FamiliaSuscripcion implements Subscripcion{

	
	public double calcularCostoDePelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		return pelicula.getCosto()+ pelicula.calcularCargoExtraPorEstreno()*0.90;
	}

}
