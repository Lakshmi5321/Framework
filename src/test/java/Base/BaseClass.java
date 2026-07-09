package Base;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
            /*driver.terminateApp("com.google.android.dialer");
            Runtime.getRuntime().exec("adb shell pm clear com.google.android.dialer").waitFor();
            driver.activateApp("com.google.android.dialer");*/
        }
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    public static String subFolder = "";
    public void getScreenshot(String fileName) throws IOException
    {
        if(subFolder == null)
        {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_ss-mm-hh");
            subFolder = localDateTime.format(dateTimeFormatter);
        }

        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir")+"/ExtentReports/Screenshots/"+subFolder+"/"+fileName);
        FileUtils.copyFile(source,destination);
    }
}
