package automationpractice;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "summary"},
        strict = true,
        snippets = CAMELCASE,
        tags = "not @wip",
        features = "src/test/resources/features")
public class RunAllFeatures {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(SEVERE);
    }
}
