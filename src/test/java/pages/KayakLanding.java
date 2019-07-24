package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// Kayak Landing/Home page
public class KayakLanding extends BasePage{

    @FindBy(xpath = "//div[contains(@id, 'button-wrapper')]//following-sibling::button")
    private WebElement submitButton;

    public KayakLanding(){
        setUrl("https://www.kayak.com/");
    }

    public void submit(){
        click(submitButton);
    }
}
