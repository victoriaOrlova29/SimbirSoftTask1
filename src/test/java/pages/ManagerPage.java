package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerPage extends BasePage {
    @FindBy(xpath = "//button[@ng-click='addCust()']")
    private WebElement addCustomer;

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    private WebElement customersButton;

    public ManagerPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Открываем страницу")
    public ManagerPage openManagerPage() {
        driver.get(URL);
        return new ManagerPage();
    }

    @Step("Нажимаем add Customer ")
    public AddCustomerPage clickAddCust() {
        addCustomer.click();
        return new AddCustomerPage();
    }

    @Step("Нажимаем кнопку Customers")
    public CustomersPage customersClick() {
        customersButton.click();
        return new CustomersPage();
    }
}
