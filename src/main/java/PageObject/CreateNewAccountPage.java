package PageObject;

import Utils.Assertions;
import Utils.ElementActions;
import cucumber.api.DataTable;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class CreateNewAccountPage extends ElementActions {
    ElementActions action = new ElementActions();
    public String successMessage = "Account Generated Successfully!!!";

    //OBJECT LOCATORS
    public static By createNewAccBtn = By.xpath("//a[contains(@href, 'addAccount')]");
    public static By logOutBtn = By.xpath("//a[contains(@href, 'Logout')]");
    public static By cusIdTxt = By.name("cusid");
    public static By depositTxt = By.name("inideposit");
    public static By accountTypeDropDown = By.name("selaccount");
    public static By submitBtn = By.name("button2");
    public static By columnValue( String value){ return By.xpath("//*[@id='account']//tr/td[contains(text(),'"+value+"')]/following-sibling::td"); }
    public static By tableHeading = By.cssSelector("#account tr td p.heading3");
    public static By closeIframe = By.id("flow_close_btn_iframe");
    public static By closeBtn = By.id("closeBtn");


    //ACTIONS
    public void clickCreateNewAccBtn() {
        action.switchToIframeAndClick(closeIframe, closeBtn, "iframe", "'Close' button");
        action.click(createNewAccBtn, "'Create new Customer' button");
    }

    public void clickSubmitBtn() {
        action.click(submitBtn, "'Submit' button");
    }

    public void inputCusId() {
        String userId = Serenity.sessionVariableCalled("CustomerId");
        action.inputText(cusIdTxt, userId, "'Customer Id' text box");
    }

    public void inputDeposit(String amount) {
        action.inputText(depositTxt, amount, "'Deposit' text box ");
    }

    public void selectAccountType(String value){
        action.selectFromDropDown(accountTypeDropDown, value, "'Deposit' dropdown");
    }

    public String getTableHeading(){
        return action.getText(tableHeading, "'Table Heading' text");
    }

    public String getAccountInfo(String columnName){
        return action.getText(columnValue(columnName),"" );
    }

    public void inputAllFieldsOfNewAccountForm(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (String key : data.get(0).keySet()) {
            String value = data.get(0).get(key).trim();
            switch (key) {
                case "Customer Id":
                    inputCusId();
                    break;
                case "Account Type":
                    selectAccountType(value);
                    break;
                case "Initial Deposit":
                    inputDeposit(value);
                    break;
            }
        }
        clickSubmitBtn();
    }


    //ASSERTIONS
    public void verifyTabletHeadingDisplaysCorrectly(){
        Assertions.verifyEquals(getTableHeading(), successMessage, "Table Heading");
    }

    public void verifyNewAccountInfoShowsCorrectly(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (String key : data.get(0).keySet()) {
            String expectedValue = data.get(0).get(key).trim();
            switch (key) {
                case "Account Type":
                    Assertions.verifyEquals(getAccountInfo("Account Type"), expectedValue,"'Account Type' value");
                    break;
                case "Initial Deposit":
                    Assertions.verifyEquals(getAccountInfo("Current Amount"), expectedValue,"'Current Amount' value");
                    break;
                case "Customer Id":
                    Assertions.verifyEquals(getAccountInfo("Customer ID"),Serenity.sessionVariableCalled("CustomerId"), "'Customer ID' field");
                    break;
                case "Customer Name":
                    Assertions.verifyEquals(getAccountInfo("Customer Name"),Serenity.sessionVariableCalled("CustomerName"), "'Customer Name' field");
                    break;
                case "Email":
                    Assertions.verifyEquals(getAccountInfo("Email"),Serenity.sessionVariableCalled("Email"), "'Email' field");
                    break;
                case "Date of Opening":
                    LocalDate date = LocalDate.now();
                    Assertions.verifyEquals(getAccountInfo("Date of Opening"), date.toString(), "'Date of Opening' field");
                    break;

            }
        }
    }
}
