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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterSteps {

    private final WebDriver driver = new ChromeDriver();
    private final User user = new User();
    private HomePage homepage;
    private AuthenticationPage authenticationPage;
    private RegistrationPage registrationPage;
    private MyAccountPage myAccountPage;

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homepage = new HomePage(driver);
        homepage.home();
        assertTrue(homepage.isCurrent());
    }

    @When("I sign in")
    public void iSignIn() {
        homepage.signIn();
    }

    @And("enter an email address to create an account")
    public void enterAnEmailAddressToCreateAnAccount() {
        authenticationPage = new AuthenticationPage(driver, user);
        assertTrue(authenticationPage.isCurrent());
        authenticationPage.createAnAccount();
    }

    @And("I fill in the registration form")
    public void iFillInTheRegistrationForm() {
        registrationPage = new RegistrationPage(driver, user);
        registrationPage.fillInForm();
    }

    @Then("I am registered and logged in")
    public void iAmRegisteredAndLoggedIn() {
        myAccountPage = new MyAccountPage(driver);
        assertTrue(myAccountPage.isCurrent());
    }

    @And("try to create account without filling in the form")
    public void tryToCreateAccountWithoutFillingInTheForm() {
        registrationPage = new RegistrationPage(driver, user);
        registrationPage.submit();
    }

    @Then("I will get an error")
    public void iWillGetAnError() {
        assertEquals(8, registrationPage.getErrorCount());
    }

    public boolean isCurrent() {
        return "My Store".equals(driver.getTitle());
    }
}
