package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;

public abstract class Page {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }

    private final WebDriver driver;
    private String title;

    public Page(WebDriver driver, String title) {
        this.driver = driver;
        this.title = title;
    }


    public boolean isCurrent() {
        return title.equals(driver.getTitle());
    }

    protected void goTo(String url) {
        driver.get(url);
    }

    protected void cssClick(String path) {
        driver.findElement(By.cssSelector(path)).click();
    }

    protected String getText(String xPath) {
        return driver.findElement(By.xpath(xPath)).getText();
    }

    protected WebElement fill(String id, String value) {
        final WebElement element = waitFor(id);
        element.clear();
        element.sendKeys(value);
        return element;
    }

    protected void fillAndSubmit(String id, String value) {
        fill(id, value).submit();
    }

    protected void selectFirst(String id) {
        new Select(driver.findElement(By.id(id))).selectByIndex(1);
    }

    protected void click(String id) {
        waitFor(id).click();
    }

    private WebElement waitFor(String id) {
        return waitFor(id, 5);
    }

    private WebElement waitFor(String id, int waitInterval) {
        return (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    protected boolean exists(String id) {
        return driver.findElement(By.id(id)) != null;
    }
}
