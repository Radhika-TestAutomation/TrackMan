package common;

public class Capabilities {

    // Keys for Desired Capabilities
    public static final String PLATFORM_NAME_KEY = "platformName";
    public static final String DEVICE_NAME_KEY = "appium:deviceName";
    public static final String PLATFORM_VERSION_KEY = "appium:platformVersion";
    public static final String APP_PACKAGE_KEY = "appium:appPackage";
    public static final String APP_ACTIVITY_KEY = "appium:appActivity";
    public static final String AUTOMATION_NAME_KEY = "appium:automationName";
    public static final String NEW_COMMAND_TIMEOUT_KEY = "appium:newCommandTimeout";

    // Default Values for Desired Capabilities
    public static final String PLATFORM_NAME_VALUE = "ANDROID";
    public static final String DEVICE_NAME_VALUE = "moto g23";  // Default device
    public static final String PLATFORM_VERSION_VALUE = "14";  // Default version
    public static final String APP_PACKAGE_VALUE = "dk.TrackMan.Range";
    public static final String APP_ACTIVITY_VALUE = "dk.TrackMan.SplashScreen";
    public static final String AUTOMATION_NAME_VALUE = "UiAutomator2";
    public static final String NEW_COMMAND_TIMEOUT_VALUE = "60";
}
