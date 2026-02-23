package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class GreenCartStepDefinition {

    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;


    @Given("User is on Greencard Landing Page")
    public void user_is_on_greencard_landing_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }
    @When("User search the with shortname with {string} and extracted actual name of Product")
    public void user_search_the_with_shortname_with_and_extracted_actual_name_of_product(String shortname) {

        driver.findElement(By.xpath("//input[@class='search-keyword']")).sendKeys(shortname);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("h4[class='product-name']"),1));
        landingPageProductName = driver.findElement(By.cssSelector("h4[class='product-name']")).getText().split("-")[0].trim();
            System.out.println(landingPageProductName + " is extracted from the Home Page");
    }


    @Then("User search the same shortname {string} in offer page")
    public void user_search_the_same_shortname_in_offer_page(String shortname ) {

        driver.findElement(By.linkText("Top Deals")).click();

        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);


        driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortname);
        offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
        System.out.println(offerPageProductName + " is extracted from the Landing Page");

    }
    @Then("Validated product name in offerpage is maches with landingpage")
    public void Validated_product_name_in_offerpage_is_maches_with_landingpage(){

        Assert.assertEquals(landingPageProductName,offerPageProductName);

    }

}
