package test.java.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class For_testing extends TestBaseSetup{
    By byEmailField = By.xpath("//input[@maxlength='255']");
    By byPasswordField = By.xpath("//input[@maxlength='16']");
    By byLogInButton = By.xpath("(//div[@class='flex_1 text-right']/btn)[1]");
    By bySkipLink = By.xpath("(*//div[@class='flex_1 text-right'])[6]/preceding-sibling::*[1]");
    By byLatestNews = By.xpath("*//h2[contains(text(), 'Latest news')]");
    String start = "start";
    String uplay_News = "Uplay News";
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        options.setBinary("E:\\Automation\\Client\\Ubisoft Game Launcher\\upc.exe");
        options.addArguments("remote-debugging-port=9222");
        options.addArguments("no-sandbox");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10, 500);
    }




    @Test
    public void LatesNews() throws InterruptedException {
        System.out.println("**********************");
        try {
            switchTo(start, 10000);
            System.out.println("After switch title is: " + driver.getTitle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement emailField = driver.findElement(byEmailField);
        emailField.sendKeys("uplaykiev34@gmail.com");
        WebElement passwordField = driver.findElement(byPasswordField);
        passwordField.sendKeys("Account0000");
        WebElement logInButton = driver.findElement(byLogInButton);
        logInButton.click();

        try {
            switchTo(uplay_News, 10000);
            System.out.println("After switch to News title is: " + driver.getTitle());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement LatestNews = driver.findElement(byLatestNews);
        String LatestNewsStrExpected = "Latest News".toLowerCase();
        String LatestNewsStrActual = LatestNews.getText().toLowerCase();
        System.out.println("Lates News actual is: " + LatestNewsStrActual);
        Assert.assertEquals(LatestNewsStrActual, LatestNewsStrExpected);
    }
    @AfterMethod
    public void finalizeClient() {
        driver.quit();
    }
}

















