package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static support.TestContext.getDriver;

//Page for the Kayak result page
public class SearchResult extends BasePage {
    @FindBy(xpath = "//div[contains(@id, 'dialog-content')]//a[contains(@id, 'close')]")
    private WebElement closeAds;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div[1]/span[1]")
    private WebElement sourceAddress;
    @FindBy(xpath = "/html/body/div[3]/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div[1]/span[3]")
    private WebElement destinationAddress;


    //close ads when landing on a result page
    public void closeAds() {
        click(closeAds);
    }

        public void compareDestinations(String origin , String destination){
            // Get the values from the text boxes
            String sourceCity = sourceAddress.getText();
            String destinationCity = destinationAddress.getText();

            // Comapare the values
            Assert.assertTrue("The Origin Cities do not match", origin.contains(sourceCity));
            Assert.assertTrue("The destination cities do not match", destination.contains(destinationCity));
        }

}
