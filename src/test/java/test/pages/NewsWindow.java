package test.java.test.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NewsWindow {
    private Logger logger = LogManager.getLogger(NewsWindow.class);
    WebDriver driver;
    WebDriverWait wait;
    By byLatestNews = By.xpath("*//h2[contains(text(), 'Latest news')]");
    By userCardBy = By.xpath("*//div[@class='user_info_container']");

    public NewsWindow(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }

    public NewsWindow verifySuccessfulLogin (){
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLatestNews));
        logger.info("Client was opened successful");
        WebElement LatestNews = driver.findElement(byLatestNews);
        String LatestNewsStrExpected = "Latest News".toLowerCase();
        String LatestNewsStrActual = LatestNews.getText().toLowerCase();

        Assert.assertEquals(LatestNewsStrActual, LatestNewsStrExpected);
        return this;
    }
}
