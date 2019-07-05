package unq.tpi.persistencia.performance.service;

import java.util.List;

import unq.tpi.persistencia.performance.dao.DepartmentDAO;
import unq.tpi.persistencia.performance.model.Department;

public class ListadoDeptos extends AbstractListado {

	public ListadoDeptos(String fileName) {
		super(fileName);
	}

	@Override
	public void doListado() throws Exception {
		this.addColumn("Codigo").addColumn("Nombre").addColumn("Manager").newLine();

		List<Department> deptos = new DepartmentDAO().getAll();
		deptos.forEach(it -> {
			this.addColumn(it.getCode())
            		.addColumn(it.getName())
            		.addColumn(it.getManager().getFullName())
            		.newLine();
		});
	}

}
