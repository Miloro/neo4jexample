package unq.tpi.persistencia.performance.service;

import unq.tpi.persistencia.performance.dao.DepartmentDAO;
import unq.tpi.persistencia.performance.model.Department;
import unq.tpi.persistencia.performance.model.Employee;
import unq.tpi.persistencia.performance.model.Pago;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListadoPagosPorDepto extends AbstractListado {

	private final String id;

	public ListadoPagosPorDepto(String fileName, String id) {
		super(fileName);
		this.id = id;
	}

	@Override
	public void doListado() throws Exception {
        List<Pago> pagos = new DepartmentDAO().getPagosByDepto(this.id);

		this.newLine();
        this.addColumn("Total").addColumn(this.getTotalSalaries(pagos)).newLine();
		this.newLine();
		
		this.addColumn("Nombre").addColumn("Titulo").addColumn("Monto").newLine();
        pagos.forEach(it -> {
            this.addColumn(it.getNombre())
                    .addColumn(it.getTitulo())
                    .addColumn(it.getMonto())
                    .newLine();
        });
	}

    public double getTotalSalaries(List<Pago> pagos)
    {   return pagos.stream().mapToDouble(Pago::getMonto).sum();  }

}
