package unq.tpi.persistencia.performance.service;

import java.io.IOException;

import org.junit.Test;

public class ListadoDetalleEmpleadoTest extends BaseTest {
	
	@Test
	public void testDetalleEmpleado1() throws IOException {
		String filename = "./target/DetalleEmpleado-10010.csv";
		new ListadoDetalleEmpleado(filename, 10010).generarListado();
		this.assertListadoLength(16, filename);
	}

	@Test
	public void testDetalleEmpleado2() throws IOException {
		String filename = "./target/DetalleEmpleado-10019.csv";
		new ListadoDetalleEmpleado(filename, 10019).generarListado();
		this.assertListadoLength(14, filename);
	}
	
}
