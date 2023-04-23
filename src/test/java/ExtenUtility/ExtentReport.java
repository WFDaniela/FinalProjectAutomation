package ExtenUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ExtentReport {

    private ExtentSparkReporter HTMLReporter;
    private ExtentReports Extent;
    private ExtentTest testReport;

    private final String pathToProject = System.getProperty("user.dir")+ "/target/Report/";

    public ExtentReport(String reportName){
        createDirectory();
        deleteFiles();
        createReport(reportName);

    }
    public void createDirectory(){
        File Directory = new File(pathToProject);
        if (!Directory.exists()){
            Directory.mkdirs();
        }
    }
    public void deleteFiles(){
        File Directory = new File(pathToProject);
        File[] ListFiles = Directory.listFiles();
        for (Integer index = 0; index< ListFiles.length; index++){
             ListFiles[index].delete();

        }
    }
    public void createReport(String reportName){
        HTMLReporter = new ExtentSparkReporter("target/Report/"+reportName+".html");
        HTMLReporter.config().setTheme(Theme.DARK);
        Extent = new ExtentReports();
        Extent.attachReporter(HTMLReporter);
        testReport = Extent.createTest(""+reportName+"- report");
        attachReport("info", "--Start "+reportName+" test--");
    }
    public ExtentReport(){
        createDirectory();
        deleteFiles();
        createReport();

    }
    public void createReport(){
        HTMLReporter = new ExtentSparkReporter("target/Report/report.html");
        HTMLReporter.config().setTheme(Theme.DARK);
        Extent = new ExtentReports();
        Extent.attachReporter(HTMLReporter);

    }
    public void attachReport(String entryType, String message){
        if (entryType.equals("info")){
            testReport.log(Status.INFO, message);
        }
        if (entryType.equals("pass")){
            testReport.log(Status.PASS, message);
        }

    }
    public String getScreenshot(WebDriver driver, String reportName){
        String path = pathToProject+reportName+ "png";
        byte[] imageBytes;
        try {
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(path));
            imageBytes= IOUtils.toByteArray(Files.newInputStream(Paths.get(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Base64.getEncoder().encodeToString(imageBytes);
    }
    public void attachReport(String entryType, String message, WebDriver driver,String reportName ){
        if (entryType.equals("failed")){
            testReport.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(driver, reportName)).build());
        }


    }

    public ExtentReports getExtent() {
        return Extent;
    }

    public ExtentTest getTestReport() {
        return testReport;
    }
}
