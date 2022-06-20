package practica7_3.practica7_3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAporte {
	private Web website;
	private User client;
	private Project project;
	
	@BeforeEach
	void setUp() {
		this.website= new Web();
		this.client= new User("Sofia");		
	}
	
	@Test
	void investTest() {
		Project project= this.website.createProject("Vacaciones Kathmandru 2023", client, 5000);
		this.website.invest(project, 500);
		assertEquals(500,project.getCurrentAmount());
		assertEquals("Valid",project.getState().getClass().getSimpleName());
	}
}
