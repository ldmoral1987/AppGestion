package com.empresa.appinventario.service;

import java.util.List;
import com.empresa.appinventario.entity.Employee;

public interface EmployeeService {	
	public Employee add (Employee e);
	public List<Employee> findAll();
	public Employee findById(long id);
	public Employee edit (Employee e);
	public long getMaxId();
	public void remove (Employee e);
	public void removeId (long id);
}