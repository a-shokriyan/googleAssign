package com.google.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.utils.BaseClass;

public class HomePageTest extends BaseClass{
	
	@Test
	public void getTitle() {
		String actual=driver.getTitle();
		String expected= "Google";
		Assert.assertEquals(actual, expected);
		
	}

}
