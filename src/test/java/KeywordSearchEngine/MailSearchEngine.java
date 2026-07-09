package KeywordSearchEngine;

import Pages.MailPage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class MailSearchEngine
{
    public MailPage mailPage;

    public MailSearchEngine(AndroidDriver driver)
    {
        mailPage = new MailPage(driver);
    }

    public void execute_SendMail(String keyword,String to,String subject)
    {
        switch(keyword)
        {
            case "Click got it" : mailPage.clickGotIt();
            break;

            case "Click take me to gmail" : mailPage.clickTakeMeToGmail();
            break;

            case "Click allow" : mailPage.clickAllow();
            break;

            case "Click got it in home page" : mailPage.clickGotItInHomePage();
            break;

            case "Click compose" : mailPage.clickCompose();
            break;

            case "Enter to" : mailPage.enterToMail(to);
            break;

            case "Click suggestion" : mailPage.clickSuggestion();
            break;

            case "Enter subject" : mailPage.enterSubject(subject);
            break;

            case "Click send" : mailPage.clickSend();
            break;

            case "Check description" :
                Assert.assertTrue(mailPage.checkDescription("Sent"));
            break;
        }
    }

    public void execute_SendMeet(String keyword,String to,String subject)
    {
        switch(keyword)
        {
            case "Click got it" : mailPage.clickGotIt();
            break;

            case "Click take me to gmail" : mailPage.clickTakeMeToGmail();
            break;

            case "Click allow" : mailPage.clickAllow();
            break;

            case "Click got it in home page" : mailPage.clickGotItInHomePage();
            break;

            case "Click meet" : mailPage.clickMeet();
            break;

            case "Click cancel" : mailPage.clickCancel();
            break;

            case "Click new meeting" : mailPage.clickNewMeeting();
            break;

            case "Click get a meeting link to share" : mailPage.clickGetAMeetingLinkToShare();
            break;

            case "Click share invite" : mailPage.clickShareInvite();
            break;

            case "Click gmail" : mailPage.clickGmail();
            break;

            case "Enter to" : mailPage.enterToMail(to);
            break;

            case "Click suggestion" : mailPage.clickSuggestion();
            break;

            case "Enter subject" : mailPage.enterSubject(subject);
            break;

            case "Click send" : mailPage.clickSend();
            break;

            case "Click close" : mailPage.clickClose();
            break;
        }
    }

    public void execute_CheckThemeText(String keyword) throws InterruptedException
    {
        switch(keyword)
        {
            case "Click got it" : mailPage.clickGotIt();
            break;

            case "Click take me to gmail" : mailPage.clickTakeMeToGmail();
            break;

            case "Click allow" : mailPage.clickAllow();
            break;

            case "Click got it in home page" : mailPage.clickGotItInHomePage();
            break;

            case "Click meet" : mailPage.clickMeet();
            break;

            case "Click cancel" : mailPage.clickCancel();
            break;

            case "Click navigation menu" : mailPage.clickNavigationMenu();
            break;

            case "Swipe action" : mailPage.swipeAction();
            break;

            case "Click settings" : mailPage.clickSettings();
            break;

            case "Click general settings" : mailPage.clickGeneralSettings();
            break;

            case "Click theme" : mailPage.clickTheme();
            break;

            case "Click light" : mailPage.clickLight();
            break;

            case "Check theme text" : Assert.assertTrue(mailPage.checkThemeText("Light "));
            break;
        }
    }

    public void execute_CheckManageNotificationsText(String keyword) throws InterruptedException
    {
        switch(keyword)
        {
            case "Click got it" : mailPage.clickGotIt();
            break;

            case "Click take me to gmail" : mailPage.clickTakeMeToGmail();
            break;

            case "Click allow" : mailPage.clickAllow();
            break;

            case "Click got it in home page" : mailPage.clickGotItInHomePage();
            break;

            case "Click meet" : mailPage.clickMeet();
            break;

            case "Click cancel" : mailPage.clickCancel();
            break;

            case "Click navigation menu" : mailPage.clickNavigationMenu();
            break;

            case "Swipe action" : mailPage.swipeAction();
            break;

            case "Click settings" : mailPage.clickSettings();
            break;

            case "Click general settings" : mailPage.clickGeneralSettings();
            break;

            case "Click manage notifications" : mailPage.clickManageNotifications();
            break;

            case "Doubletap all gmail notifications toggle" : mailPage.doubleTapAction();
            break;

            case "Check all gmail notifications text" : Assert.assertTrue(mailPage.checkAllGmailNotificationsText("notifications"));
            break;
        }
    }
}
