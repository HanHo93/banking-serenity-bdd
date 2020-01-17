package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import Steps.CreateNewAccountSteps;

public class CreateNewAccount {
    @Steps
    CreateNewAccountSteps account;

    @When("^User clicks on add new account$")
    public void clickOnAddNewAccount() {
        account.clickOnCreateNewAccount();
    }

    @And("^Input all fields of new account form and verify account is created successfully$")
    public void inputAllFieldsOfNewAccountFormAndVerifyAccountIsCreatedSuccessfully(DataTable dataTable) {
        account.createNewAccountSuccessfully(dataTable);
    }
}
