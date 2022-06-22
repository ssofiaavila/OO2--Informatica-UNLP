package practica1_1.practica1_1;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Twitter {
	private List<User> usuarios;
	
	
	public Twitter() {
		this.usuarios= new ArrayList<User>();
	}
	
	public User agregarUsuario(String nombre) {
		User nuevo= new User(nombre);
		if (usuarios.contains(nuevo)) {
			return null;
		}
		usuarios.add(nuevo);
		return nuevo;		
	}
	
	public boolean eliminarUsuario(String nombre) {
		Iterator <User> i = usuarios.iterator();
		while (i.hasNext()) {
		   User u = i.next();
		   if (u.getScreenName() == nombre) {
			   u.eliminarTweets();
			   i.remove();
			   return true;
		   }
		}
		return false;
	}
	
	public List<User> getUsuarios(){
		return this.usuarios;
	}
	
	public int getCantUsuarios() {
		return this.usuarios.size();
	}
}
