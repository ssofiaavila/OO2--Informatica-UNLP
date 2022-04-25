package practica4_1OO2.practica4_1OO2;

import java.util.Collection;
import java.util.List;

public class DatabaseAccessProxy implements DatabaseAccess{
	private DatabaseRealAccess database;
	private boolean logged;
	private String password;
	
	public DatabaseAccessProxy(String password, DatabaseRealAccess database) {
		this.logged=false;
		this.database= database;
		this.password=password;
	}
	
	public boolean logIn(String password) {
		if (this.password.equals(password)) {
			this.logged=true;
		}
		return logged;
	}
	
	public boolean getLogged() {
		return this.logged;
	}

	@Override
	public Collection<String> getSearchResults(String queryString) {
		if (this.logged) {
			return this.database.getSearchResults(queryString);
		}
		else return null;
	}

	@Override
	public int insertNewRow(List<String> rowData) {
		if (this.logged) {
			return this.database.insertNewRow(rowData);
		}
		else return -1;
	}
	
}
