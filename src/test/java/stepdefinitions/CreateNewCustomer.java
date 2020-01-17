package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import Steps.CreateNewCustomerSteps;

public class CreateNewCustomer {
    @Steps
    CreateNewCustomerSteps create;

    @When("^User clicks on add new customer$")
    public void clickOnAddNewCustomer() {
        create.clickOnCreateNewCustomer();
    }

    @Then("^Input all fields of create customer form and verify new customer is created successfully$")
    public void inputAllFieldsOfCreateCustomerFormAndVerifyNewCustomerIsCreatedSuccessfully(DataTable dataTable) {
        create.createNewCustomerAndVerifyCustomerInfo(dataTable);
    }
}
