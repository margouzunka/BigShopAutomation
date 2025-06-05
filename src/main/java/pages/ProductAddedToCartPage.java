package pages;

import exceptions.PageNotPresentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductAddedToCartPage extends BasePage {

    public ProductAddedToCartPage(WebDriver driver) throws PageNotPresentException {
        super(driver, By.id("creditModalLabel"), "Product added to cart");
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@class='modal-body']//*[contains(@class,'product-title')]")
    private WebElement productTitleElement;

    public String getProductName() {
        return productTitleElement.getText();
    }

    @FindBy(xpath = "//*[contains(@class,'modal-body')]//a[contains(@class,'add-to-card')]")
    private WebElement confirmButton;

    public void clickToConfirmButton() {
        confirmButton.click();
    }

}
