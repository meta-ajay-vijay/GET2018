package com.metacube.training;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String args[]) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.check();
	}
}