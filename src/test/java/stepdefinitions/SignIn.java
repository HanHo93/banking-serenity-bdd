package stepdefinitions;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import Steps.SignInSteps;

public class SignIn {
    @Steps
    SignInSteps signIn;

    @Given("^User logs in successfully with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userLogsInSuccessfullyWithUsernameAndPassword(String username, String password){
        signIn.openHomepage();
        signIn.signIn(username, password);
    }
}

