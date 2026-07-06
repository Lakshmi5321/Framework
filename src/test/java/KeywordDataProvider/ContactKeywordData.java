package KeywordDataProvider;

import Utils.KeywordUtil;

import java.io.IOException;
import java.util.List;

public class ContactKeywordData
{
    public List<String> getAddContact_KeywordData() throws IOException
    {
        KeywordUtil keywordUtil = new KeywordUtil();
        String path = System.getProperty("user.dir")+"KeywordData/Keyword Data.xlsx";
        String sheetName = "Phone";
        String column = "Add Contact";

        return keywordUtil.getKeywordData(path,sheetName,column);
    }

    public List<String> getEditContact_KeywordData() throws IOException
    {
        KeywordUtil keywordUtil = new KeywordUtil();
        String path = System.getProperty("user.dir")+"/KeywordData/Keyword Data.xlsx";
        String sheetName = "Phone";
        String column = "Edit Contact";

        return keywordUtil.getKeywordData(path,sheetName,column);
    }

    public List<String> getDeleteContact_KeywordData() throws IOException
    {
        KeywordUtil keywordUtil = new KeywordUtil();
        String path = System.getProperty("user.dir")+"/KeywordData/Keyword Data.xlsx";
        String sheetName = "Phone";
        String column = "Delete Contact";

        return keywordUtil.getKeywordData(path,sheetName,column);
    }
}
