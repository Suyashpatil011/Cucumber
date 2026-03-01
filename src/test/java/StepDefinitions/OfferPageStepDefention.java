package StepDefinitions;

import Utils.TestSetup;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.LandingPage;
import pageObject.OfferPage;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefention {

    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;
    TestSetup testSetup;

    public OfferPageStepDefention(TestSetup testSetup) {

        this.testSetup = testSetup;
    }
    @Then("User search the same shortname {string} in offer page")
    public void user_search_the_same_shortname_in_offer_page(String shortname) {

        SwichToOfferPage();
        OfferPage offerPage = new OfferPage(testSetup.driver);
        offerPage.searchIteam(shortname);
        offerPageProductName= offerPage.getproductName();

        ///testSetupdriver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortname);
        ///offerPageProductName = testSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();

        System.out.println(offerPageProductName + " is extracted from the Landing Page");

    }

    public  void SwichToOfferPage(){

        /// Switch to offer page--
        LandingPage landingPage = new LandingPage(testSetup.driver);
        landingPage.clickLink();
        ///testSetup.driver.findElement(By.linkText("Top Deals")).click();
        Set<String> s1 = testSetup.driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        testSetup.driver.switchTo().window(childWindow);
    }

    @Then("Validated product name in offerpage is maches with landingpage")
    public void Validated_product_name_in_offerpage_is_maches_with_landingpage() {

        Assert.assertEquals(testSetup.landingPageProductName, offerPageProductName);

    }

}
