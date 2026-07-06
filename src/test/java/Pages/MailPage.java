package Pages;

import Base.BaseUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class MailPage extends BaseUtil
{
    public MailPage(AndroidDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    By gotIt = By.id("com.google.android.gm:id/welcome_tour_got_it");
    By takeMeToGmail = By.id("com.google.android.gm:id/action_done");
    By allow = By.id("com.android.permissioncontroller:id/permission_allow_button");
    By gotIt_HomePage = By.id("com.google.android.gm:id/next_button");
    By compose = By.id("com.google.android.gm:id/compose_button");
    By toMail = By.xpath("//android.view.ViewGroup[@index='0']/child::android.widget.EditText[@index='0']");
    By mailSuggestion = By.xpath("//android.widget.RelativeLayout[@index='0']/descendant::android.widget.ImageView[@index='0']");
    By subjectMail = By.xpath("//android.widget.LinearLayout[@index='0']/child::android.widget.EditText[@index='0']");
    By send = By.id("com.google.android.gm:id/send");
    By description = By.id("com.google.android.gm:id/description_text");

    By meet = By.xpath("//android.widget.FrameLayout[@index='1' and @content-desc='Meet']");
    By cancel = By.id("android:id/button2");
    By newMeeting = By.id("com.google.android.gm:id/new_meeting");
    By getAMeetingLinkToShare = By.id("com.google.android.gm:id/get_meeting_link_button");
    By shareInvite = By.id("com.google.android.gm:id/joining_info_share_button");
    By gmail = By.xpath("//android.widget.RelativeLayout[@index='0']/descendant::android.widget.TextView[@text='Gmail']");
    By close = By.id("com.google.android.gm:id/joining_info_close_button");

    By navigationMenu = By.xpath("//android.view.ViewGroup[@index='0']/child::android.widget.ImageButton[@index='0']");
    By settings = By.xpath("//android.widget.LinearLayout[@index='18']");
    By generalSettings = By.xpath("//android.widget.LinearLayout[@index='0']/child::android.widget.TextView[@index='0']");

    By theme = By.xpath("//android.widget.RelativeLayout[@index='0']/child::android.widget.TextView[@index='0' and @text='Theme']");
    By light = By.xpath("//android.widget.ListView[@index='0']/child::android.widget.CheckedTextView[@index='0']");
    By themeText = By.xpath("//android.widget.LinearLayout[@index='0']/descendant::android.widget.TextView[@index='1' and @text='Light']");

    By manageNotifications = By.xpath("//android.widget.LinearLayout[@index='2']");
    By allGmailNotificationsToggle = By.id("android:id/switch_widget");
    By allGmailNotificationsText = By.xpath("//android.widget.LinearLayout[@index='0']/descendant::android.widget.TextView[@text='All Gmail notifications']");

    public void clickGotIt()
    {
        waitUtil.waitForVisibility(gotIt).click();
    }

    public void clickTakeMeToGmail()
    {
        waitUtil.waitForVisibility(takeMeToGmail).click();
    }

    public void clickAllow()
    {
        waitUtil.checkForAlertPresent();
    }

    public void clickGotItInHomePage()
    {
        waitUtil.waitForVisibility(gotIt_HomePage).click();
    }

    public void clickCompose()
    {
        waitUtil.waitForClickable(compose).click();
    }

    public void enterToMail(String to)
    {
        waitUtil.waitForVisibility(toMail).clear();
        waitUtil.waitForVisibility(toMail).sendKeys(to);
    }

    public void clickSuggestion()
    {
        waitUtil.waitForVisibility(mailSuggestion).click();
    }

    public void enterSubject(String subject)
    {
        waitUtil.waitForVisibility(subjectMail).clear();
        waitUtil.waitForVisibility(subjectMail).sendKeys(subject);
    }

    public void clickSend()
    {
        waitUtil.waitForVisibility(send).click();
    }

    public boolean checkDescription(String value)
    {
        return waitUtil.checkForTextPresent(description,value);
    }

    public void clickMeet()
    {
        waitUtil.waitForVisibility(meet).click();
    }

    public void clickCancel()
    {
        waitUtil.waitForClickable(cancel).click();
    }

    public void clickNewMeeting()
    {
        waitUtil.waitForVisibility(newMeeting).click();
    }

    public void clickGetAMeetingLinkToShare()
    {
        waitUtil.waitForClickable(getAMeetingLinkToShare).click();
    }

    public void clickShareInvite()
    {
        waitUtil.waitForClickable(shareInvite).click();
    }

    public void clickGmail()
    {
        waitUtil.waitForClickable(gmail).click();
    }

    public void clickClose()
    {
        waitUtil.waitForClickable(close).click();
    }

    public void clickNavigationMenu() throws InterruptedException
    {
        waitUtil.waitForVisibility(navigationMenu).click();
        Thread.sleep(2000);
    }

    public void clickSettings()
    {
        waitUtil.waitForVisibility(settings).click();
    }

    public void clickGeneralSettings()
    {
        waitUtil.waitForVisibility(generalSettings).click();
    }

    public void clickTheme()
    {
        waitUtil.waitForClickable(theme).click();
    }

    public void clickLight()
    {
        waitUtil.waitForVisibility(light).click();
    }

    public boolean checkThemeText(String text)
    {
        return waitUtil.checkForTextPresent(themeText,text);
    }

    public void clickManageNotifications()
    {
        waitUtil.waitForClickable(manageNotifications).click();
    }

    public boolean checkAllGmailNotificationsText(String text)
    {
        return waitUtil.checkForTextPresent(allGmailNotificationsText,text);
    }

    public void doubleTapAction()
    {
        gestureUtil.doubleTap(waitUtil.waitForClickable(allGmailNotificationsToggle));
    }

    public void swipeAction()
    {
        gestureUtil.swipe(343,2170,302,686);
    }
}
