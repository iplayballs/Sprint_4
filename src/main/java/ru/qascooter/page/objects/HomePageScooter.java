package ru.qascooter.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageScooter {
    private WebDriver driver;

    //локатор заголовка Вопросы о важном для ожидания
    private By xpathheaderQuestionsAboutMain = By.xpath(".//div[@class='Home_FourPart__1uthg']/div[@class='Home_SubHeader__zwi_E']");

    //кнопка Заказать в хедере
    private By xpathbuttonOrderInHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //кнопка заказать в блоке Самокать на пару дней
    private By xpathbuttonOrderInHomeRoadMap = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[contains(@class, 'Button_Button__ra12g')]");

    //метод конструктора создания драйвера
    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //метод ожидания хедера загрузки страницы
    public void waitForButtonOrderInHeader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(xpathbuttonOrderInHeader));
    }

    //метод ожидания загрузки кнопки заказать в блоке Самокат на пару дней

    //метод ожидания появления ответа в блоке Вопросы о важном
    public void waitForHeaderQuestionsAboutMain() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathheaderQuestionsAboutMain));
    }

    //метод клика по кнопке Заказать в хедере
    public void clickButtonOrderInHeader() {
        driver.findElement(xpathbuttonOrderInHeader).click();
    }

    //метод клика по кнопке Заказать в блоке Самокат на пару дней
    public void clickButtonOrderInHomeRoadMap() {
        driver.findElement(xpathbuttonOrderInHomeRoadMap).click();
    }

    //метод скролла до кнопки заказать в RoadMap
    public void scrollButtonOrderInHomeRoadMap() {
        WebElement element = driver.findElement(xpathbuttonOrderInHomeRoadMap);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
