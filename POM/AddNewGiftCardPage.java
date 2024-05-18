package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewGiftCardPage {

 private WebDriverWait wait;
 
 @FindBy(xpath = "//i[@class='nav-icon fas fa-shopping-cart']")
 private WebElement saleIcon;

 @FindBy(xpath = "//p[text()=' Gift cards']")
 private WebElement giftCardOption;

 @FindBy(xpath = "//a[@class='btn btn-primary']")
 private WebElement addNewButton;

 @FindBy(xpath = "//span[@class='k-link k-link-increase']")
 private WebElement initialValue;

 @FindBy(xpath = "//input[@id='IsGiftCardActivated']")
 private WebElement giftCardBox;

 @FindBy(xpath = "//button[@id='generateCouponCode']")
 private WebElement couponCode;

 @FindBy(xpath = "//input[@id='RecipientName']")
 private WebElement recipientsName;

 @FindBy(xpath = "//input[@id='RecipientEmail']")
 private WebElement recipientsEmail;

 @FindBy(xpath = "//input[@id='SenderName']")
 private WebElement senderName;

 @FindBy(xpath = "//input[@id='SenderEmail']")
 private WebElement sendermail;

 @FindBy(xpath = "//textarea[@id='Message']")
 private WebElement message;

 
 public AddNewGiftCardPage(WebDriver driver) {
     this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 }

 public void clickSaleIcon() {
     wait.until(ExpectedConditions.elementToBeClickable(saleIcon)).click();
 }

 public void clickGiftCardOption() {
     wait.until(ExpectedConditions.elementToBeClickable(giftCardOption)).click();
 }

 // Method to click on the Add New Button
 public void clickAddNewButton() {
     wait.until(ExpectedConditions.elementToBeClickable(addNewButton)).click();
 }

 public void increaseInitialValue() {
     for (int i = 0; i < 20; i++) {
         wait.until(ExpectedConditions.elementToBeClickable(initialValue)).click();
     }
 }

 public void clickGiftCardBox() {
     wait.until(ExpectedConditions.elementToBeClickable(giftCardBox)).click();
 }
 
 public void clickCouponCode() {
     wait.until(ExpectedConditions.elementToBeClickable(couponCode)).click();
 }

 public void fillRecipientsName(String name) {
     wait.until(ExpectedConditions.elementToBeClickable(recipientsName)).sendKeys(name);
 }

 public void fillRecipientsEmail(String email) {
     wait.until(ExpectedConditions.elementToBeClickable(recipientsEmail)).sendKeys(email);
 }

 public void fillSenderName(String name) {
     wait.until(ExpectedConditions.elementToBeClickable(senderName)).sendKeys(name);
 }

 public void fillSendermail(String email) {
     wait.until(ExpectedConditions.elementToBeClickable(sendermail)).sendKeys(email);
 }

 public void fillMessage(String messageText) {
     wait.until(ExpectedConditions.elementToBeClickable(message)).sendKeys(messageText);
 }
}
