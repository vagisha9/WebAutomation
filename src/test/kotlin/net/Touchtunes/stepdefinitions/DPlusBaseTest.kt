package net.Touchtunes.stepdefinitions

import net.Touchtunes.common.PropertiesKt
import net.Touchtunes.pageobjects.GooglePage
import net.Touchtunes.pageobjects.TouchtunesPressPage
import org.assertj.core.api.SoftAssertions

open class DPlusBaseTest protected constructor() {

	protected var driver = Hooks.driver!!
	protected var softAssertions = SoftAssertions()
	val url = PropertiesKt().getProperty("url1")!!
	val url2 = PropertiesKt().getProperty("url2")!!

	fun goToGooglePage():GooglePage {
		driver.get(url)
		println("Opening URL : " + url)
		return GooglePage(driver)
	}

	fun goToTouchtunesPressPage():TouchtunesPressPage {
		driver.get(url2)
		println("Opening URL : " + url2)
		return TouchtunesPressPage(driver)
	}
}