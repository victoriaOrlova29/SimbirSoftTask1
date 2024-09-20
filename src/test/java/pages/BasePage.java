package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    public static final String URL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager";

    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}
