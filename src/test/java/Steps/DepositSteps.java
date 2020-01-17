package Steps;

import PageObject.DepositPage;
import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;

public class DepositSteps {

    DepositPage deposit;

    @Step("^User clicks on deposit$")
    public void clickOnDeposit() {
        deposit.clickDepositBtn();
    }

    @Step("^Input data to deposit form and verify the deposit function works correctly$")
    public void verifyNewDepositCreatedSuccessfully(DataTable dataTable) {
        deposit.inputAllFieldsOfDepositForm(dataTable);
        deposit.verifyDepositInfoShowsCorrectly(dataTable);
        deposit.verifyTabletHeadingDisplaysCorrectly();
    }
}
