package com.niit.ejewellerybackend.dao;

import java.util.List;

import com.niit.ejewellerybackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
	
}
