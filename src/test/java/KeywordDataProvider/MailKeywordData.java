package KeywordDataProvider;

import Utils.KeywordUtil;
import java.io.IOException;
import java.util.List;

public class MailKeywordData
{
    public List<String> getSendMail_KeywordData() throws IOException
    {
        KeywordUtil keywordUtil = new KeywordUtil();
        String path = System.getProperty("user.dir")+"/KeywordData/Keyword Data.xlsx";
        String sheetName = "Mail";
        String column = "Send Mail";

        return keywordUtil.getKeywordData(path,sheetName,column);
    }

    public List<String> getSendMeet_KeywordData() throws IOException
    {
       KeywordUtil keywordUtil = new KeywordUtil();
       String path = System.getProperty("user.dir")+"/KeywordData/Keyword Data.xlsx";
       String sheetName = "Mail";
       String column = "Send Meet Link";

       return keywordUtil.getKeywordData(path,sheetName,column);
    }

    public List<String> getCheckThemeText_KeywordData() throws IOException
    {
       KeywordUtil keywordUtil = new KeywordUtil();
       String path = System.getProperty("user.dir")+"/KeywordData/Keyword Data.xlsx";
       String sheetName = "Mail";
       String column = "Check Theme Text";

       return keywordUtil.getKeywordData(path,sheetName,column);
    }

    public List<String> getCheckManageNotificationsText_KeywordData() throws IOException
    {
        KeywordUtil keywordUtil = new KeywordUtil();
        String path = System.getProperty("user.dir")+"/KeywordData/Keyword Data.xlsx";
        String sheetName = "Mail";
        String column = "Check Manage Notifications Text";

        return keywordUtil.getKeywordData(path,sheetName,column);
    }

}
