package Pages;

import Base.BaseUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends BaseUtil
{
    public ContactPage(AndroidDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    By viewContacts = By.xpath("//android.view.View[@index='0']/child::android.view.View[@index='1']/child::android.widget.TextView[@text='View contacts']");
    By createContact = By.xpath("//android.widget.TextView[@text='Create contact']");
    By firstName = By.xpath("//android.view.View[@index='0']/child::android.view.View[@index='1']/descendant::android.widget.FrameLayout[@index='0']/child::android.widget.EditText[@index='0']");
    By lastName = By.xpath("//android.view.View[@index='0']/child::android.view.View[@index='2']/descendant::android.widget.FrameLayout[@index='0']/child::android.widget.EditText[@index='0']");
    By companyName = By.xpath("//android.view.View[@index='0']/child::android.view.View[@index='3']/child::android.widget.EditText[@index='0']");
    By phoneNumber = By.xpath("//android.view.View[@index='0']/child::android.view.View[@index='4']/child::android.widget.EditText[@index='0']");
    By save = By.xpath("//android.view.View[@index='0']/child::android.view.View[@index='3']/child::android.widget.TextView[@index='0']");
    By title = By.xpath("//android.widget.TextView[@resource-id='com.google.android.contacts:id/large_title']");

    By editIcon = By.id("com.google.android.dialer:id/open_search_bar_text_view");
    By searchBar = By.xpath("com.google.android.dialer:id/open_search_view_edit_text");
    By searchContact = By.id("com.google.android.dialer:id/open_search_view_edit_text");
    By searchResult = By.id("com.google.android.dialer:id/photo");
    By deleteBar = By.xpath("//android.widget.TextView[@text='Delete']");

    public void clickViewContacts()
    {
        waitUtil.waitForVisibility(viewContacts).click();
    }

    public void clickCreateContact()
    {
        waitUtil.waitForClickable(createContact).click();
    }

    public void sendFirstName(String fname)
    {
        waitUtil.waitForVisibility(firstName).sendKeys(fname);
    }

    public void sendLastName(String lname)
    {
        waitUtil.waitForVisibility(lastName).sendKeys(lname);
    }

    public void sendCompanyName(String cname)
    {
        waitUtil.waitForVisibility(companyName).clear();
        waitUtil.waitForVisibility(companyName).sendKeys(cname);
    }

    public void sendPhoneNumber(String phone)
    {
        waitUtil.waitForVisibility(phoneNumber).clear();
        waitUtil.waitForVisibility(phoneNumber).sendKeys(phone);
    }

    public void clickSave()
    {
        waitUtil.waitForClickable(save).click();
    }

    public boolean checkTitle(String value)
    {
        return waitUtil.checkForTextPresent(title,value);
    }

    public void clickEditIcon()
    {
        waitUtil.waitForClickable(editIcon).click();
    }

    public void clickSearchBar()
    {
        waitUtil.waitForVisibility(searchBar).click();
    }

    public void sendSearchContact(String search)
    {
        waitUtil.waitForVisibility(searchContact).sendKeys(search);
    }

    public void clickSearchResult()
    {
        waitUtil.waitForVisibility(searchResult).click();
    }

    public void clickDeleteBar()
    {
        waitUtil.waitForVisibility(deleteBar).click();
    }

    public void clickDeleteByAlert()
    {
        waitUtil.checkForAlertPresent();
    }

    public void performSwipeUp()
    {
        gestureUtil.swipe(488,2107,501,304);
    }
}

