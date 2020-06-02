package com.example.endtoendTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Documents\\Webdrivers\\chromedriver_win32 (2)\\chromedriver.exe");
        driver.get("https://www.vocabulary.com/play/");
        System.out.println(driver.getTitle());


    }
}
