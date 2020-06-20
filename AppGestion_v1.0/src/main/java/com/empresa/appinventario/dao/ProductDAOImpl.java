package com.empresa.appinventario.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.empresa.appinventario.entity.Employee;
import com.empresa.appinventario.entity.Product;

//En esta clase se implementa la interfaz, se añade la anotación 
//@Repository que indica que es un DAO,y mediante la anotación 
//@Autowired se inyecta la dependencia EntityManager, que será
//utilizada para crear una sesión y poder enviar las peticiones
//a la base de datos, en cada uno de los métodos implementados

@Repository
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Product add(Product e) {
		return saveOrEdit(e);
	}
	
	@Override
	public Product edit(Product e) {
		return saveOrEdit(e);
	}
	
	private Product saveOrEdit (Product e)
	{
		System.out.println(e);
		Session currentSession = entityManager.unwrap(Session.class);
		Transaction txn = currentSession.beginTransaction();
		currentSession.saveOrUpdate(e);	
		txn.commit();
		return e;
	}

	@Override
	public Product findById(long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Product> theQuery = currentSession.createQuery("from Product where id=:idProduct", Product.class);
		theQuery.setParameter("idProduct", id);
		List<Product> products = theQuery.getResultList();
		return products.get(0);
	}

	@Override
	public List<Product> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Product> theQuery = currentSession.createQuery("from Product", Product.class);
		List<Product> products = theQuery.getResultList();
		return products;
	}

	@Override
	public long getMaxId() {
		try
		{
			Session currentSession = entityManager.unwrap(Session.class);
			@SuppressWarnings("unchecked")
			Query<Object> theQuery = (Query<Object>) currentSession.createQuery("select max(id) from Product");
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
	public void remove(Product e) {
		Session currentSession = entityManager.unwrap(Session.class);
		Transaction txn = currentSession.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<Employee> theQuery = currentSession.createQuery("delete from Product where id=:idProduct");
		theQuery.setParameter("idProduct", e.getId());
		theQuery.executeUpdate();
		txn.commit();
	}

	@Override
	public void removeId(long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Transaction txn = currentSession.beginTransaction();
		@SuppressWarnings("unchecked")
		Query<Employee> theQuery = currentSession.createQuery("delete from Product where id=:idProduct");
		theQuery.setParameter("idProduct", id);
		theQuery.executeUpdate();
		txn.commit();
	}
}
