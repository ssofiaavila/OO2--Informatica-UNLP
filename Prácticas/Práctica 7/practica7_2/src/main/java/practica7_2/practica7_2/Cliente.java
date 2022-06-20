package practica7_2.practica7_2;

public class Cliente {
	private String nombre;
	private String apellido;
	private String CBU;
	private String email;
	
	
	public Cliente(String nombre, String apellido, String cBU, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		CBU = cBU;
		this.email = email;
	}


	public String getCBU() {
		return CBU;
	}


	public String getEmail() {
		return email;
	}

	
	
	
	
	
}
