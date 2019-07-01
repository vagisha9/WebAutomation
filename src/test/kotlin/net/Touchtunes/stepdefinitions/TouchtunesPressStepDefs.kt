package net.Touchtunes.stepdefinitions

import cucumber.api.java.en.Then
import net.Touchtunes.pageobjects.TouchtunesPressPage

class TouchtunesPressStepDefs: DPlusBaseTest() {

    private val touchtunesPressPage = TouchtunesPressPage(driver)

    @Then("^User gets and logs all links$")
    fun user_gets_and_logs_all_links() {
        touchtunesPressPage.logLinks()
    }

    @Then("^User checks and prints broken links$")
    fun user_checks_and_prints_broken_links() {
        touchtunesPressPage.checkBrokenLinks()
    }
}