package KeywordSearchEngine;

import Pages.ContactPage;
import io.appium.java_client.android.AndroidDriver;

public class ContactSearchEngine
{
    public ContactPage contactPage;

    public ContactSearchEngine(AndroidDriver driver)
    {
        contactPage = new ContactPage(driver);
    }

    public void execute_AddContactKeyword(String keyword,String firstName,String lastName,String companyName,String phoneNumber)
    {
        switch (keyword)
        {
            case "View contacts" : contactPage.clickViewContacts();
            break;

            case "Create contact" : contactPage.clickCreateContact();
            break;

            case "First name" : contactPage.sendFirstName(firstName);
            break;

            case "Last name" : contactPage.sendLastName(lastName);
            break;

            case "Company name" : contactPage.sendCompanyName(companyName);
            break;

            case "Save" : contactPage.clickSave();
            break;

            case "Title" : String str = firstName+" "+lastName;
                           contactPage.checkTitle(str);
                           break;
        }
    }

    public void execute_EditContactKeyword(String keyword,String searchContact,String firstName,String lastName,String companyName,String phoneNumber)
    {
        switch(keyword)
        {
            case "Search bar" : contactPage.clickSearchBar();
            break;

            case "Search contact" : contactPage.sendSearchContact(searchContact);
            break;

            case "Search result" : contactPage.clickSearchResult();
            break;

            case "EditIcon" : contactPage.clickEditIcon();
            break;

            case "First name" : contactPage.sendFirstName(firstName);
                break;

            case "Last name" : contactPage.sendLastName(lastName);
                break;

            case "Company name" : contactPage.sendCompanyName(companyName);
                break;

            case "Save" : contactPage.clickSave();
                break;

            case "Title" : String str = firstName+" "+lastName;
                contactPage.checkTitle(str);
                break;
        }
    }

    public void execute_DeleteContactKeyword(String keyword,String searchContact)
    {
        switch(keyword)
        {
            case "Search bar" : contactPage.clickSearchBar();
            break;

            case "Search contact" : contactPage.sendSearchContact(searchContact);
            break;

            case "Search result" : contactPage.clickSearchResult();
            break;

            case "Swipeup Action" : contactPage.performSwipeUp();
            break;

            case "Delete bar" : contactPage.clickDeleteBar();
            break;

            case "Delete by alert" : contactPage.clickDeleteByAlert();
            break;
        }
    }
}
