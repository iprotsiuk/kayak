package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasePage;
import pages.KayakLanding;
import pages.KayakSearchForm;
import pages.SearchResult;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class KayakSteps extends BasePage {




    String originCity = "";
    String destinationCity = "";


    KayakLanding kayakLanding = new KayakLanding();
    KayakSearchForm kayakSearchForm = new KayakSearchForm();
    SearchResult searchResult = new SearchResult();




    @Given("^I navigate to kayak$")
    public void iNavigateToKayak() {
            kayakLanding.open();
            printLog("Browser Trigger successful; Page Loaded");
            }

    @Then("^I enter origin city as \"([^\"]*)\"$")
    public void iEnterOriginCity(String origin) {
        kayakSearchForm.enterOrigin(origin);
        printLog("Origin city selected");
        this.originCity = origin;
    }

    @And("^I enter destination city as \"([^\"]*)\"$")
    public void iEnterDestinationCity(String destination) {
        kayakSearchForm.enterDestination(destination);
        printLog("Destination city selected");
        this.destinationCity = destination;
    }

    @Then("^I enter departure date as \"([^\"]*)\"$")
    public void iEnterDepartureDate(String dep) {
        printLog("Departure date selected");
        kayakSearchForm.enterDepartureDate(dep);
    }

    @And("^I enter return date as \"([^\"]*)\"$")
    public void iEnterReturnDate(String date) {
            printLog("Return date selected");
            kayakSearchForm.enterReturnDate(date);
    }

    @When("^I click submit$")
    public void iClickSubmit(){
        kayakLanding.submit();
        printLog("Submit button clicked");
    }

    @Then("^I close the ads$")
    public void iCloseTheAds() {
        searchResult.closeAds();
        printLog("Ads are closed");
    }


    @Then("^I compare destinations$")
    public void iCompareDestinations() {
        printLog("Compairing destinations");
        searchResult.compareDestinations(originCity, destinationCity);
    }


}
