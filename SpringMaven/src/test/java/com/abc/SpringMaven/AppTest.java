package com.abc.SpringMaven;

import static org.junit.Assert.assertTrue;



import org.junit.Test;

import com.abc.test.TestApp;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
    	System.out.println("Test Class Maven Code");
    	
    	TestApp testApp = new TestApp();
    	testApp.test();
        assertTrue( true );
    }
}
