package com.learning.annotationconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("beans.xml");
		ClassA classA= (ClassA)ap.getBean("a");
		ClassA1 classA1 = (ClassA1)ap.getBean("a1"); 
		System.out.println(classA);
		System.out.println(classA1);
	}
}
