package tests;


import common.Capabilities;
import common.Config;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseTest {

    protected AndroidDriver driver;
    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    @BeforeTest
    public void setUp() throws MalformedURLException {
        try {
            if (driver == null) {
                DesiredCapabilities caps = new DesiredCapabilities();

                // Set capabilities using key-value pairs
                caps.setCapability(Capabilities.PLATFORM_NAME_KEY, Capabilities.PLATFORM_NAME_VALUE);
                caps.setCapability(Capabilities.DEVICE_NAME_KEY, Capabilities.DEVICE_NAME_VALUE);
                caps.setCapability(Capabilities.PLATFORM_VERSION_KEY, Capabilities.PLATFORM_VERSION_VALUE);
                caps.setCapability(Capabilities.APP_PACKAGE_KEY, Capabilities.APP_PACKAGE_VALUE);
                caps.setCapability(Capabilities.APP_ACTIVITY_KEY, Capabilities.APP_ACTIVITY_VALUE);
                caps.setCapability(Capabilities.AUTOMATION_NAME_KEY, Capabilities.AUTOMATION_NAME_VALUE);
                caps.setCapability(Capabilities.NEW_COMMAND_TIMEOUT_KEY, Capabilities.NEW_COMMAND_TIMEOUT_VALUE);

                driver = new AndroidDriver(new URL(Config.APPIUM_SERVER_URL), caps);
            }
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            logger.severe("Error during AndroidDriver setup."+ e);
            throw e;
        }
    }

    public WebElement findElementById(String id) {
        try {
            return driver.findElement(By.id(id));
        } catch (Exception e) {
            logger.severe("Element not found by ID: "+ id);
            return null;
        }
    }

    public WebElement findElementByXpath(String xpath) {
        try {
            return driver.findElement(By.xpath(xpath));
        } catch (Exception e) {
            logger.severe("Element not found by XPath: "+ xpath);
            return null;
        }
    }

    @AfterTest
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            logger.severe("Error during driver teardown."+ e);
        }
    }
}
