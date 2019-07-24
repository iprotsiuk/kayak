package support;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import definitions.KayakSteps;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber/report.json"},
        features = "src/test/resources/features",
        glue = {"definitions", "support"},
        tags = {"@kayak"} // select tags to run
)
public class TestRunner {


    @BeforeClass

    public static void setup() {
        TestContext.initialize();
        System.out.println("BeforeAll");

    }



    @AfterClass
    public static void teardown() {
        TestContext.close();
        System.out.println("AfterAll");
    }
}
