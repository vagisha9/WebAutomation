package net.Touchtunes.common

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.firefox.FirefoxOptions

class DriverFactory @Throws(InterruptedException::class) constructor() {

	var driver: WebDriver? = null
	private var driverPath = "src/test/resources/drivers/"
	private var osProperty = currentOS()
	private var chromeDriverPath: String? = null
	private var geckoDriverPath: String? = null
	private var browser: Any? = null

	init {
		if(System.getProperty("browser").isNullOrEmpty())
			browser = if(PropertiesKt()["browser"].toString().isBlank()) "chrome" else PropertiesKt()["browser"]
		else
			browser = System.getProperty("browser").toLowerCase()
		System.out.println("Executing tests on $browser")

		if(osProperty.contains("win64"))
			chromeDriverPath = driverPath + "chromedrivers/chromedriver_win32.exe"
		else if(osProperty.contains("linux32"))
			chromeDriverPath = driverPath + "chromedrivers/chromedriver_linux64.exe"
		else
			chromeDriverPath = driverPath + "chromedrivers/chromedriver_" + osProperty

		geckoDriverPath = driverPath + "geckodrivers/geckodriver_" + osProperty

		when (browser) {

			"chrome" -> {
				System.setProperty("webdriver.chrome.driver", chromeDriverPath)
				val options = ChromeOptions()
				options.addArguments("--start-maximized")
				options.addArguments("--disable-notifications")
				driver = ChromeDriver(options)
			}

			"firefox" -> {
				System.setProperty("webdriver.gecko.driver", geckoDriverPath)
				val firefoxProfile = FirefoxProfile()
				firefoxProfile.setPreference("dom.webnotifications.enabled", false)
				var options = FirefoxOptions().setProfile(firefoxProfile)
				driver = FirefoxDriver(options)
				driver?.manage()?.window()?.maximize()
			}

			else -> throw InterruptedException("Browser value is invalid.")
		}
	}
}

fun DriverFactory.destroyDriver() {
	driver?.quit()
	driver = null
}

fun DriverFactory.currentOS() : String {
	val osName = System.getProperty("os.name").toLowerCase()
	val osArchitecture = System.getProperty("os.arch")
	println("Current OS: ${osName}/${osArchitecture}")

	if (osName.contains("win")) {
		if(osArchitecture.contains("32"))
			return "win32.exe"
		else
			return "win64.exe"
	}

	else if(osName.contains("mac") || osName.contains("osx"))
		return "mac"

	else if(osName.contains("nix")|| osName.contains("nux") || osName.contains("aix")) {
		if(osArchitecture.contains("32"))
			return "linux32"
		else
			return "linux64"
	}

	else
		throw InterruptedException("Cannot get OS properties!!")
}