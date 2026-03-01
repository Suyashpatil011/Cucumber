package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
    public WebDriver driver;
    private By serach = By.xpath("//input[@id='search-field']");
    private By productName = By.cssSelector("tr td:nth-child(1)");


    public OfferPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchIteam(String name) {
        driver.findElement(serach).sendKeys(name);
    }

    public void getSearchText() {
        driver.findElement(serach).getText();
    }

    public String getproductName() {
        return driver.findElement(productName).getText();
    }



}
