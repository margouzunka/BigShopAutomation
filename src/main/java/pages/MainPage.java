package pages;

import components.FoundProduct;
import exceptions.PageNotPresentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@class='navbar-tool-icon ci-user']")
    private WebElement profileIconElement;

    public MainPage(WebDriver driver) throws PageNotPresentException {
        super(driver, By.className("swiper-pagination"), "Main");
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage openLoginPage() throws PageNotPresentException {
        profileIconElement.click();
        return new LoginPage(driver);
    }

    @FindBy(
            xpath = "//*[" +
                    "contains(@class,'input-group') and not(contains(@class,'null'))" +
                    "]/*[" +
                    "contains(@class,'form-control') and contains(@class,'border-red')" +
                    "]"
    )
    private WebElement searchInputForm;

    public void searchProduct(String product) {
        searchInputForm.sendKeys(product);
        waitUntilProductsAppeared(product);
    }

    private void waitUntilProductsAppeared(String product) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedCondition<Boolean>) input -> {
                    List<FoundProduct> foundProducts = getFoundProducts();
                    for (FoundProduct foundProduct: foundProducts) {
                        if (foundProduct.getProductName().toLowerCase().contains(product.toLowerCase())) {
                            return true;
                        }
                    }
                    return false;
                });
    }

    public List<FoundProduct> getFoundProducts() {
        By locator = By.xpath("//*[@class='search-results-item']");
        List<WebElement> foundElements;

        try {
            foundElements = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            return new ArrayList<>();
        }

        return foundElements.stream().map(FoundProduct::new).toList();
    }

}
