package com.empresa.appinventario.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.empresa.appinventario.entity.Employee;

//En esta clase se implementa la interfaz, se añade la anotación 
//@Repository que indica que es un DAO,y mediante la anotación 
//@Autowired se inyecta la dependencia EntityManager, que será
//utilizada para crear una sesión y poder enviar las peticiones
//a la base de datos, en cada uno de los métodos implementados

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Employee add(Employee e) {
		return saveOrEdit(e);
	}
	
	@Override
	public Employee edit(Employee e) {
		return saveOrEdit(e);
	}
	
	private Employee saveOrEdit (Employee e)
	{
		Session currentSession = entityManager.unwrap(Session.class);
		Transaction txn = currentSession.beginTransaction();
		currentSession.saveOrUpdate(e);	
		txn.commit();
		return e;
	}

	@Override
	public Employee findById(long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery("from Employee where id=:idEmployee", Employee.class);
		theQuery.setParameter("idEmployee", id);
		List<Employee> employees = theQuery.getResultList();
		return employees.get(0);
	}

	@Override
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public long getMaxId() {
		try
		{
			Session currentSession = entityManager.unwrap(Session.class);
			@SuppressWarnings("unchecked")
			Query<Object> theQuery = (Query<Object>) currentSession.createQuery("select max(id) from Employee");
			List<Object> list = theQuery.list();
			return (long) list.get(0);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return -1;
	}

	@Override
	public void remove(Employee e) {
		Session currentSession = entityManager.unwrap(Session.class);
		Transaction txn = currentSession.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:idEmployee");
		theQuery.setParameter("idEmployee", e.getId());
		theQuery.executeUpdate();
		txn.commit();
	}

	@Override
	public void removeId(long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Transaction txn = currentSession.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:idEmployee");
		theQuery.setParameter("idEmployee", id);
		theQuery.executeUpdate();
		txn.commit();
	}
}
