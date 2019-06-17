package com.learning.annotationconfig;

public class ClassB implements ClassBInterface {
	String name;
	public ClassB() {
		this.name="Default name";
	}
	public ClassB(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "ClassB [name=" + name + "]";
	}
	public String processB() {
		return "Some Value";
	}
	
	
}
