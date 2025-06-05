package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FoundProduct {

    private WebElement productElement;

    public FoundProduct(WebElement element) {
        productElement = element;
    }

    public void tapToElement() {
        productElement.click();
    }

    public String getProductName() {
        WebElement textElement;

        try {
            textElement = productElement.findElement(By.className("search-results-item-text"));
        } catch (Exception e) {
            return "";
        }

        return textElement.getText();
    }

}
