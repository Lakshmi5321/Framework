package Tests;

import Base.BaseClass;
import ExcelDataProvider.ContactExcelData;
import KeywordDataProvider.ContactKeywordData;
import KeywordSearchEngine.ContactSearchEngine;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ContactTest extends BaseClass
{
    @Test(dataProvider = "Add Contact", dataProviderClass = ContactExcelData.class)
    public void addContactTest(String firstName,String lastName,String companyName,String phoneNumber) throws IOException
    {
        ContactSearchEngine contactSearchEngine = new ContactSearchEngine(driver);
        ContactKeywordData contactKeywordData = new ContactKeywordData();

        List<String> keyword = contactKeywordData.getAddContact_KeywordData();
        for(String key : keyword)
        {
            contactSearchEngine.execute_AddContactKeyword(key,firstName,lastName,companyName,phoneNumber);
        }
    }

    @Test(dataProvider = "Edit Contact",dataProviderClass = ContactExcelData.class)
    public void editContactTest(String searchContact,String firstName,String lastName,String companyName,String phoneNumber) throws IOException
    {
        ContactSearchEngine contactSearchEngine = new ContactSearchEngine(driver);
        ContactKeywordData contactKeywordData = new ContactKeywordData();

        List<String> keyword = contactKeywordData.getEditContact_KeywordData();
        for(String key : keyword)
        {
            contactSearchEngine.execute_EditContactKeyword(key,searchContact,firstName,lastName,companyName,phoneNumber);
        }
    }

    @Test(dataProvider = "Delete Contact",dataProviderClass = ContactExcelData.class)
    public void deleteContactTest(String searchContact) throws IOException
    {
        ContactSearchEngine contactSearchEngine = new ContactSearchEngine(driver);
        ContactKeywordData contactKeywordData = new ContactKeywordData();

        List<String> keyword = contactKeywordData.getDeleteContact_KeywordData();
        for(String key : keyword)
        {
            contactSearchEngine.execute_DeleteContactKeyword(key,searchContact);
        }
    }
}
