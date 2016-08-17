package com.niit.ShoppingCart;

import java.lang.annotation.Annotation;

import javax.naming.Context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.model.Category;

public class CategoryTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	CategoryDAO categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
	Category category=(Category) context.getBean("category");
	category.setId("CG001");
	category.setName("CGName001");
	category.setDescription("cG001 descri");
	if (categoryDAO.save(category)==true) 
	{
		System.out.println("Category created successfully");
		
	} else {
		System.out.println("cannot create category");

	}
}
}
