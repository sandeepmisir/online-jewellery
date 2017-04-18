package com.niit.ejewellerybackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ejewellerybackend.dao.ProductDAO;
import com.niit.ejewellerybackend.dto.Product;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*single*/
	
	@Override
	public Product get(int productId) {
		try{
			return sessionFactory
					.getCurrentSession()
					.get(Product.class,Integer.valueOf(productId));
		}
		
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		//return sessionFactory.getCurrentSession().get(Products.class,Integer.valueOf(id));
		return null;
	}
	
	

	@Override
	public List<Product> list() {
		
		return sessionFactory
				.getCurrentSession()
						.createQuery("From Product",Product.class)
								.getResultList();
	}
	
	
	/*
	 * Getting single category based on id
	 */
	
	@Override
	public boolean add(Product product) {
		
		try{
			//add the category to the database
			
			sessionFactory.getCurrentSession().persist(product);
			
			return true;
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	
	
	/*
	 * updating a single category 
	 */
	@Override
	public boolean update(Product product) {
		try{
			//add the category to the database
			
			sessionFactory.getCurrentSession().update(product);
			
			return true;
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			
		}
		return false;
	}
	
	
	/*
	 * delete a single category 
	 */
	@Override
	public boolean delete(Product product) {
		
		try{
			product.setActive(false);
			//add the category to the database
			return this.update(product);
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}



	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts="FROM Product WHERE active = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProducts, Product.class)
						.setParameter("active",true)
							.getResultList();
	}



	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory="FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductsByCategory, Product.class)
						.setParameter("active",true)
							.setParameter("categoryId",categoryId)
								.getResultList();
	}



	@Override
	public List<Product> getLatestActiveProduct(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
						.setParameter("active",true)
							.setFirstResult(0)
								.setMaxResults(count)
								.getResultList();
	}
		
}
