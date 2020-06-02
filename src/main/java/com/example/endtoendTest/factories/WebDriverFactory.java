package com.example.endtoendTest.factories;

import com.example.endtoendTest.enums.BrowserEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    private WebDriver driver;

    public WebDriver generateWebDriverByBrowserType(BrowserEnum browserEnum) {
        WebDriver driver = generateDriver(browserEnum);
        return driver;
    }
    public WebDriver generateWebDriverByBrowserType(BrowserEnum browserEnum , int time , TimeUnit tUnit) {
       WebDriver driver = generateDriver(browserEnum);
        driver.manage().timeouts().implicitlyWait(time , tUnit);
        return driver;
    }

    public WebDriver generateDriver(BrowserEnum browserEnum ){
        switch (browserEnum) {
            case CHROME:
                System.setProperty(BrowserEnum.CHROME.driverName ,  BrowserEnum.CHROME.driverPath);
                driver = new ChromeDriver();
                break;
            case FIREFOX:
//                driver = new firefoxDriver();

            case OPERA:
                // driver = new OeraDriver();
                break;
            default: System.out.print("Browser driver do not found");
        }

        return driver;
    }

}

