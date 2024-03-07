package testCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObject.ConfirmDetailsPage;
import PageObject.GiftCardPage;
import testBase.TestBase;
@Listeners(testCases.ExtentReport.class)

public class TC_07_confirmDetails extends TestBase {
	public GiftCardPage gc;
	public ConfirmDetailsPage cd;
	
	@Test(priority=18,groups={"smoke","regression"})
	public void confirm_the_details_in_confirm_details_section() throws IOException, InterruptedException {
		
		cd=new ConfirmDetailsPage(driver);
		gc=new GiftCardPage(driver);
		gc.clickCnfrmBtn();
		Thread.sleep(3000);
		cd.chkRname();
	    cd.chkRmail();
	    cd.chkRphn();
	    cd.chkSname();
	    cd.chkSmail();
	    cd.chkSphn();
	    cd.chkScity();
	    
	}


}
