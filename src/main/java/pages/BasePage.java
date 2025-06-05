package pages;

import exceptions.PageNotPresentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PageLoader;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver, By locator, String pageName) throws PageNotPresentException {
        this.driver = driver;

        boolean isPageNotPresent = !(new PageLoader(driver).isPagePresent(locator));
        if (isPageNotPresent) {
            throw new PageNotPresentException("Page '" + pageName + "' with root element '" + locator + "' not found");
        }
    }

}
