package pages;

import exceptions.PageNotPresentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) throws PageNotPresentException {
        super(driver, By.id("product-page"), "Product");
        PageFactory.initElements(super.driver, this);
    }

    @FindBy(xpath = "//*[contains(@class,'addToCartBlock')]/button[contains(@class,'add-to-card')]")
    private WebElement addToCartButtonElement;

    public ProductAddedToCartPage clickToAddToCartButton() throws PageNotPresentException {
        addToCartButtonElement.click();
        return new ProductAddedToCartPage(driver);
    }

}
