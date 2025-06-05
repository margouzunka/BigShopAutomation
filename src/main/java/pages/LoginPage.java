package pages;

import exceptions.PageNotPresentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) throws PageNotPresentException {
        super(driver, By.className("needs-validation"), "Login");
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(name = "email")
    private WebElement loginInputFormElement;

    public void setLogin(String login) {
        loginInputFormElement.sendKeys(login);
    }

    @FindBy(name = "password")
    private WebElement passwordInputFormElement;

    public void setPassword(String password) {
        passwordInputFormElement.sendKeys(password);
    }

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement submitButtonElement;

    public void clickToLogInButton() {
        submitButtonElement.click();
    }

}
