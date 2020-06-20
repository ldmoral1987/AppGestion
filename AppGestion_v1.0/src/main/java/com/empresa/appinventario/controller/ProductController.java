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

import com.empresa.appinventario.entity.Product;
import com.empresa.appinventario.service.ProductService;

@Controller
public class ProductController {
	// Con @Autowired se inyecta la dependencia del servicio
	@Autowired
	private ProductService service;
	
	@GetMapping("/product/list")
	public String list (Model model)
	{
		// Se usa el método del servicio para obtener el contenido
		// de la lista, que contiene todos los productos
		model.addAttribute("listProducts", service.findAll());
		
		// Se devuelve el resultado a la URL
		return "product/list";
	}
	
	// Este get nos envía a la página en la que está el formulario
	// de creación de productos.
	@GetMapping("/product/insert")
	public String newProduct (Model model)
	{
		// Al nuevo producto se le asigna un id consecutivo
		Product product = new Product();
		product.setId(service.getMaxId() + 1);
		
		// Se vincula productForm con un objeto vacío de tipo Product
		// Este parámetro sirve de unión entre la vista y el controlador
		model.addAttribute("productForm", product);
		
		// Se devuelve el resultado a la URL
		return "product/insert";
	}	
	
	// Este método recibe el CommandObject por medio de la anotación
	// es decir, lo recibe del formulario y lo inyecta en el nuevo
	// objeto de tipo Producto
	@PostMapping("/product/insert/submit")
	public String newProductSubmit (@Valid @ModelAttribute("productForm") Product product, BindingResult result)
	{
		// Se comprueba que los datos recibidos son válidos
		if(result.hasErrors())
		{
			return "product/insert";
		}
		else
		{
			// Se añade el producto a la lista
			service.add(product);
			
			// Redirige al usuario al listado
			return "redirect:/product/list";
		}
	}
	
	// Este método permite editar un producto existente o carga el 
	// formulario de inserción si no existe el objeto que se quiere editar
	// El identificador del objeto que se busca se trata como una variable
	// en la URL (PathVariable)
	@GetMapping("/product/edit/{id}")
	public String editProduct (@PathVariable long id, Model model)
	{
		Product search = service.findById(id);

		if (search != null) {
			model.addAttribute("productForm", search);
			return "product/insert";
		} else {
			// Si no existe, se redirige al formulario de creación
			return "redirect:/product/insert";
		}
	}
	
	@PostMapping("/product/edit/submit")
	public String editProductSubmit (@Valid @ModelAttribute("productForm") Product edited, BindingResult result)
	{
		// Se comprueba que los datos recibidos son válidos
		if(result.hasErrors())
		{
			return "product/insert";
		}
		else
		{
			service.edit(edited);
			return "redirect:/product/list";
		}
	}
	
	// Este get nos envía a la página en la que está el formulario
	// de borrado de productos.
	@GetMapping("/product/delete")
	public String deleteProduct (Model model)
	{
		// Se vincula productForm con un objeto vacío de tipo Empleado
		// Este parámetro sirve de unión entre la vista y el controlador
		// A través de este objeto recuperaremos el ID del objeto a borrar
		model.addAttribute("productForm", new Product());
		return "product/delete";
	}	
	
	// Este método se ejecuta cuando se realiza el post con el ID
	// del producto que se quiere borrar
	@PostMapping("/product/delete/submit")
	public String deleteProductSubmit (@ModelAttribute("productForm") Product delete)
	{
		// Se borra el producto de la lista
		service.remove(delete);
		
		// Redirige al usuario al listado
		return "redirect:/employee/list";
	}
	
	// Este método se usa cuando se borra el producto desde la lista de
	// acciones, en la tabla del listado
	@GetMapping("/product/delete/{id}")
	public String deleteProductConfirm (@PathVariable int id, Model model)
	{
		// Se borra el producto de la lista
		service.removeId(id);
		
		// Redirige al usuario al listado
		return "redirect:/product/list";
	}	
}
