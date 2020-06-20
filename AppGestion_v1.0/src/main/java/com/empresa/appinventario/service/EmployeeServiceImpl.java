package com.empresa.appinventario.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empresa.appinventario.dao.EmployeeDAO;
import com.empresa.appinventario.entity.Employee;

//La anotación @Service indica que es un servicio
//Con @Autowired se inyecta el DAO creado para poder usarlo

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public List<Employee> findAll() {
		List<Employee> listEmployees= employeeDAO.findAll();
		return listEmployees;
	}

	@Override
	public Employee add(Employee e) {
		employeeDAO.add(e);
		return e;
	}

	@Override
	public Employee findById(long id) {
		Employee employee = employeeDAO.findById(id);
		return employee;
	}

	@Override
	public Employee edit(Employee e) {
		employeeDAO.edit(e);
		return e;
	}

	@Override
	public long getMaxId() {
		return employeeDAO.getMaxId();
	}

	@Override
	public void remove(Employee e) {
		employeeDAO.remove(e);
	}

	@Override
	public void removeId(long id) {
		employeeDAO.removeId(id);
	}
}