package com.empresa.appinventario.controller.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.empresa.appinventario.entity.Employee;
import com.empresa.appinventario.service.EmployeeService;

//Esta clase gestiona las peticiones que se hagan a nuestra API
//Indiciamos que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:9000/api/
public class EmployeeRestController {
	
	//Inyectamos el servicio para poder hacer uso de él
	@Autowired
	private EmployeeService employeeService;

	/*Este método se invocará cuando por una petición GET (como indica la anotación) se llame a la url 
	http://127.0.0.1:9000/api/employee/list*/
	@GetMapping("/employee/list")
	public List<Employee> findAll(){
		// Retornará todos los empleados
		return employeeService.findAll();
	}
	
	/*Este método se invocará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un empleado
	http://127.0.0.1:9000/api/employee/1*/
	@GetMapping("/employee/{empId}")
	public Employee getEmployee(@PathVariable int empId){
		Employee employee = employeeService.findById(empId);
		
		if(employee == null) {
			throw new RuntimeException("Employee id not found: " + empId);
		}
		// retornará al empleado con id pasado en la url
		return employee;
	}
	
	/*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
	http://127.0.0.1:9000/api/employee/post  */
	@PostMapping("/employee/post")
	public Employee addEmployee(@RequestBody Employee employee) {
		// Se guarda el empleado enviado
		employeeService.add(employee);
		return employee;
		
	}
	/*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
	http://127.0.0.1:9000/api/employee/put/  */
	@PutMapping("/employee/put")
	public Employee updateEmployee(@RequestBody Employee employee) {
		// Se actualiza el empleado enviado
		employeeService.edit(employee);
		return employee;
	}
	
	/*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del empleado
	http://127.0.0.1:9000/api/employee/delete/1  */
	@DeleteMapping("/employee/delete/{userId}")
	public String deteteUser(@PathVariable int empId) {
		Employee employee = employeeService.findById(empId);
		
		if(employee == null) {
			throw new RuntimeException("User id not found: " + empId);
		}
		
		// Se borra el usuario solicitado
		employeeService.removeId(empId);
		
		return "Deleted user id: " + empId;
	}
}