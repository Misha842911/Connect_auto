package test.java.test.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWindow {
    private Logger logger = LogManager.getLogger(LoginWindow.class);

    WebDriver driver;
    WebDriverWait wait;
    By emailFieldBy = By.xpath("//input[@maxlength='255']");
    By passwordFieldBy = By.xpath("//input[@maxlength='16']");
    By logInButtonBy = By.xpath("(//div[@class='flex_1 text-right']/btn)[1]");
    By rememberMeCheckBoxBy = By.xpath(("*//input[@data-bind='returnKey: login, checked: myRememberMe']"));
    By createANewAccountLinkBy = By.xpath(("(*//a[@class='htooltip'])[1]"));
    By closeBy = By.xpath("(*//div[@class='close'])[1]");
    By windowRightBy = By.xpath("(*//div[@class='flex_2'])[2]");
    By minimizeBy = By.xpath("(*//div[@class='minimize'])[1]");
    String password = "Account0000";

    public LoginWindow(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }

    public LoginWindow enterCredentials(){
        logger.info("Credentials were entered");
        WebElement emailField = driver.findElement(emailFieldBy);
        emailField.sendKeys("uplaykiev34@gmail.com");
        WebElement passwordField = driver.findElement(passwordFieldBy);
        passwordField.sendKeys(password);
        return this;
    }

    public LoginWindow enterCredentialsRememberMe(){
        logger.info("Credentials were entered for 'RememberMe'");
        WebElement emailField = driver.findElement(emailFieldBy);
        emailField.sendKeys("uplaykiev36@gmail.com");
        WebElement passwordField = driver.findElement(passwordFieldBy);
        passwordField.sendKeys("Account0000");
        return this;
    }

    public LoginWindow clickloginBtn(){
        logger.info("Click 'Login' button");
        WebElement logInButton = driver.findElement(logInButtonBy);
        logInButton.click();
        return this;
    }

    public LoginWindow clickRememberMeCheckBox(){
        logger.info("Click 'RememberMe' checkBox");
        WebElement rememberMeCheckBox = driver.findElement(rememberMeCheckBoxBy);
        rememberMeCheckBox.click();
        return this;
    }
    public LoginWindow clickCreateANewAccountLink(){
        logger.info("Click 'CreateANewAccount' link");
        WebElement createANewAccountLink = driver.findElement(createANewAccountLinkBy);
        createANewAccountLink.click();
        return this;
    }

    public LoginWindow clickClose(){
        logger.info("Click 'Close'");
        WebElement Close = driver.findElement(closeBy);
        Close.click();
        return this;
    }

    public LoginWindow clickWindowRight(){
        logger.info("Click right field");
        WebElement WindowRight = driver.findElement(windowRightBy);
        WindowRight.click();
        return this;
    }

    public LoginWindow clickMinimize() {
        logger.info("Click 'Minimize'");
        WebElement minimize = driver.findElement(minimizeBy);
        minimize.click();
        return this;
    }

}
