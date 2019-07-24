package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//Page for Kayak search form
public class KayakSearchForm extends KayakLanding {

    // set locators
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



    //Enter origin city
    public void enterOrigin(String origin) throws InterruptedException {
        click(originInput);
        Thread.sleep(250);
        if (originInput.findElements(By.xpath("(//*[contains(@class, 'Button-No-Standard-Style js-remove-selection')])[3]")).size() > 0) {
            click(originInput.findElement(By.xpath("(//*[contains(@class, 'Button-No-Standard-Style js-remove-selection')])[3]")));
            sendKeys(originInputText, origin);
        } else {
            sendKeys(originInputText, origin);
            click(originNearby);
            printLog("Nearby checkbox selected");
        }
        click(nothing);
    }


    // Enter destination city
    public void enterDestination(String destination) throws InterruptedException {
        click(destinationInputField);
        Thread.sleep(250);
        sendKeys(destinationInputText, destination);
        click(destNearby);
        printLog("Nearby checkbox selected");
        click(nothing);
    }

    //Enter departure date
    public void enterDepartureDate(String departure){
        click(departureDate);
        sendKeys(departureDateInput, departure);
        printLog("Departure date selected");
    }

    //enter Return date
    public void enterReturnDate(String returningDate){
        click(returnDate);
        sendKeys(returnDateInput, returningDate);
        printLog("Return date selected");
        click(nothing);
    }


}
