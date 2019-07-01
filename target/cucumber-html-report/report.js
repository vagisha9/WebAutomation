$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("WebTestScenarios.feature");
formatter.feature({
  "line": 1,
  "name": "Verify Google search scenario and links on touchtunes press website",
  "description": "",
  "id": "verify-google-search-scenario-and-links-on-touchtunes-press-website",
  "keyword": "Feature"
});
formatter.before({
  "duration": 15935283181,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Validate google search results after entering touchtunes as a keyword",
  "description": "",
  "id": "verify-google-search-scenario-and-links-on-touchtunes-press-website;validate-google-search-results-after-entering-touchtunes-as-a-keyword",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User navigates to google",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "User enters touchtunes in search box",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "User clicks google search",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User should see touchtunes results are displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonStepDefs.user_navigates_to_google()"
});
formatter.result({
  "duration": 3303713367,
  "status": "passed"
});
formatter.match({
  "location": "GooglePageStepDefs.user_enters_touchtunes_in_searchbox()"
});
formatter.result({
  "duration": 579420325,
  "status": "passed"
});
formatter.match({
  "location": "GooglePageStepDefs.user_clicks_google_search()"
});
formatter.result({
  "duration": 3379285726,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearchResultsStepDefs.user_should_see_touchtunes_results_are_displayed()"
});
formatter.result({
  "duration": 139923951,
  "status": "passed"
});
formatter.after({
  "duration": 1484668440,
  "status": "passed"
});
formatter.before({
  "duration": 3536214908,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Validate links on touchtunes press page",
  "description": "",
  "id": "verify-google-search-scenario-and-links-on-touchtunes-press-website;validate-links-on-touchtunes-press-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "User navigates to touchtunes press page",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "User gets and logs all links",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "User checks and prints broken links",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonStepDefs.user_navigates_to_touchtunes_press_page()"
});
formatter.result({
  "duration": 4412554358,
  "status": "passed"
});
formatter.match({
  "location": "TouchtunesPressStepDefs.user_gets_and_logs_all_links()"
});
formatter.result({
  "duration": 88326251613,
  "status": "passed"
});
formatter.match({
  "location": "TouchtunesPressStepDefs.user_checks_and_prints_broken_links()"
});
formatter.result({
  "duration": 52504100552,
  "status": "passed"
});
formatter.after({
  "duration": 1380783610,
  "status": "passed"
});
});