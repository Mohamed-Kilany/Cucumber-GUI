package Tests;

import Pages.HomePage;
import Pages.ResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static Utils.Utils.driver;

public class SearchTest {

    HomePage homePage;
    ResultsPage resultsPage;

    String CardClass;

    @Given("^User navigates to (.*) homepage$")
    public void navigateToHomePage(String searchEngine) {
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage();
        driver.get("https:www." + searchEngine + ".com");
        switch (searchEngine.toLowerCase()) {
            case "google" -> CardClass = "MjjYud";
            case "bing" -> CardClass = "b_algo";
        }
    }

    @When("^User enters a search term of (.*) and hits Enter$")
    public void searchForATerm(String searchTerm) {
        homePage.searchInput.clear();
        homePage.searchInput.sendKeys(searchTerm);
        homePage.searchInput.sendKeys(Keys.ENTER);
    }

    @Then("^Search results cards should contain (.*) confirming relevancy$")
    public void assertTheRelevancyOfResults(String resultTerm) {
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className(CardClass), 0));
        List<WebElement> cards = resultsPage.resultCards(CardClass);
        for (WebElement card : cards) {
            System.out.println(card.getText().toLowerCase());
            softAssert.assertTrue(card.getText().toLowerCase().contains(resultTerm.toLowerCase()));
        }
        softAssert.assertAll();
    }
}
