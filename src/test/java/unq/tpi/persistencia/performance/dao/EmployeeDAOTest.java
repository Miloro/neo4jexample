package unq.tpi.persistencia.performance.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import unq.tpi.persistencia.performance.model.Employee;
import unq.tpi.persistencia.performance.model.Gender;
import unq.tpi.persistencia.performance.service.runner.Runner;

public class EmployeeDAOTest {

	@Test
	public void testFields() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = sdf.parse("1960-03-16");
		Date hireDate = sdf.parse("1988-11-11");
		
		Runner.runInSession(() -> {
			Employee e = new EmployeeDAO().getByName("Parto", "Hitomi");
			
			Assert.assertNotNull(e);
			Assert.assertEquals(11052, e.getId());
			Assert.assertEquals(birthDate, e.getBirthDate());
			Assert.assertEquals(Gender.F, e.getGender());
			Assert.assertEquals(hireDate, e.getHireDate());
			Assert.assertEquals(0,e.getDepartments().size());
			Assert.assertNull(e.getDepartment());
			Assert.assertEquals(2,e.getHistoricDepartments().size());
			Assert.assertNull(e.getTitle());
			Assert.assertEquals(1,e.getHistoricTitles().size());
			Assert.assertEquals(51339.0, e.getSalary(), 0);
			return null;
		});
	}
}
