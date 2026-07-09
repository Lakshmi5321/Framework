package Tests;

import Base.BaseClass;
import ExcelDataProvider.MailExcelData;
import KeywordDataProvider.MailKeywordData;
import KeywordSearchEngine.MailSearchEngine;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class MailTest extends BaseClass
{
   @Test(dataProvider = "Send Mail", dataProviderClass = MailExcelData.class,description = "SendMail")
   public void sendMailTest(String to,String subject) throws IOException
   {
       MailSearchEngine mailSearchEngine = new MailSearchEngine(driver);
       MailKeywordData mailKeywordData = new MailKeywordData();

       List<String> keyword = mailKeywordData.getSendMail_KeywordData();
       for(String key : keyword)
       {
           mailSearchEngine.execute_SendMail(key,to,subject);
       }
   }

   @Test(dataProvider = "Send Meet",dataProviderClass = MailExcelData.class,description = "SendMeet")
   public void sendMeetTest(String to,String subject) throws IOException
   {
       MailSearchEngine mailSearchEngine = new MailSearchEngine(driver);
       MailKeywordData mailKeywordData = new MailKeywordData();

       List<String> keyword = mailKeywordData.getSendMeet_KeywordData();
       for(String key : keyword)
       {
           mailSearchEngine.execute_SendMeet(key,to,subject);
       }
   }

   @Test(description = "CheckTheme")
   public void checkThemeTest() throws IOException, InterruptedException
   {
       MailSearchEngine mailSearchEngine = new MailSearchEngine(driver);
       MailKeywordData mailKeywordData = new MailKeywordData();

       List<String> keyword = mailKeywordData.getCheckThemeText_KeywordData();
       for(String key : keyword)
       {
           mailSearchEngine.execute_CheckThemeText(key);
       }
   }

    @Test(description = "CheckManageNotifications")
    public void checkManageNotificationsTest() throws IOException, InterruptedException
    {
        MailSearchEngine mailSearchEngine = new MailSearchEngine(driver);
        MailKeywordData mailKeywordData = new MailKeywordData();

        List<String> keyword = mailKeywordData.getCheckManageNotificationsText_KeywordData();
        for(String key : keyword)
        {
            mailSearchEngine.execute_CheckManageNotificationsText(key);
        }
    }
}
