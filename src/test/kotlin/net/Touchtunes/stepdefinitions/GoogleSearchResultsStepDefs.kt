package net.Touchtunes.stepdefinitions

import cucumber.api.java.en.Then
import net.Touchtunes.pageobjects.GoogleSearchResultsPage
import org.junit.Assert.assertTrue

class GoogleSearchResultsStepDefs:DPlusBaseTest() {

	private val googleSearchPage = GoogleSearchResultsPage(driver)

	@Then("^User should see touchtunes results are displayed$")
	fun user_should_see_touchtunes_results_are_displayed() {
		assertTrue("Search results related to touchtunes are not displayed",googleSearchPage.isTouchTunesDisplayed)
		assertTrue("Search results are not displayed correctly",googleSearchPage.getResultsSize()>0)
	}
}