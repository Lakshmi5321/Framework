package Utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

public class GestureUtil
{
    public AndroidDriver driver;

    public GestureUtil(AndroidDriver driver)
    {
        this.driver = driver;
    }

    public int centerX_Of_Element(WebElement element)
    {
        int width = element.getRect().getWidth();
        int x = element.getRect().getX();
        return (int)(x+width/2);
    }

    public int centerY_Of_Element(WebElement element)
    {
        int height = element.getRect().getHeight();
        int y = element.getRect().getY();
        return (int)(y+height/2);
    }

    public void doubleTap(WebElement element)
    {
        int centerX = centerX_Of_Element(element);
        int centerY = centerY_Of_Element(element);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence seq = new Sequence(finger,0);

        seq.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),centerX,centerY));
        seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        seq.addAction(new Pause(finger,Duration.ofMillis(500)));

        seq.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),centerX,centerY));
        seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singleton(seq));
    }

    public void swipe(int x1,int y1,int x2,int y2)
    {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence seq = new Sequence(finger,0);

        seq.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),x1,y1));
        seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(new Pause(finger,Duration.ofMillis(300)));
        seq.addAction(finger.createPointerMove(Duration.ofMillis(1500),PointerInput.Origin.viewport(),x2,y2));
        seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(seq));
    }
}
