package com.niit.ejewellerybackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ejewellerybackend.dao.SuppliersDAO;
import com.niit.ejewellerybackend.dto.Suppliers;

public class SuppliersTestCase {

	
	private static AnnotationConfigApplicationContext context;
	
	private static SuppliersDAO suppliersDAO;
	
	private Suppliers suppliers;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ejewellerybackend");
		context.refresh();
		suppliersDAO = (SuppliersDAO)context.getBean("suppliersDAO");
	}
	
	
	
	
	@Test
    public void testCRUDSuppliers() {
        //add operation
        suppliers =new Suppliers();
        
        suppliers.setName("Television");
        suppliers.setDescription("This is some desc for Television");
        //category.setImageURL("CAT_2mac.png");
        
        assertEquals("Successfully added a category inside the table",true,suppliersDAO.add(suppliers));
        
        suppliers =new Suppliers();
        
        suppliers.setName("Laptop");
        suppliers.setDescription("This is some desc for laptop");
       // category.setImageURL("CAT_3.png");
        
        assertEquals("Successfully added a category inside the table",true,suppliersDAO.add(suppliers));
        
        //fetchaing and updating
        suppliers = suppliersDAO.get(2);
        
        suppliers.setName("earphone");
    
        assertEquals("Successfully updated a category in the table",true,suppliersDAO.update(suppliers));
        
        //delete the category
        suppliers = suppliersDAO.get(2);
        assertEquals("Successfully deleted a category in the table",true,suppliersDAO.delete(suppliers));
        
        //fetching the list
        assertEquals("Successfully fetched the list of a categories from the table",1,suppliersDAO.list().size());
        
    }
	
	
}
