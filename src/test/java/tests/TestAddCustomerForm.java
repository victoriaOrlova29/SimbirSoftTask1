package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.CustomersPage;
import pages.ManagerPage;

import static helpers.FakeUsersData.*;

public class TestAddCustomerForm extends BaseTest {
    @Test(description = "Создание клиента")
    public void fillCustomerForm() {
        new ManagerPage().openManagerPage().clickAddCust();
        AddCustomerPage addCustomerPage = new AddCustomerPage()
                .fillFirstName(getFirstName())
                .fillLastName(getLastName())
                .fillPostCode(getPostCode())
                .clickAddCustomerPageButton().
                acceptAlert();
        new ManagerPage().customersClick()
                .searchCustomers(getFirstName());
        Assert.assertTrue(CustomersPage.checkNamesListContainsFirstName(getFirstName()), "Пользователь не создан");
    }
}
