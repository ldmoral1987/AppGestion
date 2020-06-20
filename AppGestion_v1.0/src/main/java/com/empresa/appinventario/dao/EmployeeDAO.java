package com.empresa.appinventario.dao;

import java.util.List;
import com.empresa.appinventario.entity.Employee;

// Esta interfaz declara los métodos que se usarán para conectarse
// a la base de datos y recuperar la entidad Employee
public interface EmployeeDAO {
	public Employee add (Employee e);
	public List<Employee> findAll();
	public Employee findById(long id);
	public Employee edit (Employee e);
	public long getMaxId();
	public void remove (Employee e);
	public void removeId (long id);
}