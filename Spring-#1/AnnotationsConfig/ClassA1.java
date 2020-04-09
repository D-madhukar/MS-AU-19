package com.learning.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class ClassA1 {
	String id;
	@Autowired
	@Qualifier("b2")
	ClassBInterface classB;
	
	@Override
	public String toString() {
		return "ClassA1 [id=" + id + ", classB=" + classB + "]";
	}
	public ClassBInterface getClassB() {
		return classB;
	}
	public void setClassB(ClassBInterface classB) {
		this.classB = classB;
	}
	public String getId() {
		return id;
	}
	@Required
	public void setId(String id) {
		this.id = id;
	}
  
}
