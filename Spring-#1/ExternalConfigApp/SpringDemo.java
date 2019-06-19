package com.accolite.Spring1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.basic.ClassA;
import com.learning.basic.DataBaseClass;

public class SpringDemo {

	
	public static void main(String[] args) {
		
		ApplicationContext ac= new ClassPathXmlApplicationContext("beans.xml");
//		ClassA a =(ClassA) ac.getBean("a");
//		a.methodA();
		DataBaseClass db = (DataBaseClass)ac.getBean("dataBaseClass");
		System.out.println(db);
	}
}
