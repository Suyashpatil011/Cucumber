package StepDefinitions;

import Utils.TestSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LandingPageStepDefinition {

    TestSetup testSetup;
    public WebDriver driver;
    public String landingPageProductName;


    public LandingPageStepDefinition(TestSetup testSetup) {

        this.testSetup = testSetup;
    }

    @Given("User is on Greencard Landing Page")
    public void user_is_on_greencard_landing_page() {
        testSetup.driver = new ChromeDriver();
        testSetup.driver.manage().window().maximize();
        testSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("User search the with shortname with {string} and extracted actual name of Product")
    public void user_search_the_with_shortname_with_and_extracted_actual_name_of_product(String shortname) {

        testSetup.driver.findElement(By.xpath("//input[@class='search-keyword']")).sendKeys(shortname);
        WebDriverWait wait = new WebDriverWait(testSetup.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("h4[class='product-name']"), 1));
        testSetup.landingPageProductName = testSetup.driver.findElement(By.cssSelector("h4[class='product-name']")).getText().split("-")[0].trim();
        System.out.println(testSetup.landingPageProductName + " is extracted from the Home Page");
    }

}
