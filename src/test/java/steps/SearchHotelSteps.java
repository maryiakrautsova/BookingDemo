package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.awt.*;

import static com.codeborne.selenide.Selenide.*;

public class SearchHotelSteps {
    @Before
    public void setUp() {
        Configuration.timeout = 6000;
        Dimension size
                = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) size.getWidth();
        int height = (int) size.getHeight() - 50;
        Configuration.browserSize = String.format("%dx%d", width, height);
    }

    @Given("Main Booking page is opened")
    public void mainBookingPageIsOpened() {
        open("https://www.booking.com/searchresults.en-gb.html");
    }

    @When("User inputs {string}")
    public void userInputs(String propertyName) {
        String propertyNameInputXpath = String.format("//input[contains(@placeholder,'Where are you going?')]", propertyName);
        $(By.xpath(propertyNameInputXpath)).shouldBe(Condition.visible).sendKeys("Filitheyo Island Resort");
    }

    @And("Clicks {string}")
    public void clicks(String searchButton) {
        $(By.xpath("//span[text()='Search']")).click();
    }

    @Then("{string} hotel is present on the search result list.")
    public void hotelIsPresentOnTheSearchResultList(String hotelName) {
        String hotelNameXpath = String.format("//div[text()='Filitheyo Island Resort']", hotelName);
        boolean isChosenHotelPresent = $(By.xpath(hotelNameXpath)).isDisplayed();
        Assert.assertTrue(isChosenHotelPresent, "Chosen hotel is not on the list.");
    }

    @Then("{string} rating is present.")
    public void ratingIsPresent(String ratingValue) {
        String hotelRatingXpath = String.format("//div[contains(@aria-label,'Scored 8.7 ')]", ratingValue);
        String actualHotelRatingValue = $(By.xpath(hotelRatingXpath)).getText();
        Assert.assertEquals(actualHotelRatingValue, "8.7");
    }
}
