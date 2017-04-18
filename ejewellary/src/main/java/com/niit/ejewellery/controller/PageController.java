package com.niit.ejewellery.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ejewellery.exception.ProductNotFoundException;
import com.niit.ejewellerybackend.dao.CategoryDAO;
import com.niit.ejewellerybackend.dao.ProductDAO;
import com.niit.ejewellerybackend.dto.Category;
import com.niit.ejewellerybackend.dto.Product;


@Controller
public class PageController {
	
	private static final Logger Logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Home");
		
		Logger.info("Inside PageController index method-INFO");
		Logger.debug("Inside PageController index method-DEBUG");
		
		//passing the list of category
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Login");
		mv.addObject("userClickLogin",true);
		return mv;
	}
	
	@RequestMapping(value = "/register")
	public ModelAndView register() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Register");
		mv.addObject("userClickRegister",true);
		return mv;
	}
	
	@PostMapping("/validate")
	public ModelAndView validateCredentials(@RequestParam(value="userID",required=true) String id, @RequestParam(value="password",required=true) String pwd)
	{
		//actually you have to take the data from db
		//temporarily
		ModelAndView mv=new ModelAndView("/page");
		
		if(id.equals("niit") && pwd.equals("niit@123"))
		{
			mv.addObject("successMessage","Valid credentials");
			session.setAttribute("loginMessage","Welcome :"+id);
			
		}
		else
		{
			mv.addObject("errorMessage","Invalid credentials please try again");
		}
		
		return mv;
	}
	
	
	/*
	 * methods to load all the products and based on categories
	 * */
	
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "All Products");
		
		//passing the list of category
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv=new ModelAndView("page");
		
		//categoryDAO to fetch a single category
		Category category= null;
		category= categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		
		//passing the list of category
		mv.addObject("categories",categoryDAO.list());
		
		//passing the single category object
		mv.addObject("category",category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;
	}
	
	
	/*
	 * viewing the single product page
	 */
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		ModelAndView mv=new ModelAndView("page");
		
		Product product = productDAO.get(id);
		if(product == null) throw new ProductNotFoundException();
		
		//update the views
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		//-------------------------
		
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		mv.addObject("userClickShowProduct",true);
		
		return mv;
	}
	
	
}
