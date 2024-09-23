package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.BasePage;

import java.io.IOException;
import java.time.Duration;

public abstract class BaseTest {
    protected static WebDriver driver;
    @BeforeTest
    public void setUp() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(80));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        BasePage.setDriver(driver);
    }

    @AfterTest
    public void closeDriver() {
        //driver.close();
        //driver.quit();
    }
}
