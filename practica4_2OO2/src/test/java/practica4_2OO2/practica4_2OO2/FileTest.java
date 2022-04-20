package practica4_2OO2.practica4_2OO2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileTest {
	
	FileOO2 archivo;
	@BeforeEach
	void setUp() throws Exception {
		archivo = new FileOO2("arch1",".txt",164,LocalDate.of(2022, 2, 22),LocalDate.of(2022, 3, 22),"rwx"); //instancio el archivo 
	}
    @Test
    public void testPretty() {
        assertEquals("arch1 - .txt - ", new nameDecorator(new ExtenssionDecorator(archivo)).prettyPrint());
        assertEquals("arch1 - .txt - 2022-02-22 - ", new nameDecorator(new ExtenssionDecorator(new CreationDateDecorator(archivo))).prettyPrint()); //van a ser los decorators que imprmirá
        assertEquals("rwx - arch1 - .txt - 164 - ", new permissionsDecorator(new nameDecorator(new ExtenssionDecorator(new sizeDecorator(archivo)))).prettyPrint());
    }
}