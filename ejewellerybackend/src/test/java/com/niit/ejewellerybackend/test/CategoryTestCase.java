package com.niit.ejewellerybackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ejewellerybackend.dao.CategoryDAO;
import com.niit.ejewellerybackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ejewellerybackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	
	
	
	@Test
    public void testCRUDCategory() {
        //add operation
        category =new Category();
        
        category.setName("Television");
        category.setDescription("This is some desc for Television");
        //category.setImageURL("CAT_2mac.png");
        
        assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
        
        category =new Category();
        
        category.setName("Laptop");
        category.setDescription("This is some desc for laptop");
       // category.setImageURL("CAT_3.png");
        
        assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
        
        //fetchaing and updating
        category = categoryDAO.get(2);
        
        category.setName("earphone");
    
        assertEquals("Successfully updated a category in the table",true,categoryDAO.update(category));
        
        //delete the category
        category = categoryDAO.get(2);
        assertEquals("Successfully deleted a category in the table",true,categoryDAO.delete(category));
        
        //fetching the list
        assertEquals("Successfully fetched the list of a categories from the table",1,categoryDAO.list().size());
        
    }
	
	
	
	
	
	
	
	
}
