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

//        options.addArguments("--remote-allow-origins=");
//
//        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        String os = System.getProperty("os.name").toLowerCase();
        String driverPath;

        if (os.contains("win")) {
            // Для Windows
            driverPath = "C:/WebDriver/chromedriver.exe";
        } else {
            // Для Linux (или других ОС)
            driverPath = "/usr/local/bin/chromedriver"; // Путь в контейнере Docker или на Linux
        }

        // Устанавливаем путь к драйверу
        System.setProperty("webdriver.chrome.driver", driverPath);

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
