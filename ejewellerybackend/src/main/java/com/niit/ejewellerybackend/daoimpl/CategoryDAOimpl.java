package com.niit.ejewellerybackend.daoimpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ejewellerybackend.dao.CategoryDAO;
import com.niit.ejewellerybackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOimpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	
	static {
	
	Category category = new Category();
	
	//adding first category
	category.setId(1);
	category.setName("Television");
	category.setDescription("This is some description for television");
	category.setImageURL("CAT_1.png");
	
	categories.add(category);
	
	
	
	//adding Second category
	category = new Category();
	category.setId(2);
	category.setName("Mobile");
	category.setDescription("This is some description for Mobile");
	category.setImageURL("CAT_2.png");
	
	categories.add(category);
	
	
	
	//adding Third category
	category = new Category();
	category.setId(3);
	category.setName("Laptops");
	category.setDescription("This is some description for Laptops");
	category.setImageURL("CAT_3.png");
		
	categories.add(category);

	
	}
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	@Override
	public Category get(int id) {
		// enhanced for loop
		
		for(Category category : categories) {
			
			if(category.getId() == id) return category;
	
		}
		
		return null;
		
	}

}
