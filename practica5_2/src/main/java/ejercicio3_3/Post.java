package ejercicio3_3;

import java.time.LocalDateTime;

public class Post {
	private String texto;
	private LocalDateTime fecha;
	private Usuario usuario;
	
	
	public Post(LocalDateTime fecha, String txt, Usuario usuario) {
		this.texto= txt;
		this.fecha=fecha;
		this.usuario=usuario;
	}
	public Usuario getUsuario() {
		return this.usuario;
	}
	public Object getFecha() {
		return this.fecha;
	}
}
