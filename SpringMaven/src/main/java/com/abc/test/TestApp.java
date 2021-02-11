package com.abc.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.abc.beans.Student;

public class TestApp {
	 public void test()
	    {
	    	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/abc/config/applicationContext.xml");
	   
	    	Student student = applicationContext.getBean("student", Student.class);
	    	
	    	System.out.println("Student id is :"+ student.getSid());
	    	System.out.println("Student Name is :"+ student.getSname());
	    	System.out.println("Student Address is :"+ student.getSaddress());
	    	
	    	applicationContext.close();
	    
	    }
}
