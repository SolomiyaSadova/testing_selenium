package page

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.*

class CheckoutPage(private val driver: WebDriver) {
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div/div[3]/h1")
    lateinit var dressNameLabel: WebElement

    fun getDressName(): String = dressNameLabel.text

    fun isShoppingCartEmpty(): Boolean {
        WebDriverWait(driver, 1)
            .until { driver1: WebDriver ->
                driver1.findElement(
                    SHOPPING_CART_EMPTY_LABEL
                ).isDisplayed
            }
        return driver.findElement(SHOPPING_CART_EMPTY_LABEL).isDisplayed
    }

    companion object {
        private val SHOPPING_CART_EMPTY_LABEL = By.cssSelector(".ajax_cart_no_product")
    }

    init {
        Objects.requireNonNull(driver)
        PageFactory.initElements(this.driver, this)
    }
}
