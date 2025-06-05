package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageLoader {

    private final WebDriver driver;

    private static final Duration DRIVER_WAIT_SECONDS = Duration.ofSeconds(10);

    public PageLoader(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPagePresent(By locator, Duration timeout) {
        try {
             WebElement element = getWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
             if (element != null) {
                 return true;
             }
        } catch (WebDriverException e) {
            System.out.println("Page is not present");
        }
        return false;
    }

    public boolean isPagePresent(By locator) {
        return isPagePresent(locator, DRIVER_WAIT_SECONDS);
    }

    private WebDriverWait getWait(Duration timeout) {
        return new WebDriverWait(driver, timeout);
    }

}
