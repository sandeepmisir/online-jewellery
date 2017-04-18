package com.niit.ejewellerybackend.dao;

import java.util.List;

import com.niit.ejewellerybackend.dto.Product;

public interface ProductDAO {

		Product get(int id);
		List<Product> list();
		boolean add(Product product);
		boolean update(Product product);
		boolean delete(Product product);
			
		//business method
		List<Product> listActiveProducts();
		List<Product> listActiveProductsByCategory(int categoryId);
		List<Product> getLatestActiveProduct(int count);
}
