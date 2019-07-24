package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.KayakLanding;
import pages.KayakSearchForm;
import pages.SearchResult;


public class KayakSteps {



    String originCity = "";
    String destinationCity = "";

    KayakLanding kayakLanding = new KayakLanding();
    KayakSearchForm kayakSearchForm = new KayakSearchForm();
    SearchResult searchResult = new SearchResult();




    @Given("^I navigate to kayak$")
    public void iNavigateToKayak() {
            kayakLanding.open();
    }

    @Then("^I enter origin city as \"([^\"]*)\"$")
    public void iEnterOriginCity(String origin) {
        kayakSearchForm.enterOrigin(origin);
        this.originCity = origin;
    }

    @And("^I enter destination city as \"([^\"]*)\"$")
    public void iEnterDestinationCity(String destination) {
        kayakSearchForm.enterDestination(destination);
        this.destinationCity = destination;
    }

    @Then("^I enter departure date as \"([^\"]*)\"$")
    public void iEnterDepartureDate(String dep) {
        kayakSearchForm.enterDepartureDate(dep);
    }

    @And("^I enter return date as \"([^\"]*)\"$")
    public void iEnterReturnDate(String date) {
            kayakSearchForm.enterReturnDate(date);
    }

    @When("^I click submit$")
    public void iClickSubmit(){
        kayakLanding.submit();
    }

    @Then("^I close the ads$")
    public void iCloseTheAds() {
        searchResult.closeAds();
    }


    @Then("^I compare destinations$")
    public void iCompareDestinations() {
        searchResult.compareDestinations(originCity, destinationCity);
    }


}
