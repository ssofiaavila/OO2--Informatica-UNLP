package practica3AOO2.practica3AOO2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestToDoItem {
	ToDoItem toDo1;
	
	@BeforeEach
	void setUp() {
		toDo1= new ToDoItem();
	}
	
	@Test
	void testConstructor() {
		State estado= toDo1.getState();
		assertEquals("Pending",estado.getState());
	}
	
	@Test
	void testStart() {
		toDo1.start();
		State estado= toDo1.getState();
		assertEquals("In process",estado.getState());
	}
	@Test ///VER CON MATI
	void testPause() {
		
		
	}
	@Test
	void testFinish() {
		toDo1.finish();
		State estado=toDo1.getState();
		assertEquals("Finished",estado.getState());
	}
	@Test 
	void testAddComment(){
		toDo1.addComment("Hola");
		String[] comments= toDo1.getComments();
		assertTrue(comments[0].equals("Hola"));
		
		toDo1.finish();
		toDo1.addComment("Chau");
		comments= toDo1.getComments();
		assertFalse(comments[1].equals("Chau"));
	}
	
	
}
