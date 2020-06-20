package com.empresa.appinventario.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empresa.appinventario.dao.ProductDAO;
import com.empresa.appinventario.entity.Product;

//La anotación @Service indica que es un servicio
//Con @Autowired se inyecta el DAO creado para poder usarlo

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public List<Product> findAll() {
		List<Product> listProducts= productDAO.findAll();
		return listProducts;
	}

	@Override
	public Product add(Product e) {
		productDAO.add(e);
		return e;
	}

	@Override
	public Product findById(long id) {
		Product product = productDAO.findById(id);
		return product;
	}

	@Override
	public Product edit(Product e) {
		productDAO.edit(e);
		return e;
	}

	@Override
	public long getMaxId() {
		return productDAO.getMaxId();
	}

	@Override
	public void remove(Product e) {
		productDAO.remove(e);
	}

	@Override
	public void removeId(long id) {
		productDAO.removeId(id);
	}
}