package test.java.test.LoginWindow;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.test.TestBaseSetup;
import test.java.test.pages.CreateAccountWindow;
import test.java.test.pages.LoginWindow;
import test.java.test.pages.NavWindow;
import test.java.test.pages.NewsWindow;
import test.java.utils.Screenshots;

public class CreateANewAccount extends TestBaseSetup {
    LoginWindow loginWindow;
    NewsWindow newsWindow;
    CreateAccountWindow createAccountWindow;
    NavWindow navWindow;

    String start = "start";
    String uplay_News = "Uplay News";
    String nav = "nav";

    @BeforeMethod
    public void pageInatialize(){
        loginWindow = new LoginWindow(driver);
        newsWindow = new NewsWindow(driver);
        navWindow = new NavWindow(driver);
        createAccountWindow = new CreateAccountWindow(driver);

    }

    @Test
    public void createANewAccountTest() throws InterruptedException {
        switchTo(start, 10000);
        loginWindow.clickCreateANewAccountLink();
        createAccountWindow
                .enterCredentialsToCreateAccount()
                .clickContinueBtn()
                .clickCreateAccountBtnCommunicationPreferences()
                .clickSkipLink();
        switchTo(uplay_News, 10000);
        newsWindow.verifySuccessfulLogin();
        switchTo(nav, 10000);
        navWindow
                .clickUserCard()
                .clickLogOut();
        switchTo(start, 10000);
    //        loginWindow.clickClose();
    }
}