package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test
	public void createCustomer() //failed - 3mins
	{
		Assert.fail();//purposefully fail the script
		System.out.println("customer created");
	}
	
	@Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer() // do not run - 3mins 
	{
		System.out.println("customer modified");
	}
	
	@Test(dependsOnMethods = {"createCustomer","modifyCustomer"})
	public void deleteCustomer() // do not run - 3mins = 9mins
	{
		System.out.println("customer deleted");
	}

}
