package ExcelDataProvider;

import org.testng.annotations.DataProvider;
import Utils.ExcelUtil;

import java.io.IOException;
import java.util.List;

public class ContactExcelData
{
    @DataProvider(name = "Add Contact")
    public Object[][] getAddContact_ExcelData() throws IOException
    {
        ExcelUtil excelUtil = new ExcelUtil();
        String path = System.getProperty("user.dir")+"/ExcelData/Excel Data.xlsx";
        String sheetName = "Phone";
        String testCase = "Add contact";

        List<List<String>> list = excelUtil.getExcelData(path,sheetName,testCase);
        Object[][] data = new Object[list.size()][];

        for(int i=0;i<list.size();i++)
        {
            data[i] = list.get(i).toArray();
        }
        return data;
    }

    @DataProvider(name = "Edit Contact")
    public Object[][] getEditContact_ExcelData() throws IOException
    {
        ExcelUtil excelUtil = new ExcelUtil();
        String path = System.getProperty("user.dir")+"/ExcelData/Excel Data.xlsx";
        String sheetName = "Phone";
        String testCase = "Edit contact";

        List<List<String>> list = excelUtil.getExcelData(path,sheetName,testCase);
        Object[][] data = new Object[list.size()][];

        for(int i=0;i<list.size();i++)
        {
            data[i] = list.get(i).toArray();
        }
        return data;
    }

    @DataProvider(name = "Delete Contact")
    public Object[][] getDeleteContact_ExcelData() throws IOException
    {
        ExcelUtil excelUtil = new ExcelUtil();
        String path = System.getProperty("user.dir")+"/ExcelData/Excel Data.xlsx";
        String sheetName = "Phone";
        String testCase = "Delete contact";

        List<List<String>> list = excelUtil.getExcelData(path,sheetName,testCase);
        Object[][] data = new Object[list.size()][];

        for(int i=0;i<list.size();i++)
        {
            data[i] = list.get(i).toArray();
        }
        return data;
    }
}
