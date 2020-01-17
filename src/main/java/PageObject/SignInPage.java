package PageObject;

import Utils.ElementActions;
import org.openqa.selenium.By;

 public class SignInPage extends  ElementActions{
     ElementActions action = new ElementActions();

     //OBJECT LOCATORS
     public static By usernameTxt = By.name("uid");
     public static By passwordTxt = By.name("password");
     public static By loginBtn = By.name("btnLogin");

     //ACTIONS
     public void inputUserName(String username) {
         action.inputText(usernameTxt, username, "'user name' text box");
     }

     public void inputPassword(String password) {
         action.inputText(passwordTxt, password, "'password' text box");
     }

     public void clickLoginBtn() {
         action.click(loginBtn, "'Login' button");
     }
}
