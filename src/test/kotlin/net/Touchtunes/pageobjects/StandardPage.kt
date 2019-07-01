package net.Touchtunes.pageobjects

import org.openqa.selenium.*
import org.openqa.selenium.support.ui.*
import java.util.concurrent.TimeUnit
import org.junit.Assert.assertTrue
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebElement
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter
import java.net.HttpURLConnection
import java.net.URL


open class StandardPage constructor(protected var driver: WebDriver) {

	private val wait: WebDriverWait = WebDriverWait(driver, 30)

	init {
		waitForPageLoad()
	}

	private fun waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
	}

	protected fun isElementPresent(locatorKey: By): Boolean {
		try {
			driver.findElement(locatorKey)
			return true
		} catch (e: NoSuchElementException) {
			return false
		}
	}

	protected fun isPageLoaded(locatorKey: By) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorKey))
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
		assertTrue(this.javaClass.name + " not loaded.", isElementPresent(locatorKey))
	}

	protected fun findElementBy(locatorKey: By): WebElement {
		return driver.findElement(locatorKey)
	}

	protected fun findElementsBy(locatorKey: By): List<WebElement> {
		return driver.findElements(locatorKey)
	}

	protected fun isAttribtuePresent(element: WebElement, attribute: String): Boolean {
		var result: Boolean? = false
		try {
			val value = element.getAttribute(attribute)
			if (value != null)
				result = true
		} catch (e: Exception) {}
		return result!!
	}

	fun logIntoFile(links: ArrayList<String>) {
		val br = BufferedWriter(FileWriter("src/test/resources/links.txt", true))
		for(k in 0..links.size-1) {
			br.append(links.get(k))
			br.newLine()
		}
		br.newLine()
		br.close()
	}

	fun checkBrokenLinks() {
		val fileRead = FileReader("src/test/resources/links.txt")
		val bfr = BufferedReader(fileRead);
		var x: String
		while (bfr.readLine() != null) {
			x = bfr.readLine()
			val status = getStatus(x)
			if(status!=null && status>=400){
				println("Broken Link:"+x)
			}
		}
	}

	fun getStatus(url: String): Int?{
		try {
			val u = URL(url)
			val http = u.openConnection() as HttpURLConnection
			http.connect()
			val responseCode = http.responseCode
			http.disconnect()
			return responseCode
		} catch (e: Exception) {
			return 0
		}
	}
}