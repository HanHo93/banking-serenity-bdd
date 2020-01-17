package PageObject;

import Utils.Assertions;
import Utils.ElementActions;
import cucumber.api.DataTable;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public class DepositPage extends UIInteractionSteps {
    ElementActions action = new ElementActions();
    public String successMessage = "Transaction details of Deposit for Account ";

    //OBJECT LOCATORS
    public static By depositBtn = By.xpath("//a[contains(@href, 'DepositInput')]");
    public static By depositIdTxt = By.name("accountno");
    public static By amountTxt = By.name("ammount");
    public static By descriptionTxt = By.name("desc");
    public static By submitBtn = By.name("AccSubmit");
    public static By columnValue( String value){ return By.xpath("//*[@id='deposit']//tr/td[contains(text(),'"+value+"')]/following-sibling::td"); }
    public static By tableHeading = By.cssSelector("#deposit tr td p.heading3");
    public static By closeIframe = By.id("flow_close_btn_iframe");
    public static By closeBtn = By.id("closeBtn");


    //ACTIONS
    public void clickDepositBtn() {
        action.switchToIframeAndClick(closeIframe, closeBtn, "iframe", "'Close' button");
       action.click(depositBtn, "'Deposit' button");
    }

    public void clickSubmitBtn() {
        action.click(submitBtn, "'Submit' button");
    }

    public void inputAccountId() {
        String userId = Serenity.sessionVariableCalled("AccountId");
        action.inputText(depositIdTxt, userId, "'Account ID' text box");
    }

    public void inputAmount(String amount) {
        action.inputText(amountTxt, amount, "'Amount' text box ");
    }

    public void inputDescription(String text) {
        action.inputText(descriptionTxt, text, "'Description' text box ");
    }
    public String getDepositInfo(String columnName){
        return action.getText(columnValue(columnName),"" );
    }
    public void inputAllFieldsOfDepositForm(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (String key : data.get(0).keySet()) {
            String value = data.get(0).get(key).trim();
            switch (key) {
                case "Account Id":
                    inputAccountId();
                    break;
                case "Amount Credited":
                    inputAmount(value);
                    break;
                case "Description":
                    inputDescription(value);
                    break;
            }
        }
        clickSubmitBtn();
    }
    public String getTableHeading(){
        return action.getText(tableHeading, "'Table Heading' text");
    }

    public int getCurrentAmount(){
        return Integer.parseInt(getDepositInfo("Amount Credited"))+ Integer.parseInt(Serenity.sessionVariableCalled("CurrentAmount"));
    }


    //ASSERTIONS
    public void verifyDepositInfoShowsCorrectly(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (String key : data.get(0).keySet()) {
            String expectedValue = data.get(0).get(key).trim();
            switch (key) {
                case "Account Id":
                    Assertions.verifyEquals(getDepositInfo("Account No"), Serenity.sessionVariableCalled("AccountId"),"'Account No' value");
                    break;
                case "Amount Credited":
                    Assertions.verifyEquals(getDepositInfo("Amount Credited"), expectedValue,"'Amount Credited' value");
                    break;
                case "Description":
                    Assertions.verifyEquals(getDepositInfo("Description"),expectedValue, "'Description' field");
                    break;
                case "Type of Transaction":
                    Assertions.verifyEquals(getDepositInfo("Type of Transaction"), expectedValue, "'Type of Transaction' field");
                    break;
                case "Current Balance":
                    Assertions.verifyEquals(getDepositInfo("Current Balance"), Integer.toString(getCurrentAmount()), "'Current Balance' field");
                    break;
            }
        }
    }

    public void verifyTabletHeadingDisplaysCorrectly(){
        Assertions.verifyEquals(getTableHeading(), successMessage + Serenity.sessionVariableCalled("AccountId"), "Table Heading");
    }

}
