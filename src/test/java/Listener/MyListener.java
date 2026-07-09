package Listener;

import Base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class MyListener implements ITestListener
{
    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;

    public Map<String, ExtentTest> devices = new HashMap<>();
    public Map<String, ExtentTest> classes = new HashMap<>();


    public void onStart(ITestContext context)
    {
        if(extentReports == null)
        {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_ss-mm-hh");
            String reportTime = dateTimeFormatter.format(localDateTime);

            extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReports/Reports/Report_"+reportTime);
            extentSparkReporter.config().setDocumentTitle("Extent Report");
            extentSparkReporter.config().setReportName("Git, GitHub, Jenkins, CI and CD");
            extentSparkReporter.config().setTheme(Theme.DARK);
        }

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        extentReports.setSystemInfo("Device",context.getCurrentXmlTest().getParameter("deviceName"));
        extentReports.setSystemInfo("App Package",context.getCurrentXmlTest().getParameter("appPackage"));
        extentReports.setSystemInfo("App Activity",context.getCurrentXmlTest().getParameter("appActivity"));

        String deviceName = context.getCurrentXmlTest().getParameter("deviceName");
        if(!devices.containsKey(deviceName))
        {
            ExtentTest deviceNode = extentReports.createTest(deviceName);
            devices.put(deviceName,deviceNode);
        }
    }


    public void onTestStart(ITestResult result)
    {
        String deviceName = result.getTestContext().getCurrentXmlTest().getParameter("deviceName");
        String className = result.getTestClass().getRealClass().getSimpleName();

        if(!classes.containsKey(className))
        {
            ExtentTest deviceNode = devices.get(deviceName);
            classes.put(className,deviceNode.createNode(className));
        }
    }

    public void onTestSuccess(ITestResult result)
    {
        String className = result.getTestClass().getRealClass().getSimpleName();
        ExtentTest classNode = classes.get(className);
        ExtentTest methodNode = classNode.createNode(result.getMethod().getDescription());
        methodNode.log(Status.PASS,result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result)
    {
         String className = result.getTestClass().getRealClass().getSimpleName();
         ExtentTest classNode = classes.get(className);
         ExtentTest methodNode = classNode.createNode(result.getMethod().getDescription());
         methodNode.log(Status.FAIL,result.getMethod().getMethodName()+" ---> Failed");
         methodNode.log(Status.FAIL,"Cause ---> "+result.getThrowable());

        BaseClass baseClass = new BaseClass();
        try
        {
            baseClass.getScreenshot(result.getMethod().getMethodName());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result)
    {
        String className = result.getTestClass().getRealClass().getSimpleName();
        ExtentTest classNode = classes.get(className);
        ExtentTest methodNode = classNode.createNode(result.getMethod().getDescription());
        methodNode.log(Status.SKIP,result.getMethod().getMethodName());
    }

    public void onFinish(ITestContext context)
    {
        extentReports.flush();
    }
}
