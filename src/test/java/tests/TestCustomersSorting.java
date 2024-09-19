package tests;

import helpers.ListHelpers;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomersPage;
import pages.ManagerPage;

import java.util.List;

public class TestCustomersSorting extends BaseTest {
    @Test(description = "Сортировка клиентов")
    public void sortingCustomers() {
        new ManagerPage().openAddCustomerPage().customersClick();
        List<String> firstNameList = CustomersPage.collectCustomersFirstName();
        ListHelpers.sortReverseAlphabetically(firstNameList);
        CustomersPage customersPage = new CustomersPage().clickFirstNameSorting();
        List<String> sortedList1 = CustomersPage.collectCustomersFirstName();
        Assert.assertEquals(sortedList1, firstNameList, "Сортировка не в алфавитном порядке");
    }
}
