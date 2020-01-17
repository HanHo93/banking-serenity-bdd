package Steps;

import PageObject.SignInPage;
import net.thucydides.core.annotations.Step;


public class SignInSteps extends SignInPage {

    BaseTest base;
    SignInPage signIn;

    @Step("^User is on homepage$")
    public void openHomepage() {
        base.open();
    }

    @Step("^User is on dashboard page$")
    public void signIn(String username, String password) {
        signIn.inputUserName(username);
        signIn.inputPassword(password);
        signIn.clickLoginBtn();
    }
}
