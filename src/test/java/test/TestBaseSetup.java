package test.java.test;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import test.java.test.pages.CreateAccountWindow;
import test.java.utils.Screenshots;

import java.awt.dnd.InvalidDnDOperationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class TestBaseSetup {
    private Logger logger = LogManager.getLogger(TestBaseSetup.class);
    public WebDriver driver;
    String start = "start";

    @BeforeClass
    public void initializeDriver(ITestContext iTestContext) {
        logger.info("CLIENT WAS LAUNCHED");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("E:\\Automation\\Client\\Ubisoft Game Launcher\\upc.exe");
        options.addArguments("remote-debugging-port=9222");
        options.addArguments("no-sandbox");
        driver = new ChromeDriver(options);
        iTestContext.setAttribute("driver", driver);
//        driver.manage().window().maximize();
    }

    public void switchTo(String title, int timeOutInMilliseconds) throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();

        while (sw.getTime() < timeOutInMilliseconds) {
            try {
                Set<String> handles = driver.getWindowHandles();
                for (String windowHandle : handles) {
                    Thread.sleep(100);
                    driver.switchTo().window(windowHandle);
                    if (driver.getTitle().equals(title)) {
                        logger.info("Window was switched to " + driver.getTitle());
                        return;
                    }
                }
            }
            catch (NoSuchWindowException e){}
            catch (InvalidDnDOperationException e){}
            catch (NullPointerException e){}
        }
    }


    @AfterMethod
    public void finalizeClient() {
        logger.info("Client was closed on window with title || " + driver.getTitle());
        driver.quit();
        WindowsProcessKiller.killProcess("upc");
    }
}
