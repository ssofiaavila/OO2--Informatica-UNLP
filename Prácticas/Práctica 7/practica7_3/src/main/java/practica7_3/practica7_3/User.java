package practica7_3.practica7_3;

import java.util.ArrayList;
import java.util.List;

public class User {
	private List<Project> projects;
	private String userName;
	
	public User(String name) {
		this.userName= name;
		projects= new ArrayList<Project>();
	}
	
	public List<Project> getProjects(){
		return this.projects;
	}
	
	public void addProject(Project project) {
		this.projects.add(project);
	}
	
	
}
