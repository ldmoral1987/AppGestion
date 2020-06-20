package com.empresa.appinventario.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.empresa.appinventario.entity.Employee;
import com.empresa.appinventario.service.EmployeeService;

@Controller
public class EmployeeController {
	// Con @Autowired se inyecta la dependencia del servicio
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employee/list")
	public String list (Model model)
	{
		// Se usa el método del servicio para obtener el contenido
		// de la lista, que contiene todos los empleados
		model.addAttribute("listEmployees", service.findAll());
		
		// Se devuelve el resultado a la URL
		return "employee/list";
	}
	
	// Este get nos envía a la página en la que está el formulario
	// de creación de empleados.
	@GetMapping("/employee/insert")
	public String newEmployee (Model model)
	{
		// Al nuevo empleado se le asigna un id consecutivo
		Employee employee = new Employee();
		employee.setId(service.getMaxId() + 1);
		
		// Se vincula employeeForm con un objeto vacío de tipo Empleado
		// Este parámetro sirve de unión entre la vista y el controlador
		model.addAttribute("employeeForm", employee);
		
		// Se devuelve el resultado a la URL
		return "employee/insert";
	}	
	
	// Este método recibe el CommandObject por medio de la anotación
	// es decir, lo recibe del formulario y lo inyecta en el nuevo
	// objeto de tipo Empleado
	@PostMapping("/employee/insert/submit")
	public String newEmployeeSubmit (@Valid @ModelAttribute("employeeForm") Employee employee, BindingResult result)
	{
		// Se comprueba que los datos recibidos son válidos
		if(result.hasErrors())
		{
			return "employee/insert";
		}
		else
		{
			// Se añade el empleado a la lista
			service.add(employee);
			
			// Redirige al usuario al listado
			return "redirect:/employee/list";
		}
	}
	
	// Este método permite editar un empleado existente o carga el 
	// formulario de inserción si no existe el objeto que se quiere editar
	// El identificador del objeto que se busca se trata como una variable
	// en la URL (PathVariable)
	@GetMapping("/employee/edit/{id}")
	public String editEmployee (@PathVariable long id, Model model)
	{
		Employee search = service.findById(id);

		if (search != null) {
			model.addAttribute("employeeForm", search);
			return "employee/insert";
		} else {
			// Si no existe, se redirige al formulario de creación
			return "redirect:/employee/insert";
		}
	}
	
	@PostMapping("/employee/edit/submit")
	public String editEmployeeSubmit (@Valid @ModelAttribute("employeeForm") Employee edited, BindingResult result)
	{
		// Se comprueba que los datos recibidos son válidos
		if(result.hasErrors())
		{
			return "employee/insert";
		}
		else
		{
			service.edit(edited);
			return "redirect:/employee/list";
		}
	}
	
	// Este get nos envía a la página en la que está el formulario
	// de borrado de empleados.
	@GetMapping("/employee/delete")
	public String deleteEmployee (Model model)
	{
		// Se vincula employeeForm con un objeto vacío de tipo Empleado
		// Este parámetro sirve de unión entre la vista y el controlador
		// A través de este objeto recuperaremos el ID del objeto a borrar
		model.addAttribute("employeeForm", new Employee());
		return "employee/delete";
	}	
	
	// Este método se ejecuta cuando se realiza el post con el ID
	// del empleado que se quiere borrar
	@PostMapping("/employee/delete/submit")
	public String deleteEmployeeSubmit (@ModelAttribute("employeeForm") Employee delete)
	{
		// Se borra el empleado de la lista
		service.remove(delete);
		
		// Redirige al usuario al listado
		return "redirect:/employee/list";
	}
	
	// Este método se usa cuando se borra el empleado desde la lista de
	// acciones, en la tabla del listado
	@GetMapping("/employee/delete/{id}")
	public String deleteEmployeeConfirm (@PathVariable int id, Model model)
	{
		// Se borra el empleado de la lista
		service.removeId(id);
		
		// Redirige al usuario al listado
		return "redirect:/employee/list";
	}	
}
