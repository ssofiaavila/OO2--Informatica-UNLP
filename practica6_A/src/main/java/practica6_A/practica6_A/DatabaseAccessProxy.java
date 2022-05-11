package practica6_A.practica6_A;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseAccessProxy implements DataBaseAccess{
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
	
	//debería incorporarlos en un método a parte??
	
	private void loggingGetSearchResults() throws IOException {
		Logger.getLogger("acceso").addHandler(new FileHandler("log.txt"));
		Logger.getLogger("acceso").log(Level.INFO,"Acceso disponible");
		
		try {
			if (!this.getLogged()) {
				System.out.println("No puede acceder");
			}
			else
				throw new Exception();
		}
		catch (Exception e) {
			Logger.getLogger("acceso").log(Level.SEVERE,"Tiene acceso",e);
		}
		Logger.getLogger("acceso").log(Level.INFO,"Tuvo acceso");
		
	}
	
	private void loggingInsertNewRow() throws IOException{
		Logger.getLogger("acceso").addHandler(new FileHandler("log.txt"));
		Logger.getLogger("acceso").log(Level.INFO,"Acceso disponible");
		
		try {
			if (!this.getLogged()) {
				System.out.println("No puede acceder");
			}
			else
				throw new Exception();
		}
		catch (Exception e) {
			Logger.getLogger("acceso").log(Level.WARNING,"Tiene acceso",e);
		}
		Logger.getLogger("acceso").log(Level.INFO,"Tuvo acceso");
	}
	
	private void loggingGetSeachResult() throws IOException{
		Logger.getLogger("acceso").addHandler(new FileHandler("log.txt"));
		Logger.getLogger("acceso").log(Level.INFO,"Acceso disponible");
		
		try {
			if (this.getLogged()) {
				System.out.println("Puede acceder");
			}
			else
				throw new Exception();
		}
		catch (Exception e) {
			Logger.getLogger("acceso").log(Level.SEVERE,"No tiene acceso",e);
		}
		Logger.getLogger("acceso").log(Level.INFO,"Tuvo acceso");
	}
	
}


