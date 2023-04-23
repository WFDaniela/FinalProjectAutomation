package ShareData;

import ExtenUtility.ExtentReport;
import InputFile.PropertiesUtility;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.TestResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hooks extends ShareData{

    public HashMap<String, String> TestData;
    private String TestName;
    private static ExtentReport extentReportUtility = new ExtentReport();
    public static List<Log> logContext = new ArrayList<>();
    public ExtentReport testReport;

    @BeforeMethod
    public void prepareEnvironment(){
        Setup();
        TestName = this.getClass().getSimpleName();
        PropertiesUtility propertiesUtility = new PropertiesUtility(TestName);
        TestData = propertiesUtility.getAllData();
        testReport = new ExtentReport(TestName);

    }

    @AfterMethod
    public void clearEnvironment(ITestResult result){
        if (result.getStatus()==ITestResult.FAILURE){
            testReport.attachReport("failed", result.getThrowable().getMessage(), getDriver(), TestName);
        }
        testReport.attachReport("info", "-- Finish "+TestName+" --");
        synchronized (extentReportUtility){
            ExtentTest currentTest = extentReportUtility.getExtent().createTest(""+TestName+"- report");
            logContext.addAll(testReport.getTestReport().getModel().getLogs());
            for (Log log :logContext ){
                currentTest.getModel().getLogs().add(log);
                if (log.getStatus().equals(Status.FAIL)){
                    currentTest.getModel().setStatus(Status.FAIL);
                }
            }
            extentReportUtility.getExtent().flush();
            logContext.clear();
        }
        Clear();
    }
}
