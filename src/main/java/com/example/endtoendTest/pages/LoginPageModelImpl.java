package com.example.endtoendTest.pages;

import com.example.endtoendTest.confogurations.CustomProperties;
import com.example.endtoendTest.enums.BrowserEnum;
import com.example.endtoendTest.factories.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class  LoginPageModelImpl implements LoginPageModel {
    private  WebDriver driver;
    private WebDriverFactory factory;
    private CustomProperties customProperties;
    private BrowserEnum e  = BrowserEnum.CHROME;

    public LoginPageModelImpl() throws IOException {
        factory = new WebDriverFactory();
        customProperties = new CustomProperties("LoginPageProperties.properties");
    }

    public void setBrowserName(BrowserEnum e) {
        this.e = e;
    }

    @Override
    public boolean geLoginPage() {
         driver = factory.generateWebDriverByBrowserType(e  , 10  , TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
         driver.get(customProperties.getCustomProperty("loginPageUrl"));
         String loginPageTitle = customProperties.getCustomProperty("loginPageTitle");

//        WebDriverWait webDriverWait = new WebDriverWait(driver , 3 );
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Sign In")))).click();
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Sign In")))).click();

        JavascriptExecutor js  = (JavascriptExecutor)driver;
        try {
            sleep(2000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        js.executeScript("arguments[0].click()" , driver.findElement(By.xpath("//a[@class='login']")));
         if(driver.getTitle().equals(loginPageTitle)) {
             return true;
         }
         else {
             return false;
         }
    }

    @Override
    public void fillInInputsAndClickSignIn() {
        driver.findElement(By.xpath("//div[@class='field username required']/div/input"))
                .sendKeys("skocharyan1993@gmail.com");
        driver.findElement(By.xpath("//div[@class='field password required']/div/input"))
                .sendKeys("myangeltest");
        driver.findElement(By.xpath("//button[text()='Sign in']"))
                .click();
    }
    public void fillInInputsAndClickSignIn(String username , String password) {
        driver.findElement(By.xpath("//div[@class='field username required']/div/input"))
                .sendKeys(username);
        driver.findElement(By.xpath("//div[@class='field password required']/div/input"))
                .sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Sign in']"))
                .click();
    }

    @Override
    public boolean validatePage() {
        String username =driver.findElement(By.xpath("//div[@class='nickname']")).getText();
        if(username.equals("skoch"))
            return  true;
        else
            return false;
    }
    public boolean validatePage(String s) {
        String username =driver.findElement(By.xpath("//div[@class='nickname']")).getText();
        if(username.equals(s))
            return  true;
        else
            return false;
    }

    @Override
    public void closePage() {
        driver.close();
    }
}
