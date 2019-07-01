package net.Touchtunes.stepdefinitions

import cucumber.api.Scenario
import cucumber.api.java.After
import cucumber.api.java.Before
import net.Touchtunes.common.DriverFactory
import net.Touchtunes.common.destroyDriver
import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebDriverException
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date

class Hooks {
	internal var folderPath = "src/test/resources/screenshots/"
	val driverFactory = DriverFactory()

	@Before
	@Throws(InterruptedException::class)
	fun startUp() {
		driver = driverFactory.driver
	}

	@After
	@Throws(IOException::class, InterruptedException::class)
	fun tearDown(scenario: Scenario) {
		if (scenario.isFailed) {
			try {
				val screenshot = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
				val dateFormat = SimpleDateFormat("dd-MM-yy HH-mm-ss")
				val date = Date()
				FileUtils.copyFile(screenshot, File(folderPath + dateFormat.format(date)))
				scenario.embed((driver as TakesScreenshot).getScreenshotAs(OutputType.BYTES), "image/png")
			} catch (wde: WebDriverException) {
				System.err.println(wde.message)
			} catch (cce: ClassCastException) {
				cce.printStackTrace()
			}
		}
		driverFactory.destroyDriver()
	}

	companion object {
		var driver: WebDriver? = null
	}
}