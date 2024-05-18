package AdminTests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Helper.Base;
import POM.AddNewGiftCardPage;
import Utility.utility;

public class AddNewGiftCardTests extends Base{
	public String sheetname = "sheetname";
	
  @Test
  public void verifyAddNewManufactures() throws IOException, InterruptedException {
	  
	  utility util = new utility();
	  util.adminLogin((this.getData(this.getProperty(this.sheetname), 1, 0)), (this.getData(this.getProperty(this.sheetname), 1, 1)));
	  
	 
	  AddNewGiftCardPage giftCardPage = PageFactory.initElements(driver, AddNewGiftCardPage.class); 
	  
	  giftCardPage.clickSaleIcon();
      giftCardPage.clickGiftCardOption();
      giftCardPage.clickAddNewButton();
      giftCardPage.increaseInitialValue();
      giftCardPage.clickGiftCardBox();
      giftCardPage.clickCouponCode();
      giftCardPage.fillRecipientsName("Recipient's Name");
      giftCardPage.fillRecipientsEmail("recipient@email.com");
      giftCardPage.fillSenderName("Sender's Name");
      giftCardPage.fillSendermail("sender@email.com");
      giftCardPage.fillMessage("This is a test message.");
	  
  }
  
}
	  