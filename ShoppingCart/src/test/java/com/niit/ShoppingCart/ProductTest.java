package com.niit.ShoppingCart;

import java.lang.annotation.Annotation;

import javax.naming.Context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.dao.ProductDAO;
import com.niit.ShoppingCart.model.Product;



public class ProductTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	ProductDAO productDAO=(ProductDAO) context.getBean("productDAO");
	Product product=(Product) context.getBean("product");
	
	product.setId("CG001");
	product.setName("CGName001");
	product.setDescription("cG001 descri");
	if (productDAO.save(product)==true) 
	{
		System.out.println("Product created successfully");
		
	} else {
		System.out.println("cannot create Product");

	}
}
}
