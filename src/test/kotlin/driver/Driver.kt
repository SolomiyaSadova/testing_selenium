package driver

import com.saucelabs.common.SauceOnDemandSessionIdProvider
import common.BrowserFactory
import org.junit.After
import org.junit.Before
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.RemoteWebDriver
import utils.WAIT
import java.util.concurrent.TimeUnit
import java.util.logging.Logger

open class Driver : SauceOnDemandSessionIdProvider {
    var log: Logger = Logger.getLogger(BrowserFactory::class.java.name)

    lateinit var driver: WebDriver

    @Before
    @Throws(Exception::class)
    fun setUp() {
        val browserName = System.getProperty("browserName")
        driver = BrowserFactory.getBrowser(browserName)
        val sessionId = (driver as RemoteWebDriver?)?.sessionId.toString()
        log.info("Started session with id = $sessionId")
        (driver as RemoteWebDriver).manage().timeouts().implicitlyWait(WAIT.toLong(), TimeUnit.SECONDS)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        driver.quit()
    }

    override fun getSessionId(): String {
        TODO("Not yet implemented")
    }
}