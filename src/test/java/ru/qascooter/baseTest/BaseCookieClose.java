package ru.qascooter.baseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseCookieClose {

    private static By xpathCookieButtonClose = By.xpath(".//button[@class='App_CookieButton__3cvqF']");


    public static void clickCookieButtonClose(WebDriver driver) {
        driver.findElement(xpathCookieButtonClose).click();
    }

    public static void waitForInvisibilityCookieButtonClose(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathCookieButtonClose));
    }
}
