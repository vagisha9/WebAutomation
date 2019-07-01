package net.Touchtunes.stepdefinitions

import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import net.Touchtunes.pageobjects.GooglePage

class GooglePageStepDefs : DPlusBaseTest() {

	private val googlePage = GooglePage(driver)

	@When("^User clicks google search$")
	fun user_clicks_google_search() {
		googlePage.clickSearchButton()
	}

	@Then("^User enters touchtunes in search box$")
	fun user_enters_touchtunes_in_searchbox() {
		googlePage.enterText("touchtunes")
	}
}