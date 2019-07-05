package unq.tpi.persistencia.performance.service;

import java.util.List;

import unq.tpi.persistencia.performance.dao.EmployeeDAO;
import unq.tpi.persistencia.performance.model.Employee;

public class ListadoMaximosSalarios extends AbstractListado {

	public ListadoMaximosSalarios(String fileName) {
		super(fileName);
	}

	@Override
	public void doListado() throws Exception {
		// Trae todos los empleados y los ordena descendientemente por sueldo
		List<Employee> empleados = new EmployeeDAO().getEmployeesWithBestSalaries(10);

		// Imprime el sueldo de los 10 primeros empleados en la coleccion
		this.addColumn("Nombre").addColumn("Sueldo").newLine();
		for (int i = 0; i <= 9; i++) {
			Employee empleado = empleados.get(i);
			this.addColumn(empleado.getFullName())
				.addColumn(empleado.getSalary())
				.newLine();
		}
	}
	
}
