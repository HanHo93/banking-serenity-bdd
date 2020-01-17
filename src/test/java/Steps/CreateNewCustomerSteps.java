package Steps;

import PageObject.CreateNewCustomerPage;
import cucumber.api.DataTable;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class CreateNewCustomerSteps extends CreateNewCustomerPage{
    CreateNewCustomerPage create;

    @Step("^user clicks on add new customer$")
    public void clickOnCreateNewCustomer() {
        create.clickCreateNewCusBtn();
    }

    @Step("^Input all fields of create customer form and verify new customer is created successfully$")
    public void createNewCustomerAndVerifyCustomerInfo(DataTable dataTable) {
        create.inputAllFieldsOfNewCustomerForm(dataTable);
        create.verifyNewCustomerInfoShowsCorrectly(dataTable);
        create.verifyTabletHeadingDisplaysCorrectly();

        // get all info of new customer and store in session
        Serenity.setSessionVariable("CustomerId").to(create.getCustomerInfo("Customer ID"));
        Serenity.setSessionVariable("CustomerName").to(create.getCustomerInfo("Customer Name"));
        Serenity.setSessionVariable("Email").to(create.getCustomerInfo("Email"));

    }
}
