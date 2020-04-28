package pages;

import automationpractice.User;
import org.openqa.selenium.WebDriver;

import static java.lang.Integer.parseInt;

public class LoginPage extends Page {
    private static final String PATH_ERRORS = "/html/body/div/div[2]/div/div[3]/div/div/p";

    private User user;

    public LoginPage(WebDriver driver, User user) {
        super(driver, "Login - My Store");
        this.user = user;
    }

    public void fillInForm() {

        fill("email", user.getEmail());
        fill("passwd", user.getPassword());
        submit();
    }

    public void submit() {
        click("SubmitLogin");
    }

    public int getErrorCount() {
        return parseInt(getText(PATH_ERRORS).split(" ")[2]);
    }

    @Override
    public boolean isCurrent() {
        return super.exists("center_column");
    }
}
