package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import Steps.DepositSteps;

public class Deposit {
    @Steps
    DepositSteps deposit;

    @And("^User clicks on deposit$")
    public void userClicksOnDeposit() {
        deposit.clickOnDeposit();
    }

    @Then("^Input data to deposit form and verify the deposit function works correctly$")
    public void inputAllFieldsOfNewAccountFormAndVerifyAccountIsCreatedSuccessfully(DataTable dataTable) {
        deposit.verifyNewDepositCreatedSuccessfully(dataTable);
    }

}