package steps;

import exceptions.PageNotPresentException;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pages.LoginPage;
import pages.MainPage;

public class LoginSteps extends CommonSteps {

    @Then("Login form is opened")
    public void logInFormIsOpened() throws PageNotPresentException {
        new LoginPage(driver);
    }

    @When("I type $email and $password to form")
    public void typeEmailAndPassword(String email, String password) throws PageNotPresentException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin(email);
        loginPage.setPassword(password);
    }

    @When("I click to login button")
    public void clickToLoginButton() throws PageNotPresentException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickToLogInButton();
    }

    @Then("I logged in my account")
    public void userLoggedInAccount() throws PageNotPresentException {
        new MainPage(driver);
    }

}
