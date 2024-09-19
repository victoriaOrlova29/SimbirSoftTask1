package tests;

import org.testng.annotations.Test;
import pages.CustomersPage;
import pages.ManagerPage;

import java.util.List;

public class TestDeliteCustomer extends BaseTest {
        @Test(description = "Удаление клиента")
        public void sortingCustomers() {
            new ManagerPage().openAddCustomerPage().customersClick();
            List<String> listLongName = CustomersPage.collectCustomersFirstName();
}}
