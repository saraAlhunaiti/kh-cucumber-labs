package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.How.CSS;
import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HomePage {
    private static WebDriver driver;
    public static final String PATH_SIGN_IN = "#header > div.nav > div > div > nav > div.header_user_info > a";
    private static final String URL = "http://automationpractice.com";

    @FindBy(how = CSS, using = PATH_SIGN_IN)
    private WebElement signIn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        home();
        new WebDriverWait(driver, 10).until(presenceOfElementLocated(id("page")));
        initElements(driver, this);
    }

    public void home() {
        driver.get(URL);
    }

    public void signIn() {
        signIn.click();
    }


    public boolean isCurrent() {
        return "My Store".equals(driver.getTitle());
    }
}
