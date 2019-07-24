package support;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import static support.TestContext.*;

public class Hooks {

//    @BeforeClass
//    public static void init(){
//        TestContext.initialize();
//        setDriver("chrome");
//    }



    @Before(order = 0)
    public void scenarioStart() {
//        TestContext.initialize();
        getDriver().manage().deleteAllCookies();
    }

    @After(order = 0)
    public void scenarioEnd(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE); // Now you can do whatever you need to do with it, for example copy somewhere
            FileUtils.copyFile(scrFile, new File(getResourcesPath("screenshots", addTimeStamp())+".png"));
        }
//        TestContext.close();
    }
}
