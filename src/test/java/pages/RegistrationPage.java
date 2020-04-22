package pages;

import automationpractice.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.How.ID;
import static org.openqa.selenium.support.How.XPATH;
import static org.openqa.selenium.support.PageFactory.initElements;

public class RegistrationPage {
    private static final String PATH_ERRORS = "/html/body/div/div[2]/div/div[3]/div/div/p";
    private final WebDriver driver;

    @FindBy(how = ID, using = "id_gender1")
    private WebElement gender;

    @FindBy(how = ID, using = "customer_firstname")
    private WebElement firstname;

    @FindBy(how = ID, using = "customer_lastname")
    private WebElement lastname;

    @FindBy(how = ID, using = "passwd")
    private WebElement password;

    @FindBy(how = ID, using = "days")
    private WebElement days;

    @FindBy(how = ID, using = "months")
    private WebElement months;

    @FindBy(how = ID, using = "years")
    private WebElement years;

    @FindBy(how = ID, using = "address1")
    private WebElement address;

    @FindBy(how = ID, using = "city")
    private WebElement city;

    @FindBy(how = ID, using = "id_state")
    private WebElement state;

    @FindBy(how = ID, using = "id_country")
    private WebElement country;

    @FindBy(how = ID, using = "postcode")
    private WebElement postcode;

    @FindBy(how = ID, using = "phone")
    private WebElement phone;

    @FindBy(how = ID, using = "alias")
    private WebElement alias;

    @FindBy(how = ID, using = "submitAccount")
    private WebElement register;

    @FindBy(how = XPATH, using = PATH_ERRORS)
    private WebElement errors;

    @FindBy(how = ID, using = "account-creation-form")
    private WebElement accountCreationForm;


    private User user;

    public RegistrationPage(WebDriver driver, User user) {
        this.driver = driver;
        this.user = user;
        initElements(driver, this);
    }

    private void selectFirst(WebElement element) {
        new Select(element).selectByIndex(1);
    }

    public void fillInForm() {
        gender.click();
        firstname.sendKeys("tester");
        lastname.sendKeys("Tester");
        password.sendKeys("wibble");
        selectFirst(days);
        selectFirst(months);
        selectFirst(years);
        address.sendKeys("wherever");
        city.sendKeys("Troy");
        selectFirst(state);
        selectFirst(country);
        postcode.sendKeys("00000");
        phone.sendKeys("02340982304");
        alias.sendKeys("tester" + user.getId());
        submit();
    }

    public void submit() {
        register.click();
    }

    public int getErrorCount() {
        return parseInt(errors.getText().split(" ")[2]);
    }

    public boolean isCurrent() {
        return accountCreationForm.isDisplayed();
    }
}
