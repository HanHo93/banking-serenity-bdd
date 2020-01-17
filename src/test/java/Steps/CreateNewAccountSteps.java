package Steps;

import PageObject.CreateNewAccountPage;
import cucumber.api.DataTable;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class CreateNewAccountSteps extends CreateNewAccountPage {
    CreateNewAccountPage createAcc;

    @Step("^User clicks on add new account$")
    public void clickOnCreateNewAccount() {
        createAcc.clickCreateNewAccBtn();
    }

    @Step("^Input all fields of new account form and verify account is created successfully$")
    public void createNewAccountSuccessfully(DataTable dataTable) {
        createAcc.inputAllFieldsOfNewAccountForm(dataTable);
        createAcc.verifyNewAccountInfoShowsCorrectly(dataTable);
        createAcc.verifyTabletHeadingDisplaysCorrectly();

        // get all info of new account and store in session
        Serenity.setSessionVariable("AccountId").to(createAcc.getAccountInfo("Account ID"));
        Serenity.setSessionVariable("CurrentAmount").to(createAcc.getAccountInfo("Current Amount"));
    }

}
