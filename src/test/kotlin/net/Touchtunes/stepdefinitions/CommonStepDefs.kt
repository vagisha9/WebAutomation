package net.Touchtunes.stepdefinitions

import cucumber.api.java.en.When

class CommonStepDefs: DPlusBaseTest() {

    @When("^User navigates to google$")
    fun user_navigates_to_google() {
        goToGooglePage()
    }

    @When("^User navigates to touchtunes press page$")
    fun user_navigates_to_touchtunes_press_page() {
        goToTouchtunesPressPage()
    }

}