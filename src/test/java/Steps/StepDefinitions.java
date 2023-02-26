package Steps;
import AmazonHome.AmazonHome;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.BrowserManager;
import utils.QAProps;
import utils.TestDataReader;

import java.util.HashMap;

public class StepDefinitions {
    private WebDriver driver;
    String url;
    AmazonHome AmazonHome;
    HashMap<String, String> data;
    Scenario scenario;

    public StepDefinitions(BrowserManager browserManager) {
        this.driver = browserManager.getDriver();
    }

    @Before(order = 1)
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("The user is navigated to the Amazon website and the search bar is visible.")
    public void theUserIsNavigatedToTheAmazonWebsiteAndTheSearchBarIsVisible() {
        url = QAProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("the user enters a product in the search bar and hits the enter key.")
    public void theUserEntersAProductInTheSearchBarAndHitsTheEnterKey() {
        AmazonHome = new AmazonHome(driver);
        AmazonHome.getSearchBox().sendKeys(data.get("Input"));
        AmazonHome.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("The search results page should display all the related products.")
    public void theSearchResultsPageShouldDisplayAllTheRelatedProducts() {
        String text = AmazonHome.getSearchResult().getText();
        System.out.println(text);
        text = text.replace("\"","");
        Assert.assertEquals(text, data.get("Input"));
    }

    @Given("The user is on the Amazon website.")
    public void theUserIsOnTheAmazonWebsite() {
        url = QAProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("The user enters multiple keywords in the search bar separated by space.")
    public void theUserEntersMultipleKeywordsInTheSearchBarSeparatedBySpace() {
        AmazonHome = new AmazonHome(driver);
        AmazonHome.getSearchBox().sendKeys(data.get("Input"));
        AmazonHome.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("The search results page should display all the relevant products.")
    public void theSearchResultsPageShouldDisplayAllTheRelevantProducts() {
        String text = AmazonHome.getSearchResult().getText();
        System.out.println(text);
        text = text.replace("\"","");
        Assert.assertEquals(text, data.get("Input"));
    }

    @Given("The user is navigated on to the Amazon website and the search bar is visible.")
    public void theUserIsNavigatedOnToTheAmazonWebsiteAndTheSearchBarIsVisible() {
        url = QAProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("The user enters special characters in the search bar.")
    public void theUserEntersSpecialCharactersInTheSearchBar() {
        AmazonHome = new AmazonHome(driver);
        AmazonHome.getSearchBox().sendKeys(data.get("Input"));
        AmazonHome.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("The search results page should display relevant message indicating characters not found.")
    public void theSearchResultsPageShouldDisplayRelevantMessageIndicatingCharactersNotFound() {
        String text = AmazonHome.getNegativeResult().getText();
        System.out.println(text);
        Assert.assertEquals(text, "Try checking your spelling or use more general terms");
    }

    @Given("the user is on the Amazon website and search bar is visible.")
    public void theUserIsOnTheAmazonWebsiteAndSearchBarIsVisible() {
        url = QAProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("the user DoesNot enter the input and click on search bar.")
    public void theUserDoesNotEnterTheInputAndClickOnSearchBar() {
        AmazonHome = new AmazonHome(driver);
        AmazonHome.getSearchBox().sendKeys("" + data.get("Input"));
        AmazonHome.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("The Search bar should display all the valid results")
    public void theSearchBarShouldDisplayAllTheValidResults() {
        String text = AmazonHome.getSearchResult().getText();
        System.out.println(text);
        text = text.replace("\"","");
        Assert.assertEquals(text, ""+data.get("Input"));
    }

    @Given("the user is navigate to the amazon AmazonHome")
    public void theUserIsNavigateToTheAmazonAmazonHome() {
        url = QAProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("the user enters {string} in the search bar")
    public void theUserEntersInTheSearchBar(String arg0) {
        AmazonHome = new AmazonHome(driver);
        AmazonHome.getSearchBox().sendKeys(arg0);
        AmazonHome.getSearchBox().sendKeys(Keys.ENTER);
    }

    @Then("the search bar should display all the related results {string} .")
    public void theSearchBarShouldDisplayAllTheRelatedResults(String arg0) {
        String text = AmazonHome.getSearchResult().getText();
        System.out.println(text);
        text = text.replace("\"","");
        Assert.assertEquals(text, arg0);
    }

    @Given("user is able to access the search bar")
    public void userIsAbleToAccessTheSearchBar() {
        System.out.println("Search bar is accessable to the User");
    }
}
