package AdminTests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Helper.Base;
import POM.AddNewProductPage;
import Utility.utility;

public class AddNewProductTests extends Base{
	public String sheetname = "sheetname";
	
  @Test
  public void verifyAddNewProduct() throws IOException, InterruptedException {
	  
	  utility util = new utility();
	  util.adminLogin((this.getData(this.getProperty(this.sheetname), 1, 0)), (this.getData(this.getProperty(this.sheetname), 1, 1)));
      
	  
      AddNewProductPage addNewProductPage = PageFactory.initElements(driver, AddNewProductPage.class);

      addNewProductPage.clickCatalogIcon();
      addNewProductPage.clickProductsOption();
      addNewProductPage.clickAddNewButton();
      
      addNewProductPage.fillProductName("Apple Iphone 15 Pro Max");
     
      addNewProductPage.fillShortDescription("The iPhone 15 Pro Max is a top-tier smartphone offering a gorgeous design, a powerful camera system, "
              + "lightning-fast performance, extended battery life, and advanced connectivity, running on the latest iOS software.");
      
      addNewProductPage.switchToFullDescriptionFrame();
      addNewProductPage.fillFullDescription("The iPhone 15 Pro Max epitomizes Apple's smartphone prowess, boasting a sleek design housing a larger OLED display with potential enhancements in resolution and refresh rate."
              + " Anticipate a revamped camera system delivering superior low-light performance, improved zoom capabilities, and sharper imaging, supported by Apple's latest chipset promising unparalleled speed and efficiency. "
              + "Battery life might see upgrades, complementing faster 5G connectivity and advanced Wi-Fi technology. Running on the latest iOS, the phone could introduce new features while refining security and productivity, "
              + "potentially integrating further advancements in augmented reality (AR) capabilities.");
      addNewProductPage.switchToDefaultContent();
     
      addNewProductPage.fillSku("I-PHN-15-PRO-MAX");
      
      addNewProductPage.clickCategoryElement();
      addNewProductPage.clickAddElement();
      
      addNewProductPage.clickManufacturersDivElement();
      addNewProductPage.selectManufacturerName();
      
      addNewProductPage.clickStartDateCalendarButton();
      addNewProductPage.waitStartDatePickerVisibility();

      while (!addNewProductPage.getCurrentMonthYear().equals("January 2023")) {
          addNewProductPage.clickPreviousButton();
      }

      addNewProductPage.clickStartDate2023();

      addNewProductPage.clickEndDateCalendarButton();
      addNewProductPage.waitEndDatePickerVisibility();

      while (!addNewProductPage.getCurrentMonthYear2().equals("January 2025")) {
          addNewProductPage.clickNextButton();
      }

      addNewProductPage.clickEndDate2025();
      
      
      
  }

}




    
