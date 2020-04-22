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
    private HomePage homepage;
    private AuthenticationPage authenticationPage;
    private RegistrationPage registrationPage;
    private MyAccountPage myAccountPage;
    private SearchPage searchPage;

    private Map<String, Integer> stockLevels;

    @Given("^I am authenticated$")
    public void authenticate() {
        homepage = new HomePage(driver);
        homepage.home();
        homepage.signIn();
        authenticationPage = new AuthenticationPage(driver, user);
        authenticationPage.createAnAccount();

        sleep(3000);

        registrationPage = new RegistrationPage(driver, user);
        registrationPage.fillInForm();

        sleep(3000);

        myAccountPage = new MyAccountPage(driver);
        assertTrue(myAccountPage.isCurrent());
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^the current stock levels are$")
    public void storeStockLevels(Map<String, Integer> stockLevels) {
        this.stockLevels = stockLevels;
    }

    @When("^I search for (-?.+)$")
    public void searchForItem(String item) {
        searchPage = new SearchPage(driver);
        searchPage.search(item);
    }

    @Then("^the result count for (-?.+) is the same as the stock count for that item$")
    public void thenResultsMatchStock(String item) {
        assertEquals(stockLevels.get(item).intValue(), searchPage.getProductCount());
    }
}
