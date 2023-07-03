package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Utils.Utils.driver;

public class ResultsPage {
    public List<WebElement> resultCards(String cardClass) {
        return driver.findElements(By.className(cardClass));
    }
}