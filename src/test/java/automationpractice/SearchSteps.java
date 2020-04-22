package automationpractice;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegistrationPage;
import pages.SearchPage;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchSteps {
    private final WebDriver driver = new ChromeDriver();
    private final User user = new User();
    private final HomePage homepage = new HomePage(driver);
    private final AuthenticationPage authenticationPage = new AuthenticationPage(driver, user);
    private final RegistrationPage registrationPage = new RegistrationPage(driver, user);
    private final MyAccountPage myAccountPage = new MyAccountPage(driver);
    private final SearchPage searchPage = new SearchPage(driver);

    private Map<String, Integer> stockLevels;

    @Given("^I am authenticated$")
    public void authenticate() {
        homepage.home();
        homepage.signIn();
        authenticationPage.createAnAccount();
        registrationPage.fillInForm();
        assertTrue(myAccountPage.isCurrent());
    }

    @And("^the current stock levels are$")
    public void storeStockLevels(Map<String, Integer> stockLevels) {
        this.stockLevels = stockLevels;
    }

    @When("^I search for (-?.+)$")
    public void searchForItem(String item) {
        searchPage.search(item);
    }

    @Then("^the result count for (-?.+) is the same as the stock count for that item$")
    public void thenResultsMatchStock(String item) {
        assertEquals(stockLevels.get(item).intValue(), searchPage.getProductCount());
    }
}
