package Base;

import Utils.GestureUtil;
import Utils.WaitUtil;
import io.appium.java_client.android.AndroidDriver;

public class BaseUtil
{
    public GestureUtil gestureUtil;
    public WaitUtil waitUtil;

    public BaseUtil(AndroidDriver driver)
    {
        gestureUtil = new GestureUtil(driver);
        waitUtil = new WaitUtil(driver);
    }
}
