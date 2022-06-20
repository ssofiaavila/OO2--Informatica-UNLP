package practica7_3.practica7_3;

import java.util.ArrayList;
import java.util.List;

public class Web {
	private List<User> users;
	private List<Project> projects;
	
	
	public Web() {
		this.users= new ArrayList<User>();
		this.projects= new ArrayList<Project>();
	}
	
	public Project createProject(String name, User owner, double targetAmount) {
		Project p1= new Project(name,owner,targetAmount);
		owner.addProject(p1);
		this.projects.add(p1);
		return p1;
	}
	
	public void invest(Project project, double amount) {
		project.invest(amount);
	}
	
	public double checkInvestedAmount(Project project) {
		return project.getInvestedAmount();
	}
	public void cancellProject(Project project) {
		project.cancell();
	}
}
