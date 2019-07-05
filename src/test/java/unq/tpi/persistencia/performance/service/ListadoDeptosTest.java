package unq.tpi.persistencia.performance.service;

import java.io.IOException;

import org.junit.Test;

public class ListadoDeptosTest extends BaseTest {
	
	@Test
	public void testListadoDeptos() throws IOException {
		String fileName = "./target/Deptos.csv";
		new ListadoDeptos(fileName).generarListado();
		this.assertListadoLength(11, fileName);
	}
	
}
