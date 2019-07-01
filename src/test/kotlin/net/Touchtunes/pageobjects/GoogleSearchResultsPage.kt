package net.Touchtunes.pageobjects

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class GoogleSearchResultsPage(driver: WebDriver) : StandardPage(driver) {

    private val searchResults = By.cssSelector("html[itemtype='http://schema.org/SearchResultsPage']")

    @FindBy(xpath= "//h3[contains(text(),'TouchTunes | Home')]")
    private val touchtunesText: WebElement? = null

    @FindBy(css="a[href*='touchtunes']")
    private val allTouchtunesLinks: List<WebElement>? = null

    init {
        PageFactory.initElements(driver, this)
        isPageLoaded(searchResults)
    }

    val isTouchTunesDisplayed
        get() = touchtunesText!!.isDisplayed

    fun getResultsSize(): Int{
        return allTouchtunesLinks!!.size
    }
}