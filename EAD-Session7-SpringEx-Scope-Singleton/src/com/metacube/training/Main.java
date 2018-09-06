package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"bean.xml");
		
		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");

		objA.setMessage("I'm object A");
		objA.getMessage();

		HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
		
		objB.setMessage("I am Object B");
		objB.getMessage();
		objA.getMessage();
	}
}
