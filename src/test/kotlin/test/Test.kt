package test

import driver.Driver
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import page.CheckoutPage
import page.HomePage
import page.ProductDetailPage
import page.SearchResultPage

class Test : Driver() {
    @Test
    fun `should search for dress on web site`() {
        val homePage = HomePage(driver)
        val searchResultPage = SearchResultPage(driver)
        homePage.loadHomePage()
        homePage.search("dress")
        val isDressDisplayed: Boolean = searchResultPage.isResultItemDisplayed("Printed Chiffon Dress")
        Assert.assertTrue(isDressDisplayed)
    }

    @Test
    fun `should check that shopping cart is empty`() {
        val homePage = HomePage(driver)
        homePage.loadHomePage()
        homePage.search("dress")
        val checkoutPage = CheckoutPage(driver)

        val isCartEmpty: Boolean = checkoutPage.isShoppingCartEmpty()
        Assert.assertTrue(isCartEmpty)
    }

    @Test
    fun `should check the name of dress`() {
        val homePage = HomePage(driver)
        homePage.loadHomePage()
        homePage.search("dress")
        val productName = "Printed Summer Dress"
        val checkoutPage = CheckoutPage(driver)
        val productPage = ProductDetailPage(driver)

        productPage.goToProductDetails(productName)

        val dressName = checkoutPage.getDressName();
        assertEquals(dressName, "Printed Summer Dress")
    }
}