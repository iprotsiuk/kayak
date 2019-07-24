$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/kayak.feature");
formatter.feature({
  "name": "Kayak test",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@kayak"
    }
  ]
});
formatter.scenario({
  "name": "search flight on Kayak with data#1",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@kayak"
    },
    {
      "name": "@steps_for_kayak1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to kayak",
  "keyword": "Given "
});
formatter.match({
  "location": "KayakSteps.iNavigateToKayak()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter origin city as \"SFO\"",
  "keyword": "Then "
});
formatter.match({
  "location": "KayakSteps.iEnterOriginCity(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter destination city as \"LAX\"",
  "keyword": "And "
});
formatter.match({
  "location": "KayakSteps.iEnterDestinationCity(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter departure date as \"09/01/2019\"",
  "keyword": "Then "
});
formatter.match({
  "location": "KayakSteps.iEnterDepartureDate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter return date as \"09/14/2019\"",
  "keyword": "And "
});
formatter.match({
  "location": "KayakSteps.iEnterReturnDate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click submit",
  "keyword": "When "
});
formatter.match({
  "location": "KayakSteps.iClickSubmit()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I close the ads",
  "keyword": "Then "
});
