package Base;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass
{
    public AndroidDriver driver;

    @BeforeClass
    @Parameters({"deviceName","platformName","platformVersion","udid","appPackage","appActivity"})
    public void setUp(String deviceName,String platformName,String platformVersion,String udid,String appPackage,String appActivity) throws MalformedURLException
    {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(deviceName);
        options.setPlatformName(platformName);
        options.setPlatformVersion(platformVersion);
        options.setUdid(udid);
        options.setAppPackage(appPackage);
        options.setAppActivity(appActivity);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url,options);
    }

    @BeforeMethod()
    @Parameters({"appName","appPackage","appActivity"})
    public void reset(String appName,String appPackage,String appActivity) throws IOException, InterruptedException
    {
        if(appName.equals("Mail"))
        {
            driver.terminateApp("com.google.android.gm");
            Runtime.getRuntime().exec("adb shell pm clear com.google.android.gm").waitFor();
            driver.activateApp("com.google.android.gm");
        }
        if(appName.equals("Phone"))
        {
            ((AndroidDriver)driver).startActivity(new Activity(appPackage,appActivity));
        }
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
