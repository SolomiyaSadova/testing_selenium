package page

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.PageFactory
import java.util.*

class ProductDetailPage(private val driver: WebDriver) {
    fun goToProductDetails(productName: String) {
        Objects.requireNonNull(productName)
        val productImage = driver.findElement(By.cssSelector(String.format("img[title='%s']", productName)))
        val actions = Actions(driver)
        actions.moveToElement(productImage)
        actions.perform()
        productImage.click()
    }

    init {
        Objects.requireNonNull(driver)
        PageFactory.initElements(this.driver, this)
    }
}