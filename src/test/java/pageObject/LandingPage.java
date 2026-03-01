package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    public WebDriver driver;
    By serach = By.xpath("//input[@class='search-keyword']");
    By productName = By.cssSelector("h4[class='product-name']");
    private By link = By.linkText("Top Deals");


    public LandingPage(WebDriver driver) {
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

    public void clickLink() {
        driver.findElement(link).click();
    }

}
