package com.niit.ShoppingCart;

import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.model.Category;

import junit.framework.TestCase;

public class TestCaseCategory  {
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;
	AnnotationConfigApplicationContext context;
	@Before
	public void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();		
	}

}
