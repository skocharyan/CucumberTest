package com.example.endtoendTest.enums;

public enum BrowserEnum {
    CHROME("webdriver.chrome.driver" , "C:\\Users\\Lenovo\\Documents\\Webdrivers\\chromedriver_83\\chromedriver.exe" ),
    OPERA("operaName" , "opraPath"),
    FIREFOX("FirefoxName" , "firefoxPath");
    public   final String driverName;
    public final  String driverPath;
    private BrowserEnum(String driverName , String driverPath){
        this.driverName = driverName;
        this.driverPath = driverPath;

    }
}
