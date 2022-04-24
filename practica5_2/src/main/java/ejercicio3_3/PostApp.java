package ejercicio3_3;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

public class PostApp {
	private List<Post> posts;
	
	
	public PostApp() {
		this.posts= new ArrayList<Post>();
	}
	
	// retorna los ultimos N posts que no pertenecen al usuario user
	//el problema es que hay mucho codigo para un solo método
	public List<Post> ultimosPosts(Usuario user, int cantidad){
		List<Post> postsOtrosUsuarios= this.filtrarPosts(user);
		this.ordenarPorFecha(postsOtrosUsuarios);
		return obtenerNCantidad(cantidad,postsOtrosUsuarios);
	}
	
	public List<Post> filtrarPosts(Usuario usuario){
		List <Post> postsOtros= new ArrayList<Post>();
		for (Post post: this.posts) {
			if (!post.getUsuario().equals(usuario)) {
				postsOtros.add(post);
			}
		}
		return postsOtros;
	}
	public List<Post> obtenerNCantidad(int cant, List<Post> posts){
		List <Post> ultimos= new ArrayList<Post>();
		int index=0;
		java.util.Iterator<Post> postIterator= posts.iterator();
		while (postIterator.hasNext() && index <cant) {
			ultimos.add(postIterator.next());
		}
		return ultimos;
	}
	public void ordenarPorFecha(List<Post> posts){
		for (int i=0; i<posts.size();i++) {
			int masNuevo=i;
			for (int j=i+1; j < posts.size();j++) {
			/*	if (posts.get(j).getFecha()).isAfter(
				     posts.get(masNuevo).getFecha())) {
					masNuevo=j;
				}*/
			}
			Post unPost= posts.set(i,posts.get(masNuevo));
			posts.set(0, unPost);
		}
	}
		
}
