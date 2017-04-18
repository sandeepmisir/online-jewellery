package com.niit.ejewellerybackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ejewellerybackend.dao.SuppliersDAO;
import com.niit.ejewellerybackend.dto.Suppliers;


@Repository("suppliersDAO")
@Transactional
public class SuppliersDAOImpl implements SuppliersDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Suppliers> list() {
		
		String selectActiveSuppliers = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveSuppliers);
		
		query.setParameter("active",true);
		
		return query.getResultList();
	}
	
	@Override
	public Suppliers get(int id) {
		
		return sessionFactory.getCurrentSession().get(Suppliers.class,Integer.valueOf(id));
		
	}
	
	
	/*
	 * Getting single category based on id
	 */
	
	@Override
	public boolean add(Suppliers suppliers) {
		
		try{
			//add the category to the database
			
			sessionFactory.getCurrentSession().save(suppliers);
			
			return true;
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	
	}
	
	
	
	/*
	 * updating a single category 
	 */
	@Override
	public boolean update(Suppliers suppliers) {
		try{
			//add the category to the database
			
			sessionFactory.getCurrentSession().update(suppliers);
			
			return true;
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
	
	@Override
	public boolean delete(Suppliers suppliers) {
		
		suppliers.setActive(false);
		
		try{
			//add the category to the database
			
			sessionFactory.getCurrentSession().update(suppliers);
			
			return true;
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

}
