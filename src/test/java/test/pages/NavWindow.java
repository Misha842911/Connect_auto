package test.java.test.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavWindow {
    private Logger logger = LogManager.getLogger(NavWindow.class);
    WebDriver driver;
    WebDriverWait wait;

    By userCardBy = By.xpath("*//div[@class='user-avatar']");
    By logOutBy = By.xpath("*//span[contains(text(), 'Log out')]/ancestor::li[@class='menu-item listItem']");

    public NavWindow(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }

    public NavWindow clickUserCard(){
        logger.info("Click 'UserCard'");
        WebElement userCard = driver.findElement(userCardBy);
        userCard.click();
        wait.until(ExpectedConditions.elementToBeClickable(logOutBy));
        return this;
    }

    public NavWindow clickLogOut(){
        logger.info("Click 'LogOut'");
        WebElement logOut = driver.findElement(logOutBy);
        logOut.click();
        return this;
    }

}
