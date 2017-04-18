package com.niit.ejewellerybackend.dao;

import java.util.List;

import com.niit.ejewellerybackend.dto.Suppliers;

public interface SuppliersDAO {
	
	Suppliers get(int id);
	List<Suppliers> list();
	boolean add(Suppliers suppliers);
	boolean update(Suppliers suppliers);
	boolean delete(Suppliers suppliers);

}
