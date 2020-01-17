package PageObject;

import Utils.Assertions;
import Utils.ElementActions;
import cucumber.api.DataTable;
import org.openqa.selenium.By;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class CreateNewCustomerPage extends ElementActions{

    ElementActions action = new ElementActions();
    public String successMessage = "Customer Registered Successfully!!!";

    //OBJECT LOCATORS
    public static By createNewCusBtn = By.xpath("//a[contains(@href, 'addcustomer')]");
    public static By cusName = By.name("name");
    public static By genderRadioBtn( String gender){ return By.xpath("//input[@name='rad1' and @value='"+gender+"']"); }
    public static By birthDateTimePicker = By.id("dob");
    public static By addressTxtArea = By.name("addr");
    public static By cityTxt = By.name("city");
    public static By stateTxt = By.name("state");
    public static By pinTxt = By.name("pinno");
    public static By phoneNumberTxt = By.name("telephoneno");
    public static By emailTxt = By.name("emailid");
    public static By passwordTxt = By.name("password");
    public static By submitBtn = By.name("sub");
    public static By tableHeading = By.cssSelector("#customer tr td p.heading3");
    public static By columnValue( String value){ return By.xpath("//*[@id='customer']//tr/td[contains(text(),'"+value+"')]/following-sibling::td"); }
    public static By closeIframe = By.id("flow_close_btn_iframe");
    public static By closeBtn = By.id("closeBtn");


    //ACTIONS
    public void clickCreateNewCusBtn() {
        action.switchToIframeAndClick(closeIframe, closeBtn, "iframe", "'Close' button");
       action.click(createNewCusBtn, "'Create new Customer' button");
        }

    public void inputCusName(String name) {
        action.inputText(cusName, name, "'Customer name' text box");
    }

    public void selectGender(String gender) {
        action.click(genderRadioBtn(gender),"'Gender' radio button");
    }

    public void inputDateOfBirth(String date) {
        action.inputDate(birthDateTimePicker, date, "'Date of Birth' date time picker");
    }

    public void inputAddress(String address) {
        action.inputText(addressTxtArea, address, "'Address' Text Area");
    }

    public void inputState(String state) {
        action.inputText(stateTxt, state, "'State' text box ");
    }

    public void inputCity(String city) {
        action.inputText(cityTxt, city, "'City' text box ");
    }

    public void inputPIN(String pin) {
        action.inputText(pinTxt, pin, "'PIN' text box ");
    }

    public void inputPhoneNumber(String number) {
        action.inputText(phoneNumberTxt, number, "'Phone number' text box ");
    }

    public void inputEmail() {
        action.inputText(emailTxt, createNewEmail(), "'Email' text box ");
    }

    public void inputPassword(String pass) {
        action.inputText(passwordTxt, pass, "'Password' text box ");
    }

    public void clickSubmitBtn() {
        action.click(submitBtn, "'Submit' button");
    }

    public String createNewEmail(){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        return "Auto_"+ timeStamp +"@gmail.com";
    }

    public String getTableHeading(){
        return action.getText(tableHeading, "'Table Heading' text");
    }

    public String getCustomerInfo(String columnName){
        return action.getText(columnValue(columnName),"" );
    }

    public String getTheCustomerId(){
        return action.getText(columnValue("Customer ID"), "");
    }

    public void inputAllFieldsOfNewCustomerForm(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (String key : data.get(0).keySet()) {
            String value = data.get(0).get(key).trim();
            switch (key) {
                case "Customer Name":
                    inputCusName(value);
                    break;
                case "Gender":
                    selectGender(value);
                    break;
                case "Date of Birth":
                    inputDateOfBirth(value);
                    break;
                case "Address":
                    inputAddress(value);
                    break;
                case "City":
                    inputCity(value);
                    break;
                case "State":
                    inputState(value);
                    break;
                case "PIN":
                    inputPIN(value);
                    break;
                case "Mobile Number":
                    inputPhoneNumber(value);
                    inputEmail();
                    break;
                case "Password":
                    inputPassword(value);
                    break;
            }
        }
        clickSubmitBtn();
    }


    //ASSERTIONS
    public void verifyTabletHeadingDisplaysCorrectly(){
        Assertions.verifyEquals(getTableHeading(), successMessage, "Table Heading");
    }

    public void verifyNewCustomerInfoShowsCorrectly(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (String key : data.get(0).keySet()) {
            String expectedValue = data.get(0).get(key).trim();
            switch (key) {
                case "Customer Name":
                    Assertions.verifyEquals(getCustomerInfo("Customer Name"), expectedValue,"'Customer Name' value");
                    break;
                case "Gender":
                    String gen = null;
                    if(getCustomerInfo("Gender").equalsIgnoreCase("female"))
                        gen = "f";
                    else if(getCustomerInfo("Gender").equalsIgnoreCase("male"))
                        gen = "m";
                    Assertions.verifyEquals(gen, expectedValue,"'Gender' value");
                    break;
                case "Date of Birth":
                    String[] actual = getCustomerInfo("Birthdate").split("-");
                    String newFormat = actual[1]+"/"+actual[2]+"/"+actual[0];
                    Assertions.verifyEquals(newFormat, expectedValue,"'Birthdate' value");
                    break;
                case "Address":
                    Assertions.verifyEquals(getCustomerInfo("Address"), expectedValue,"'Address' value");
                    break;
                case "City":
                    Assertions.verifyEquals(getCustomerInfo("City"), expectedValue,"'City' value");
                    break;
                case "State":
                    Assertions.verifyEquals(getCustomerInfo("State"), expectedValue,"'State' value");
                    break;
                case "PIN":
                    Assertions.verifyEquals(getCustomerInfo("Pin"), expectedValue,"'Pin' value");
                    break;
                case "Mobile Number":
                    Assertions.verifyEquals(getCustomerInfo("Mobile No."), expectedValue,"'Mobile No.' value");
                    break;
            }
        }
    }

}
