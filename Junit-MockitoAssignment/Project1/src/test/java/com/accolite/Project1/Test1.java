package com.accolite.Project1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class Test1 {
	Calculator cal;
	SampleService sampleService;
	@BeforeClass 
	public static void beforeClass() {
		System.out.println("Before Class");
		
	}
	@Before
	public void createCal() {
		sampleService = Mockito.mock(SampleService.class);
		this.cal=new Calculator(sampleService);
		System.out.println("before method");
	}
	@Test
	public void testAdd() {
		
		Mockito.when(this.sampleService.getValue()).thenReturn(1);
		assertEquals(11,this.cal.add(5, 5));
		//Verifying whether sampleService.getValue() method was called are not
		Mockito.verify(this.sampleService).getValue();
	}
	@Test 
	public void testDiv() {
		assertNotNull(this.cal);
		this.cal =null;
		assertNull(this.cal);
		assertEquals(2,this.cal.division(10, 5));
	}
	@Test(expected=ArithmeticException.class)
	public void testDivision() {
		this.cal.division(10, 0);
	}
	@After
	public void afterMethod() {
		System.out.println("After method");
		this.cal=null;
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("After class");
	}

}
