package com.niit.shoppingcart_v1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart_v1");
		context.refresh();
		context.getBean("catObject");
		System.out.println("Category is created");
		
		Product p = (Product) context.getBean("product");
		p.setName("Samsung Galaxy S5");
		p.setId(1001);
		p.setPrice(15005);
		
		p.getId();
		p.getName();
		p.getPrice();
		
	}

}
