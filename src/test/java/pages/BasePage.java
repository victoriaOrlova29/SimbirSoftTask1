package pages;

import lombok.Setter;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    String urlFromProperty=System.getProperty("url");
    @Setter
    protected static WebDriver driver;

    public void refreshPage() {
        driver.navigate().refresh();
    }
}
