package unq.tpi.persistencia.performance.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import org.junit.Assert;

public  abstract class BaseTest {
	
	protected void assertListadoLength(int lines, String fileName) throws IOException {
		LineNumberReader reader = new LineNumberReader(new FileReader(fileName));
		try {
			reader.skip(Long.MAX_VALUE);
			Assert.assertEquals("Incorrecta cantidad de lineas", lines, reader.getLineNumber() + 1);
		} finally {
			reader.close();
		}
	}

}
