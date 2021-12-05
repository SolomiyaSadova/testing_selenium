package common

import io.github.bonigarcia.wdm.ChromeDriverManager
import io.github.bonigarcia.wdm.DriverManagerType
import io.github.bonigarcia.wdm.FirefoxDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.util.logging.Logger

internal object BrowserFactory {
    var log: Logger = Logger.getLogger(BrowserFactory::class.java.name)

    fun getBrowsers(browserName: String?): WebDriver {
        val driver: WebDriver = if (browserName != null && browserName == "chrome") {
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
            ChromeDriver()
        } else {
            FirefoxDriverManager.getInstance(DriverManagerType.SELENIUM_SERVER_STANDALONE).setup();
            FirefoxDriver()
        }
        return driver
    }

    fun getBrowser(browserName: String?): WebDriver {
        log.info("Init driver")

        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        return ChromeDriver()
    }
}