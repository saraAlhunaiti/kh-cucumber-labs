package pages;

import automationpractice.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.How.ID;
import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AuthenticationPage {
    private final WebDriver driver;
    private final User user;

    @FindBy(how = ID, using = "email_create")
    private WebElement emailBox;

    @FindBy(how = ID, using = "SubmitCreate")
    private WebElement submit;

    public AuthenticationPage(WebDriver driver, User user) {
        this.user = user;
        this.driver = driver;
        new WebDriverWait(driver, 10).until(elementToBeClickable(id("email_create")));
        initElements(driver, this);
    }

    public void createAnAccount() {
        emailBox.sendKeys(user.generateEmail());
        submit();
    }

    public void submit() {
        submit.click();
    }


    public boolean isCurrent() {
        return "Login - My Store".equals(driver.getTitle());
    }

}
