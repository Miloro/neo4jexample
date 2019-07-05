package unq.tpi.persistencia.performance.service;

import java.io.IOException;

import org.junit.Test;

public class ListadoPagosPorDeptoTest extends BaseTest {

	@Test
	public void testListadoPagosPorDepto() throws IOException {
		String filename = "./target/PagosPorDepto-d007.csv";
		new ListadoPagosPorDepto(filename, "d007").generarListado();
		this.assertListadoLength(37_706, filename);
	}
	
}
