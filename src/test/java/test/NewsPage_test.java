package test.java.test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.test.pages.LoginWindow;
import test.java.test.pages.NewsWindow;

public class NewsPage_test extends TestBaseSetup{
    LoginWindow loginPage;
    NewsWindow newsPage;
    String start = "start";
    String uplay_News = "Uplay News";

    @BeforeMethod
    public void pageInatialize(){
        loginPage = new LoginWindow(driver);
        newsPage = new NewsWindow(driver);
    }

    @Test
    public void LatesNews() throws InterruptedException {
        switchTo(start, 10000);
        loginPage
                .enterCredentials()
                .clickloginBtn();
        switchTo(uplay_News, 10000);
        newsPage
                .verifySuccessfulLogin();
    }
}
