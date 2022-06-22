package practica1_1.practica1_1;

public class Tweet {
	private Tweet tweetOrigen;
	private boolean esRetweet;
	private String mensaje;
	private User propietario;
	
	public Tweet(String mensaje, User propietario) {
		if ((mensaje.length() >= 1) && (mensaje.length() <= 140)) {
			this.tweetOrigen=null;
			this.esRetweet=false;
			this.mensaje=mensaje;
			this.propietario=propietario;
		}
		else
			new RuntimeException("El mensaje tiene que tener al menos un caracter");
	}
	
	public Tweet(String mensaje, User propietario, Tweet origen) {
		this(mensaje,propietario);
		this.tweetOrigen=origen;
		this.esRetweet=true;
	}
	
	public boolean esRetweet() {
		return this.esRetweet;
	}

}
