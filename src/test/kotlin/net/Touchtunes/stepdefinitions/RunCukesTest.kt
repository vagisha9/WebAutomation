package net.Touchtunes.stepdefinitions

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(features = arrayOf("src/test/resources/features/"), plugin = arrayOf("pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"))

class RunCukesTest