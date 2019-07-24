package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.yaml.snakeyaml.Yaml;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

import static support.TestContext.*;

//BasePage. Parent page with methods which can be used over all the pages
public class BasePage {

    private String url;

    public BasePage() {
        PageFactory.initElements(getDriver(), this);  //special constructor of the parent, needs for initialisation
    }

    public void setUrl(String url) {
        this.url = url;   //setter for url
    }


    public String getUrl() {
        return url;
    }

    public void open() {
        getDriver().get(url);
    }


    public static void clickWithJS(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }


    public void click(WebElement element) {  // create generic method "click" with JS click - applying method "click" for any element
        waitForClickable(element);
        try {
            element.click();   // try to normal click
        } catch (WebDriverException e) {
            clickWithJS(element); // if doesn't work try with JS click
        }

    }
    public void clearText(WebElement crossWebElement) {
        click(crossWebElement);
        Actions action = new Actions(getDriver());
        action.keyDown(Keys.DELETE);
    }

    public void scrollTo(WebElement element){
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForVisible(WebElement element) {  // create generic method "waitForVisible" to wait of visibility of element
        getWait().until(ExpectedConditions.visibilityOf(element));
    }


    public void sendKeys(WebElement element, String value) {   // create generic method "sendKeys" with wait of visibility of element
        waitForVisible(element);  // using here generic method waitForVisible created above
        element.sendKeys(value);
    }


    public void waitForClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }




    public static void hoverOverElement(WebElement element){
        Actions action = new Actions(getDriver());
        action.moveToElement(element).build().perform();
    }

    public static HashMap<String, String> getData(String fileName) throws Exception {
        String path = getResourcesPath("config", fileName) + ".yml";
        File sender = new File(path);
        InputStream stream = new FileInputStream(sender);

        Yaml yaml = new Yaml();
        return yaml.load(stream);
    }


    public void printLog(String message) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println("Time - " + dateFormat.format(cal.getTime())
                + " Log - " + message);
    }

}