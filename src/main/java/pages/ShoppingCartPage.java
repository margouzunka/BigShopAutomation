package pages;

import exceptions.PageNotPresentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) throws PageNotPresentException {
        super(driver, By.xpath("//h1[contains(text(),'Моя корзина') or contains(text(),'Coșul meu')]"),"Shopping Cart");
    }
}
