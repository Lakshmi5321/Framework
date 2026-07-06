package ExcelDataProvider;

import Utils.ExcelUtil;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.util.List;

public class MailExcelData
{
    @DataProvider(name = "Send Mail")
    public Object[][] getSendMail_ExcelData() throws IOException
    {
        ExcelUtil excelUtil = new ExcelUtil();
        String path = System.getProperty("user.dir")+"/ExcelData/Excel Data.xlsx";
        String sheetName = "Mail";
        String testCase = "Send mail";

        List<List<String>> list = excelUtil.getExcelData(path,sheetName,testCase);
        Object[][] data = new Object[list.size()][];

        for(int i=0;i<list.size();i++)
        {
            data[i] = list.get(i).toArray();
        }
        return data;
    }

    @DataProvider(name = "Send Meet")
    public Object[][] getSendMeet_ExcelData() throws IOException
    {
        ExcelUtil excelUtil = new ExcelUtil();
        String path = System.getProperty("user.dir")+"/ExcelData/Excel Data.xlsx";
        String sheetName = "Mail";
        String testCase = "Send meet";

        List<List<String>> list = excelUtil.getExcelData(path,sheetName,testCase);
        Object[][] data = new Object[list.size()][];

        for(int i=0;i<list.size();i++)
        {
            data[i] = list.get(i).toArray();
        }
        return data;
    }
}
