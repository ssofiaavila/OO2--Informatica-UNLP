package practica1AOO2.practica1AOO2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;



public class Twitter {
	private List<User> users;
	
	
	public Twitter() {
		this.users= new ArrayList<User>();
	}
	
	
	// ver
	public User addUser(String user) {
		User newUser = new User(user);
		if (users.contains(newUser))
			return null;
		users.add(newUser);
		return newUser;
	}
	
	public boolean deleteUser(String screenName) {
		Iterator<User> i = users.iterator();
		while (i.hasNext()) {
		   User u = i.next();
		   if (u.getScreenName() == screenName) {
			   i.remove();
			   return true;
		   }
		}
		return false;
	}

	public List<User> getUsers() {
		return this.users;
		
	}


	public Integer getUsersCount() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
