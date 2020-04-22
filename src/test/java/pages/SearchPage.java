package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Integer.parseInt;

public class SearchPage {
    private WebDriver driver;

    @FindBy(how = How.ID, using = "search_query_top")
    private WebElement searchBox;

    @FindBy(how = How.CSS, using = "div.product-count")
    private WebElement productCount;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search(String item) {
        searchBox.sendKeys(item);
        searchBox.submit();
    }

    public int getProductCount() {
        return parseInt(productCount.getText().trim().split(" ")[5]);
    }
}
