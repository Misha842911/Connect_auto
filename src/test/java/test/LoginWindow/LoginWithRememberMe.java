package test.java.test.LoginWindow;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.test.TestBaseSetup;
import test.java.test.pages.LoginWindow;
import test.java.test.pages.NavWindow;
import test.java.test.pages.NewsWindow;

public class LoginWithRememberMe extends TestBaseSetup {
    LoginWindow loginPage;
    NewsWindow newsPage;
    NavWindow navWindow;
    String uplay_News = "Uplay News";
    String start = "start";
    String nav = "nav";

    @BeforeMethod
    public void pageInatialize(){
        loginPage = new LoginWindow(driver);
        newsPage = new NewsWindow(driver);
        navWindow = new NavWindow(driver);
    }

    @Test
    public void LoginWithRememberMe() throws InterruptedException {
        switchTo(start, 10000);
        loginPage
                .enterCredentialsRememberMe()
                .clickRememberMeCheckBox()
                .clickloginBtn();
        switchTo(uplay_News, 10000);
        newsPage.verifySuccessfulLogin();
//        driver.quit();
//        driver = null;
//        initializeDriver();
//        switchTo(uplay_News, 10000);
//        newsPage.verifySuccessfulLogin();
        switchTo(nav, 10000);
        navWindow.clickUserCard()
                .clickLogOut();
//        switchTo(start, 10000);
    }
}
