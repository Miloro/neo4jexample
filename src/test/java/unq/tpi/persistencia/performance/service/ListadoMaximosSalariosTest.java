package unq.tpi.persistencia.performance.service;

import java.io.IOException;

import org.junit.Test;

public class ListadoMaximosSalariosTest extends BaseTest {
	
	@Test
	public void testListadoMaximosSalarios() throws IOException {
		String fileName = "./target/MaximosSalarios.csv";
		new ListadoMaximosSalarios(fileName).generarListado();
		this.assertListadoLength(12, fileName);
	}

}
