package pages;

import org.openqa.selenium.WebDriver;

public class MyAccountPage  {
    private final WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCurrent() {
        return "My Store".equals(driver.getTitle());
    }

}
