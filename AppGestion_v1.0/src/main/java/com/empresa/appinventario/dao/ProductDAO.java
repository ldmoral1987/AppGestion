package com.empresa.appinventario.dao;

import java.util.List;
import com.empresa.appinventario.entity.Product;

// Esta interfaz declara los métodos que se usarán para conectarse
// a la base de datos y recuperar la entidad Product
public interface ProductDAO {
	public Product add (Product e);
	public List<Product> findAll();
	public Product findById(long id);
	public Product edit (Product e);
	public long getMaxId();
	public void remove (Product e);
	public void removeId (long id);
}