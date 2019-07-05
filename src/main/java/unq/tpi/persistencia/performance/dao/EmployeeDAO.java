package unq.tpi.persistencia.performance.dao;

import org.hibernate.Session;

import org.hibernate.query.Query;
import unq.tpi.persistencia.performance.model.Employee;
import unq.tpi.persistencia.performance.service.runner.Runner;

import java.util.List;

public class EmployeeDAO extends BaseDAO<Employee> {

	public EmployeeDAO() {
		super(Employee.class, "Employee");
	}
	
	/**
	 * Gets an employee by name and lastName
	 * @return the employee found, otherwise null
	 */
	public Employee getByName(String name, String lastName) {
		Session session = Runner.getCurrentSession();
		
		String hql = "from Employee where firstName = :name and lastName = :lastName";
		return session.createQuery(hql, Employee.class)
				.setParameter("name", name)
				.setParameter("lastName", lastName)
				.getSingleResult();
	}

	public List<Employee> getEmployeesWithBestSalaries(int limit)
	{
        Session session = Runner.getCurrentSession();
        String hql = "SELECT employee " +
                     "FROM Employee employee " +
                     "JOIN employee.salaries salary " +
                     "GROUP BY employee " +
                     "ORDER BY salary.to DESC, salary.amount DESC";
        Query<Employee> query = session.createQuery(hql,  Employee.class);
		query.setMaxResults(limit);
        return query.getResultList();
	}

}
