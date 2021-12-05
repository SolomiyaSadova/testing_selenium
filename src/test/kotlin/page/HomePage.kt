package page

import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import utils.MAIN_PAGE
import java.util.*

class HomePage(private val driver: WebDriver) {
    @FindBy(name = "search_query")
    lateinit var searchField: WebElement

    fun loadHomePage() {
        driver[MAIN_PAGE]
    }

    fun search(searchText: String) {
        Objects.requireNonNull(searchText)
        searchField.sendKeys(searchText)
        searchField.sendKeys(Keys.ENTER)
    }

    init {
        Objects.requireNonNull(driver)
        PageFactory.initElements(driver, this)
    }
}