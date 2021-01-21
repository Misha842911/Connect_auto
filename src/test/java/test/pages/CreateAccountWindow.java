package test.java.test.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateAccountWindow {
    private Logger logger = LogManager.getLogger(CreateAccountWindow.class);
    WebDriver driver;
    WebDriverWait wait;

    By userNameFieldToCreateAccBy = By.xpath("*//input[@id='js_username']");
    By emailFieldToCreateAccBy = By.xpath("*//input[@id='js_create_email']");
    By passwordFieldToCreateAccBy = By.xpath("(*//input[@id='js_password'])[2]");
    By dayToCreateAccBy = By.xpath("*//input[@placeholder='Day']");
    By monthToCreateAccBy = By.xpath("*//input[@placeholder='Month']");
    By yearToCreateAccBy = By.xpath("*//input[@placeholder='Year']");
    By createAccountCheckboxBy = By.xpath("(*//input[@type='checkbox'])[2]");
    By getCreateAccountContinueBtnBy = By.xpath("(*//a[@class='btn'])[2]");
    By createAccountBtnCommunicationPreferencesBy = By.xpath("*//div[contains(text(), 'Create account')]");
    By skipLinkBy = By.xpath("(*//span[contains(text(), 'Skip')])[1]/..");

    String password = "Account0000";
    String emailToCreate = "";
    String userNameToCreate = "";
    String dayToCreateAccVar = "1";
    String monthToCreateAccVar = "July";
    String yearToCreateAccVar = "1999";


    public CreateAccountWindow(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }

    public CreateAccountWindow enterCredentialsToCreateAccount() throws InterruptedException {
        logger.info("Enter credentials for new account");
        wait.until(ExpectedConditions.elementToBeClickable(emailFieldToCreateAccBy));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        emailToCreate = "test"+date+"@gmail.com";
        userNameToCreate = "U"+date;

        WebElement userNameFieldToCreateAcc = driver.findElement(userNameFieldToCreateAccBy);
        WebElement emailFieldToCreateAcc = driver.findElement(emailFieldToCreateAccBy);
        WebElement passwordToCreateAcc = driver.findElement(passwordFieldToCreateAccBy);
        WebElement dayToCreateAcc = driver.findElement(dayToCreateAccBy);
        WebElement monthToCreateAcc = driver.findElement(monthToCreateAccBy);
        WebElement yearToCreateAcc = driver.findElement(yearToCreateAccBy);
        WebElement createAccountCheckbox = driver.findElement(createAccountCheckboxBy);


        userNameFieldToCreateAcc.sendKeys(userNameToCreate);
//        Thread.sleep(1000);
        emailFieldToCreateAcc.sendKeys(emailToCreate);
//        Thread.sleep(1000);
        passwordToCreateAcc.sendKeys(password);
//        Thread.sleep(1000);
        dayToCreateAcc.sendKeys(dayToCreateAccVar);
//        Thread.sleep(1000);
        monthToCreateAcc.sendKeys(monthToCreateAccVar);
//        Thread.sleep(1000);
        yearToCreateAcc.sendKeys(yearToCreateAccVar);
//        Thread.sleep(1000);

        createAccountCheckbox.click();
        return this;
    }

    public CreateAccountWindow clickContinueBtn(){
        logger.info("Click 'Continue' button");
        wait.until(ExpectedConditions.elementToBeClickable(getCreateAccountContinueBtnBy));
        WebElement getCreateAccountContinueBtn = driver.findElement(getCreateAccountContinueBtnBy);
        getCreateAccountContinueBtn.click();
        return this;
    }

    public CreateAccountWindow clickCreateAccountBtnCommunicationPreferences(){
        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtnCommunicationPreferencesBy));
        logger.info("Click 'Create Account' button");
        WebElement createAccountBtnCommunicationPreferences = driver.findElement(createAccountBtnCommunicationPreferencesBy);
        createAccountBtnCommunicationPreferences.click();
        return this;
    }

    public CreateAccountWindow clickSkipLink(){
        wait.until(ExpectedConditions.elementToBeClickable(skipLinkBy));
        logger.info("Click 'Skip' link");
        WebElement clickSkipLinkBy = driver.findElement(skipLinkBy);
        clickSkipLinkBy.click();
        return this;
    }
}
