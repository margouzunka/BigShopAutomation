package steps;

import exceptions.PageNotPresentException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class CommonSteps {

    public static String URL = "https://bigshop.md/";

    WebDriver driver;

    @BeforeScenario
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterScenario
    public void afterTest() {
        driver.quit();
    }

    @Given("Opened BigShop app")
    public void openBigShopApp() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Given("User logged in to $email:$password")
    public void userLoggedInToAccount(String email, String password) throws PageNotPresentException {
        LoginPage loginPage = new MainPage(driver).openLoginPage();
        loginPage.setLogin(email);
        loginPage.setPassword(password);
        loginPage.clickToLogInButton();

        new MainPage(driver);
    }

    @When("I click to profile icon")
    public void clickToProfileIcon() throws PageNotPresentException {
        new MainPage(driver).openLoginPage();
    }

}
