package net.Touchtunes.pageobjects

import net.Touchtunes.common.PropertiesKt
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class GooglePage(driver: WebDriver) : StandardPage(driver) {

	private val searchForm = By.id("searchform")
	val url = PropertiesKt().getProperty("url1")!!

	@FindBy(css="input[title='Search']")
	private val searchBox: WebElement? = null

	@FindBy(css="input[value='Google Search']")
	private val searchButton: List<WebElement>? = null

	init {
		PageFactory.initElements(driver, this)
		isPageLoaded(searchForm)
	}

	fun isSearchBoxDisplayed(): Boolean {
		return searchBox!!.isDisplayed()
	}

	fun enterText(text: String){
		searchBox!!.sendKeys(text)
	}

	private fun getSearchButton(): WebElement? {
		for(i in 0..searchButton!!.size-1){
			if(searchButton[i].isDisplayed)
				return searchButton[i]
		}
		return null
	}

	fun clickSearchButton():GoogleSearchResultsPage{
		searchBox!!.sendKeys(Keys.ENTER)
		return GoogleSearchResultsPage(driver)
	}

}
