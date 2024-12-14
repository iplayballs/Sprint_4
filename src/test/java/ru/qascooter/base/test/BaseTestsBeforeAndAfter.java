package ru.qascooter.base.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTestsBeforeAndAfter {

    protected WebDriver driver;

    @Before
    public void initDriver() {
        connectionChromeDriver();

    }

    @After
    public void connectionCloseChromeDriver() {
        driver.quit();
    }

    public void connectionChromeDriver() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=");

        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public void connectionFirefoxDriver(String url) {
        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("--remote-allow-origins=");

        System.setProperty("webdriver.firefox.driver", "C:/WebDriver/chromedriver.exe");

        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();

        driver.get(url);
    }
}
