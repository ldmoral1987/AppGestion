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
import com.empresa.appinventario.entity.Product;
import com.empresa.appinventario.service.ProductService;

//Esta clase gestiona las peticiones que se hagan a nuestra API
//Indiciamos que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:9000/api/
public class ProductRestController {
	
	//Inyectamos el servicio para poder hacer uso de él
	@Autowired
	private ProductService productService;

	/*Este método se invocará cuando por una petición GET (como indica la anotación) se llame a la url 
	http://127.0.0.1:9000/api/product*/
	@GetMapping("/product/list")
	public List<Product> findAll(){
		// Retornará todos los empleados
		return productService.findAll();
	}
	
	/*Este método se invocará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un producto
	http://127.0.0.1:9000/api/product/1*/
	@GetMapping("/product/{prodId}")
	public Product getEmployee(@PathVariable int prodId){
		Product product = productService.findById(prodId);
		
		if(product == null) {
			throw new RuntimeException("Product id not found: " + prodId);
		}
		// retornará al producto con id pasado en la url
		return product;
	}
	
	/*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
	http://127.0.0.1:9000/api/product/post  */
	@PostMapping("/product/post")
	public Product addEmployee(@RequestBody Product product) {
		// Se guarda el producto enviado
		productService.add(product);
		return product;
		
	}
	/*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
	http://127.0.0.1:9000/api/product/put/  */
	@PutMapping("/product/put")
	public Product updateEmployee(@RequestBody Product product) {
		// Se actualiza el product enviado
		productService.edit(product);
		return product;
	}
	
	/*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del producto
	http://127.0.0.1:9000/api/product/delete/1  */
	@DeleteMapping("/product/delete/{userId}")
	public String deteteUser(@PathVariable int prodId) {
		Product product = productService.findById(prodId);
		
		if(product == null) {
			throw new RuntimeException("product id not found: " + prodId);
		}
		
		// Se borra el producto solicitado
		productService.removeId(prodId);
		
		return "Deleted product id: " + product;
	}
}