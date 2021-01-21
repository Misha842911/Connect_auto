package test.java.test.LoginWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.test.TestBaseSetup;
import test.java.test.pages.CreateAccountWindow;
import test.java.test.pages.LoginWindow;
import test.java.test.pages.NewsWindow;
import test.java.utils.PropertyLoader;
import test.java.utils.RetryAnalyzer;

public class Login extends TestBaseSetup {
    LoginWindow loginWindow;
    NewsWindow newsWindow;
    CreateAccountWindow createAccountWindow;

    @BeforeMethod
    public void pageInatialize(){
        loginWindow = new LoginWindow(driver);
        newsWindow = new NewsWindow(driver);
        createAccountWindow = new CreateAccountWindow(driver);
    }


//    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Test
    public void loginTest() throws InterruptedException {
        switchTo(PropertyLoader.loadProperty("start"), 10000);
        loginWindow
                .enterCredentials()
                .clickloginBtn();
        try {
            switchTo(PropertyLoader.loadProperty("uplay_News"), 10000);
            newsWindow.verifySuccessfulLogin();
        } catch (Exception e) {
            switchTo(PropertyLoader.loadProperty("start"), 10000);
            createAccountWindow.clickSkipLink();
            switchTo(PropertyLoader.loadProperty("uplay_News"), 10000);
            newsWindow.verifySuccessfulLogin();
        }
    }
}
