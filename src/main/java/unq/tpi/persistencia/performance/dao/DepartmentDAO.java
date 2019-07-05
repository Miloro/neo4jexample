package unq.tpi.persistencia.performance.dao;

import org.hibernate.Session;

import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import unq.tpi.persistencia.performance.model.Department;
import unq.tpi.persistencia.performance.model.Employee;
import unq.tpi.persistencia.performance.model.Pago;
import unq.tpi.persistencia.performance.service.runner.Runner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class DepartmentDAO extends BaseDAO<Department> {

	public DepartmentDAO() {
		super(Department.class, "Department");
	}

	/**
	 * Gets the department by its name
	 * @return the department found, or null
	 */
	public Department getByName(String name) {
		Session session = Runner.getCurrentSession();
		
		String hql = "from Department where name = :name";
		return session.createQuery(hql, Department.class)
				.setParameter("name", name)
				.getSingleResult();
	}

	public List<Pago> getPagosByDepto(String deptoId)
	{


        Session session = Runner.getCurrentSession();
        Date unDate = new Date(9999,1,1);

        String hql = "SELECT NEW " + Pago.class.getName() + "(employee.firstName, titulo, salario.amount) " +
                     "FROM Employee employee " +
                     "JOIN employee.salaries AS salario " +
                     "JOIN employee.titles AS titulo " +
                     "JOIN employee.departments AS departament " +
                     "WHERE departament.id = :deptoId and salario.to = '9999-01-01'";

        Query<Pago> query = session.createQuery(hql,Pago.class);
        query.setParameter("deptoId", deptoId);
        return query.getResultList();
	}
}
