package com.empresa.appinventario.service;

import java.util.List;
import com.empresa.appinventario.entity.Product;

public interface ProductService {	
	public Product add (Product e);
	public List<Product> findAll();
	public Product findById(long id);
	public Product edit (Product e);
	public long getMaxId();
	public void remove (Product e);
	public void removeId (long id);
}