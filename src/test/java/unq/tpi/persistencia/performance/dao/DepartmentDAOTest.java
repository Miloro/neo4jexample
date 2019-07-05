package unq.tpi.persistencia.performance.dao;

import org.junit.Assert;
import org.junit.Test;

import unq.tpi.persistencia.performance.model.Department;
import unq.tpi.persistencia.performance.service.runner.Runner;

public class DepartmentDAOTest {

	@Test
	public void testFields() throws Exception {
		Runner.runInSession(() -> {
			Department d = new DepartmentDAO().getByName("Finance");
			Assert.assertNotNull(d);
			Assert.assertEquals("d002", d.getCode());
			Assert.assertEquals(12437, d.getEmployees().size());
			Assert.assertEquals(4909, d.getHistoricEmployees().size());
			return null;
		});
	}
	
}
