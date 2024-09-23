package tests;

import helpers.ListHelpers;
import helpers.SearchNameToDelete;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomersPage;
import pages.ManagerPage;

import java.util.List;

public class TestDeleteCustomer extends BaseTest {
    @Test(description = "Удаление клиента")
    public void sortingCustomers() {
        new ManagerPage()
                .openManagerPage()
                .customersClick();
        List<String> listLongName = CustomersPage.collectCustomersFirstName();
        ListHelpers.sortAlphabetically(listLongName);
        String nameForDeletion = SearchNameToDelete.findClosestNameToAverageLength(listLongName);
        new CustomersPage()
                .searchCustomers(nameForDeletion)
                .deleteCustomer()
                .refreshPage();
        List<String> listNames = CustomersPage.collectCustomersFirstName();
        Assert.assertFalse(listNames.contains(nameForDeletion), "Имя не удалено");
    }
}
