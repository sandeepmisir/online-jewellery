package com.niit.ejewellerybackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ejewellerybackend.dao.ProductDAO;
import com.niit.ejewellerybackend.dto.Product;

public class ProductTestCase {

	
private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ejewellerybackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	
	
	
	/*@Test
    public void testCRUDProducts() {
        //add operation
        product =new Product();
        
        product.setName("HP");
        product.setBrand("This is some desc for HP");
        product.setDescription("This is some desc for HP");
        product.setUnitPrice(25000.0);
        product.setActive(true);
        product.setCategoryId(3);
        product.setSupplierId(3);
        
        assertEquals("Something went wrong while inserting a new product!",true,productDAO.add(product));
        
        
        //reading and updating the category
        product = productDAO.get(2);
        product.setName("samsung galaxy s7");
 
        assertEquals("Something went wrong while updating existing record!",true,productDAO.update(product));
        
        assertEquals("Something went wrong while deleting existing record!",true,productDAO.delete(product));
        
        assertEquals("Something went wrong while fetching existing record!",6,productDAO.list().size());
      
        
    }*/
	
	@Test
	public void testListActiveProducts() {
		 assertEquals("Something went wrong while fetching existing record!",5,productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory() {
		 assertEquals("Something went wrong while fetching existing record!",3,productDAO.listActiveProductsByCategory(3).size());
		 assertEquals("Something went wrong while fetching existing record!",2,productDAO.listActiveProductsByCategory(1).size());
	}
	
	@Test
	public void testGetLatestActiveProduct() {
		 assertEquals("Something went wrong while fetching existing record!",3,productDAO.getLatestActiveProduct(3).size());
	}
	
}
