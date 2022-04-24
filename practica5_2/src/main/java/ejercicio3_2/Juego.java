package ejercicio3_2;

import java.util.ArrayList;
import java.util.List;

public class Juego {
	
	
	private List<Jugador> jugadores;

	public Juego() {
		this.jugadores= new ArrayList<Jugador>();
	}
	
	public void incrementar(Jugador j) {
		j.incrementar();
	}
	public void decrementar(Jugador j) {
		j.decrementar();
	}
}
