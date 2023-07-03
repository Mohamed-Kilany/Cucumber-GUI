package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(name = "q")
    public WebElement searchInput;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}