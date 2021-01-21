//package test.java.test;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.Set;
//
//public class Switch {
//    WebDriver driver;
//
//    @BeforeMethod
//    public void initializeDriver() {
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("E:\\Automation\\Client\\Ubisoft Game Launcher\\upc.exe");
//        options.addArguments("remote-debugging-port=9222");
//        options.addArguments("no-sandbox");
//        driver = new ChromeDriver(options);
//    }
//
//    public void switchTo(String title) throws InterruptedException {
//        Set<String> handles = driver.getWindowHandles();
//        for (String windowHandle : handles) {
//            driver.switchTo().window(windowHandle);
//            Thread.sleep(25);
//            if (driver.getTitle().equals(title)) {
//                driver.switchTo().window(windowHandle);
//                Thread.sleep(25);
//                System.out.println("Loop" + driver.getTitle());
//            }
//        }
//    }
//}