package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KayakSearchForm extends KayakLanding {
    @FindBy(xpath = "//section[@class='title-section']")
    private WebElement nothing;
    @FindBy(xpath = "//*[contains(@id, 'origin-airport-display')]")
    private WebElement originInput;
    @FindBy(xpath = "//input[@name='origin']")
    private WebElement originInputText;
    @FindBy(xpath = "(//*[contains(@aria-label, 'Flight destination input')])[1]")
    private WebElement destinationInputField;
    @FindBy(xpath = "(//*[contains(@id, 'destination-airport-text')]//input[contains(@id, 'destination')])[1]")
    private WebElement destinationInputText;
    @FindBy(xpath = "(//*[contains(@id, 'dateRangeInput-display-start')])")
    private WebElement departureDate;
    @FindBy(xpath = "(//*[contains(@id, 'dateRangeInput-display-end')])")
    private WebElement returnDate;
    @FindBy(xpath = "(//*[contains(@id, 'depart-input')])")
    private WebElement departureDateInput;
    @FindBy(xpath = "(//*[contains(@id, 'return-input')])")
    private WebElement returnDateInput;
    @FindBy(xpath = "//div[contains(@id, 'destination-airport-nearbyCheck')]")
    private WebElement destNearby;
    @FindBy(xpath = "//div[contains(@id, 'origin-airport-nearbyCheck')]")
    private WebElement originNearby;




    public void enterOrigin(String origin) {
        click(originInput);
        if (originInput.findElements(By.xpath("(//*[contains(@class, 'Button-No-Standard-Style js-remove-selection')])[3]")).size() > 0) {
            click(originInput.findElement(By.xpath("(//*[contains(@class, 'Button-No-Standard-Style js-remove-selection')])[3]")));
            sendKeys(originInputText, origin);
        } else {
            sendKeys(originInputText, origin);
            click(originNearby);
        }
        click(nothing);
    }



    public void enterDestination(String destination){
        click(destinationInputField);
        sendKeys(destinationInputText, destination);
        click(destNearby);
        click(nothing);
    }

    public void enterDepartureDate(String departure){
        click(departureDate);
        sendKeys(departureDateInput, departure);
    }

    public void enterReturnDate(String arrival){
        click(returnDate);
        sendKeys(returnDateInput, arrival);
        click(nothing);
    }


}