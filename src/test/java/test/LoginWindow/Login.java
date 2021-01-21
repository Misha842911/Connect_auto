package test.java.test.LoginWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.test.TestBaseSetup;
import test.java.test.pages.CreateAccountWindow;
import test.java.test.pages.LoginWindow;
import test.java.test.pages.NewsWindow;

public class Login extends TestBaseSetup {
    LoginWindow loginWindow;
    NewsWindow newsWindow;
    CreateAccountWindow createAccountWindow;

    String start = "start";
    String uplay_News = "Uplay News";

    @BeforeMethod
    public void pageInatialize(){
        loginWindow = new LoginWindow(driver);
        newsWindow = new NewsWindow(driver);
        createAccountWindow = new CreateAccountWindow(driver);
    }


    @Test
    public void loginTest() throws InterruptedException {
        switchTo(start, 10000);
        loginWindow
                .enterCredentials()
                .clickloginBtn();
        try {
            switchTo(uplay_News, 10000);
            newsWindow.verifySuccessfulLogin();
        } catch (Exception e) {
            switchTo(start, 10000);
            createAccountWindow.clickSkipLink();
            switchTo(uplay_News, 10000);
            newsWindow.verifySuccessfulLogin();
        }
    }
}
