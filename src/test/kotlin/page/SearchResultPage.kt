package page

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
class SearchResultPage(private val driver: WebDriver) {
    fun isResultItemDisplayed(itemName: String?): Boolean {
        return driver.findElement(By.cssSelector(String.format("img[alt='%s']", itemName))).isDisplayed
    }
}