package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Ifelse {

	@Test
	
	
	public void WorkingWithHardAssert() {
		
		System.out.println("Start");
		Assert.assertNotEquals("hdfc", "hfdc");//hard assert
		System.out.println("End");
	}
	
@Test
	
	
	public void WorkingWithSoftAssert() {
		
		System.out.println("Start");
		SoftAssert soft = new SoftAssert();
		soft.assertNotEquals("hdfc", "hfdc");//soft assert
		System.out.println("End");
		
		soft.assertAll();
	}
	
		
		

	}


