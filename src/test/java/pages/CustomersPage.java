package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CustomersPage extends BasePage {
    @Getter
    static final String FIRST_NAMES = "//tbody/tr/td[1]";

    @FindBy(xpath = "//input[@ng-model=\"searchCustomer\"]")
    private WebElement searchCustomer;

    @FindBy(xpath = "//a[@ng-click=\"sortType = 'fName'; sortReverse = !sortReverse\"]")
    private WebElement firstNameFilter;

    @Step("Поиск в Customers")
    public CustomersPage searchCustomers(String firstName) {
        searchCustomer.sendKeys(firstName);
        return new CustomersPage();
    }

    @Step("Фильтруем по first name")
    public CustomersPage clickFirstNameSorting() {
        firstNameFilter.click();
        return new CustomersPage();
    }

    public CustomersPage() {
        PageFactory.initElements(driver, this);
    }

    public static List<String> collectCustomersFirstName() throws IllegalStateException {
        List<String> allFirstNames = new ArrayList<>();
        driver.findElements(By.xpath(FIRST_NAMES))
                .stream()
                .forEach(firstName -> allFirstNames.add(firstName.getText()));
        if (allFirstNames.isEmpty()) {
            throw new IllegalStateException("Список имен пуст");
        }
        return allFirstNames;
    }

    public static boolean checkNamesListContainsFirstName(String firstName) {
        List<String> customersList = collectCustomersFirstName();
        return collectCustomersFirstName().contains(firstName);
    }

    public static void lengthsCustomer(List<String> customersList) {

        List<Integer> lengths = new ArrayList<>();
        for (String s : customersList) {
            Integer length = s.length();
            lengths.add(length);
        }

        // Находим среднее арифметическое длин
        double averageLength = lengths.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

      /*  // Находим имя с длиной, ближайшей к среднему
        Optional<firstName> closestCustomer = collectCustomersFirstName().stream()
                .min(Comparator.comparingInt(customer -> Math.abs(customersList.length() - averageLength)));*/
    }
}

