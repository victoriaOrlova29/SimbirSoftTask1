package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage extends BasePage {
    @FindBy(xpath = "//input[@ng-model='fName']")
    private WebElement fillFirstName;

    @FindBy(xpath = "//input[@ng-model='lName']")
    private WebElement fillLastName;

    @FindBy(xpath = "//input[@ng-model='postCd']")
    private WebElement fillPostCode;

    @FindBy(xpath = "//button[@class=\"btn btn-default\"]")
    private WebElement addCustomerButton;

    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Заполняем First Name")
    public AddCustomerPage fillFirstName(String firstName) {
        fillFirstName.sendKeys(firstName);
        return new AddCustomerPage();
    }

    @Step("Заполняем Last Name")
    public AddCustomerPage fillLastName(String lastName) {
        fillLastName.sendKeys(lastName);
        return new AddCustomerPage();
    }

    @Step("Заполняем PostCode")
    public AddCustomerPage fillPostCode(String postCode) {
        fillPostCode.sendKeys(postCode);
        return new AddCustomerPage();
    }

    @Step("Нажимаем кнопку Add Customer")
    public AddCustomerPage clickAddCustomerPageButton() {
        addCustomerButton.click();
        return new AddCustomerPage();
    }

    @Step("Нажимаем кнопку Ok")
    public AddCustomerPage acceptAlert() {
        driver.switchTo().alert().accept();
        return new AddCustomerPage();
    }
}
