package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddNewProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//i[@class='nav-icon fas fa-book']")
    private WebElement catalogIcon;

    @FindBy(xpath = "//p[text()=' Products']")
    private WebElement productsOption;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement addNewButton;

    @FindBy(xpath = "//input[@id='Name']")
    private WebElement productName;

    @FindBy(xpath = "//textarea[@id='ShortDescription']")
    private WebElement shortDescription;

    @FindBy(xpath = "//*[@id='FullDescription_ifr']")
    private WebElement fullDescriptionFrame;

    @FindBy(xpath = "//*[@id='tinymce']")
    private WebElement fullDescription;

    @FindBy(xpath = "(//input[@class='form-control text-box single-line'])[1]")
    private WebElement sku;

    @FindBy(xpath = "(//div[@class='k-multiselect-wrap k-floatwrap'])[1]")
    private WebElement categoryElement;

    @FindBy(xpath = "//*[@id=\"SelectedCategoryIds_listbox\"]/li[7]")
    private WebElement addElement;

    @FindBy(xpath = "(//div[@class='k-multiselect-wrap k-floatwrap'])[2]")
    private WebElement manufacturersDivElement;
    
    @FindBy(xpath = "//*[@id=\"SelectedManufacturerIds_listbox\"]/li[1]") 
    private WebElement manufacturersName; 
    
    @FindBy(xpath = "(//span[@class='k-icon k-i-calendar'])[1]")
    private WebElement startDateCalendarButton;

    @FindBy(xpath = "//div[@id='AvailableStartDateTimeUtc_dateview']")
    private WebElement startDatePicker;

    @FindBy(xpath = "//a[@aria-live='assertive']")
    private WebElement currentMonthYearLabel;

    @FindBy(xpath = "//a[@aria-label='Previous']")
    private WebElement previousButton;

    @FindBy(xpath = "//a[@data-value='2023/0/1']")
    private WebElement startDate2023;

    @FindBy(xpath = "//span[@aria-controls='AvailableEndDateTimeUtc_dateview']")
    private WebElement endDateCalendarButton;
    
    @FindBy(xpath = "//div[@id='AvailableEndDateTimeUtc_dateview']")
    private WebElement EndDatePicker;

    @FindBy(xpath = "(//a[@aria-live='assertive'])[2]")
    private WebElement currentMonthYearLabel2;

    @FindBy(xpath = "(//a[@aria-label='Next'])[2]")
    private WebElement nextButton;

    @FindBy(xpath = "//a[@data-value='2025/0/1']")
    private WebElement endDate2025;

    
    public AddNewProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickCatalogIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(catalogIcon)).click();
    }

    public void clickProductsOption() {
        wait.until(ExpectedConditions.elementToBeClickable(productsOption)).click();
    }

    public void clickAddNewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addNewButton)).click();
    }

    public void fillProductName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(productName)).sendKeys(name);
    }

    public void fillShortDescription(String description) {
        wait.until(ExpectedConditions.elementToBeClickable(shortDescription)).sendKeys(description);
    }

    public void switchToFullDescriptionFrame() {
        driver.switchTo().frame(fullDescriptionFrame);
    }

    public void fillFullDescription(String description) {
        wait.until(ExpectedConditions.elementToBeClickable(fullDescription)).sendKeys(description);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void fillSku(String sku) {
        wait.until(ExpectedConditions.elementToBeClickable(this.sku)).sendKeys(sku);
    }

    public void clickCategoryElement() {
        wait.until(ExpectedConditions.elementToBeClickable(categoryElement)).click();
    }

    public void clickAddElement() {
        wait.until(ExpectedConditions.elementToBeClickable(addElement)).click();
    }

    public void clickManufacturersDivElement() {
        WebElement manufacturersDivElement = driver.findElement(By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[2]"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", manufacturersDivElement);
        
        wait.until(ExpectedConditions.elementToBeClickable(manufacturersDivElement)).click();
    }

    public void selectManufacturerName() {
        wait.until(ExpectedConditions.elementToBeClickable(manufacturersName)).click();
    }

    public void clickStartDateCalendarButton() {
        wait.until(ExpectedConditions.elementToBeClickable(startDateCalendarButton)).click();
    }

    public void waitStartDatePickerVisibility() {
        wait.until(ExpectedConditions.visibilityOf(startDatePicker));
    }

    public String getCurrentMonthYear() {
        return currentMonthYearLabel.getText();
    }

    public void clickPreviousButton() {
        wait.until(ExpectedConditions.elementToBeClickable(previousButton)).click();
    }

    public void clickStartDate2023() {
        startDate2023.click();
    }

    public void clickEndDateCalendarButton() {
        wait.until(ExpectedConditions.elementToBeClickable(endDateCalendarButton)).click();
    }
    
    public void waitEndDatePickerVisibility() {
        wait.until(ExpectedConditions.visibilityOf(EndDatePicker));
    }

    public String getCurrentMonthYear2() {
        return currentMonthYearLabel2.getText();
    }
    
    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void clickEndDate2025() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(endDate2025)).click();
        } catch (StaleElementReferenceException e) {
            endDate2025 = driver.findElement(By.xpath("//a[@data-value='2025/0/1']"));
            clickEndDate2025(); // Recursive call after refreshing the element reference
        }
    }
    
}










       

