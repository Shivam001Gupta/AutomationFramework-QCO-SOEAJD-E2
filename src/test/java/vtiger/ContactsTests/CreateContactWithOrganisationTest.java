package vtiger.ContactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;


public class CreateContactWithOrganisationTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void createContactWithOrgTest() throws Throwable {

		/* Create Organization */

		// Step 1: Read all the necessary data

		String ORGNAME = eUtil.getDataFromExcel("Contacts", 4, 3) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.getDataFromExcel("Contacts", 4, 2);

		// Step 5: Click on Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		Reporter.log("Org link clicked");

		// Step 6: click on Create Organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("create org look up image is clicked");

		// Step 6: create Organization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		Reporter.log("Organization created");

		// Step 8: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader=oip.getHeaderText();
		
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader);

		/* Create Contact using Organization */

		// step 9: click on contacts link - 500 - update 
		hp.clickOnContactsLink();
		Reporter.log("contacts link clicked");

		// Step 10: Navigate to create contact look up image
		//Assert.fail();
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImage();
		Reporter.log("create contact look up image clicked");
		

		// step 10: Create a contact with mandatory information
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(driver, LASTNAME, ORGNAME);
		Reporter.log("Contact is created");

		// Step 15: Validate for Organization
		ContactInfoPage cip = new ContactInfoPage(driver);
		String ContactHeader=cip.getContactHeader();
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
	    System.out.println(ContactHeader);
		
		

	}
	
	@Test
	public void demotest()
	{
		
		System.out.println("demo");
	}

}
