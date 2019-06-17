package com.learning.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ClassA {
	ClassBInterface classB;

	public ClassBInterface getClassB() {
		return classB;
	}
	@Autowired
	public void setClassB(@Qualifier("b1") ClassBInterface classB) {
		this.classB = classB;
	}

	@Override
	public String toString() {
		return "ClassA [classB=" + classB + "]";
	}
	
}
