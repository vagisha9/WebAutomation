package net.Touchtunes.pageobjects

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class TouchtunesPressPage(driver: WebDriver) : StandardPage(driver) {

    private val press = By.xpath("//h3[contains(text(),'Press')]")

    @FindBy(tagName= "a")
    private val links: List<WebElement>? = null

    init {
        PageFactory.initElements(driver, this)
        isPageLoaded(press)
    }

    fun getLinks(): ArrayList<String>{
        val selectedLinks = ArrayList<String>()
        for(i in 0..links!!.size-1){
            if(isAttribtuePresent(links[i],"href")) {
                val href = links[i].getAttribute("href")
                if(href.contains("touchtunes")){
                    selectedLinks.add(links[i].getAttribute("href"))
                }
            }
        }
        println("Links:"+selectedLinks)
        return selectedLinks
    }

    fun logLinks(){
        logIntoFile(getLinks())
    }
}