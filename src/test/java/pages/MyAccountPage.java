package pages;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends Page {

    public MyAccountPage(WebDriver driver) {
        super(driver, "My account - My Store");
    }

    public void signOut(){
        cssClick("#header > div.nav > div > div > nav > div:nth-child(2) > a");
    }

}
