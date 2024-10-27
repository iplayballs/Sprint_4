package ru.qascooter.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class OrderPageScooter {
    private WebDriver driver;

    //локатор заголовка Для кого самокат для ожидания
    private By xpathOrderHeader = By.xpath(".//div[@class='Order_Header__BZXOb' and text()='Для кого самокат']");
    //локатор поля Имя
    private By xpathInputName = By.xpath(".//input[@placeholder='* Имя']");
    //локатор поля Фамилия
    private By xpathInputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    //локатор поля Адрес
    private By xpathInputAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор клика по списку Станций метро
    private By xpathSelectSearhSubway = By.xpath(".//div[@class='select-search__value']/parent::*");
    //локатор input для отладки
    private By xpathSelectSearhSubwayInput = By.xpath(".//input[@placeholder='* Станция метро']");
    //локатор появления списка станций метро для ожидания
    private By xpathSelectSearhSubwayList = By.xpath(".//ul[@class='select-search__options']");
    //локатор станции метро Бульвар Рокоссовского
    private By xpathSelectSearhSubwayButton = By.xpath(".//li[@data-index='" + randomSubway + "']/button");
    //локатор поля Телефон
    private By xpathInputPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор кнопки Далее
    private By xpathButtonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //локатор заголовка Про аренду для ожидания
    private By xpathHeaderAboutRent = By.xpath(".//div[@class='Order_Header__BZXOb' and text()='Про аренду']");
    //локатор поля Когда привезти самокат
    private By xpathInputWhenToBringScooter = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //локатор модалки календаря для ожидания
    private By xpathModalCalendar = By.xpath(".//div[@class='react-datepicker__month']");
    //локатор даты сегодня в календаре
    private By xpathModalCalendarDateSelected = By.xpath(".//div[contains(@class, 'react-datepicker__day') and contains(@tabindex, '0')]");
    //локатор поля Срок аренды для клика и вызова списка
    private By xpathDropDownRent = By.xpath(".//div[@class='Dropdown-control']");
    //локатор списка срока аренды для ожидания появления списка
    private By xpathDropDownTermRent = By.xpath(".//div[@class='Dropdown-menu']");
    //локатор option срока аренды для клика по сутки
    private By xpathDropDownTermRentFullDay = By.xpath(".//div[@class='Dropdown-menu']/div[" + randomTermRent + "]");
    //локатор ожидания заполнения поля Срок
    private By xpathDropDownTermRentFilled = By.xpath(".//div[@class='Dropdown-placeholder is-selected']");
    //локатор для ввода значения даты в поле Срок
    private By xpathInputTermRent = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //локатор чек-бокса Черный жемчуг
    private By xpathCheckBoxBlack = By.xpath(".//input[@id='black']");
    //локатор чек-бокса Серая безысходность
    private By xpathCheckBoxGrey = By.xpath(".//input[@id='grey']");
    //локатор поля Комментарий для курьера
    private By xpathInputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //локатор кнопки Заказать во второй части формы заказа
    private By xpathButtonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");

    //локатор формы Хотите оформить заказ для ожидания
    private By xpathHeaderModalWantToOrderFinished = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Хотите оформить заказ?']");
    //локатор кнопки Да
    private By xpathButtonModalWantToOrderFinishedYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //локатор кнопки Нет
    private By xpathButtonModalWantToOrderFinishedNo = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Нет']");
    //локатор формы Заказ оформлен
    private By xpathHeaderModalOrderFinished = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");


    //конструктор класса
    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //геттер для assertEquals перехода на Для кого самокат в Order
    public String getTextOfOrderHeader() {
        String text = driver.findElement(xpathOrderHeader).getText();
        return text;
    }

    //геттер для assertEquals перехода на вторую часть формы
    public String getTextOfXpathAboutRentHeader() {
        String text = driver.findElement(xpathHeaderAboutRent).getText();
        return text;
    }

    //геттер для assertEquals перехода на модалку Хотите сделать заказ
    public String getTextOfXpathHeaderModalWantToOrderFinished() {
        String text = driver.findElement(xpathHeaderModalWantToOrderFinished).getText();
        return text;
    }

    //геттер для assertEquals перехода на модалку Заказ оформлен
    public String getTextOfXpathHeaderModalOrderFinished() {
        String text = driver.findElement(xpathHeaderModalOrderFinished).getText();
        return text;
    }


    //метод ожидания появления заголовка Для кого самокат
    public void waitForOrderHeader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpathOrderHeader));
    }

    //метод ожидания появления списка станий метро
    public void waitForSelectSearhSubwayList() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpathSelectSearhSubwayList));
    }

    //метод ожидания, что поле Метро заполнено
    public void waitForSelectSearhSubwayEdit() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> (driver.findElement(xpathSelectSearhSubwayInput).getAttribute("value") != null
                && !driver.findElement(xpathSelectSearhSubwayInput).getAttribute("value").isEmpty()
        ));
    }

    //метод ожидания заголовка продолжения формы Про аренду
    public void waitForAboutRentHeader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpathHeaderAboutRent));
    }

    //метод ожидания появления календаря для Когда привезти самокат
    public void waitForModalCalendarClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpathModalCalendar));
    }

    //метод ожидания, что поле Когда привезти самокат заполнено
    public void waitForInputWhenToBringScooterEdit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpathModalCalendar));
    }

    //метод ожидания появления списка для Срок аренды
    public void waitForDropDownTermRentClickable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(xpathDropDownTermRent));
    }

    //метод ожидания, что поле Срок заполнено
    public void waitForInputTermRentEdit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathDropDownTermRentFilled));
    }

    //метод ожидания появления модалки Заказ оформлен
    public void waitForHeaderModalWantToOrderFinished() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpathHeaderModalWantToOrderFinished));
    }

    public void waitForHeaderOrderFinished() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpathHeaderModalOrderFinished));
    }

    //метод заполнения поля Имя
    public void fillInputName(String name) {
        driver.findElement(xpathInputName).click();
        driver.findElement(xpathInputName).sendKeys(name);
    }

    //метод заполнения поля Фамилия
    public void fillInputSurname(String surname) {
        driver.findElement(xpathInputSurname).click();
        driver.findElement(xpathInputSurname).sendKeys(surname);
    }

    //метод заполнения поля Адрес
    public void fillInputAdress(String adress) {
        driver.findElement(xpathInputAdress).click();
        driver.findElement(xpathInputAdress).sendKeys(adress);
    }

    //метод заполнения поля Станция по клику
    public void fillInputSearhSubway() {
        driver.findElement(xpathSelectSearhSubway).click();
        waitForSelectSearhSubwayList();
        WebElement element = driver.findElement(xpathSelectSearhSubwayButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(xpathSelectSearhSubwayButton).click();
        waitForSelectSearhSubwayEdit();
    }

    //метод заполнения поля Телефон
    public void fillInputPhoneNumber(String phoneNumber) {
        driver.findElement(xpathInputPhoneNumber).click();
        driver.findElement(xpathInputPhoneNumber).sendKeys(phoneNumber);
    }

    //метод клика по кнопке Заказать в форме order
    public void clickButtonNext() {
        driver.findElement(xpathButtonNext).click();
    }

    //метод заполнения поля Когда привезти самокат (клик, ожидание, клик дата)
    public void fillInputWhenToBringScooter(String data) {
        driver.findElement(xpathInputWhenToBringScooter).click();
        waitForModalCalendarClickable();
        driver.findElement(xpathInputTermRent).sendKeys(data);
        driver.findElement(xpathModalCalendarDateSelected).click();
        waitForInputWhenToBringScooterEdit();
    }

    //метод заполнения поля Срок аренды (клик, ожидание, клик option)
    public void fillInputTermRent() {
        driver.findElement(xpathDropDownRent).click();
        waitForDropDownTermRentClickable();
        WebElement element = driver.findElement(xpathDropDownTermRentFullDay);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(xpathDropDownTermRentFullDay).click();
        waitForInputTermRentEdit();
    }

    //метод выбора чек-бокса черный жемчуг/серый
    public void setCheckBoxColour(boolean colourBlack, boolean colourGrey) {
        By xpathColourBlack;
        By xpathColourGrey;
        if (colourBlack) {
            xpathColourBlack = xpathCheckBoxBlack;
            driver.findElement(xpathColourBlack).click();
        }
        if (colourGrey) {
            xpathColourGrey = xpathCheckBoxGrey;
            driver.findElement(xpathColourGrey).click();
        }
    }

    //метод заполнения поля Комментарий
    public void fillInputComment(String comment) {
        driver.findElement(xpathInputComment).click();
        driver.findElement(xpathInputComment).sendKeys(comment);
    }

    //метод клика по кнопке Заказать во второй части формы заказа
    public void clickButtonOrder() {
        driver.findElement(xpathButtonOrder).click();
    }

    //метод клика по кнопке Да в модалке Хотите оформить заказ
    public void clickButtonModalWantToOrderFinishedYes() {
        driver.findElement(xpathButtonModalWantToOrderFinishedYes).click();
    }

    //метод клика по кнопке Нет в модалке Хотите оформить заказ
    public void clickButtonModalWantToOrderFinishedNo() {
        driver.findElement(xpathButtonModalWantToOrderFinishedNo).click();
    }

    public static int randomTermRent = setupRandomTermRent();

    public static int setupRandomTermRent() {
        int numberOfOption = 7;

        Random random = new Random();
        randomTermRent = random.nextInt(numberOfOption) + 1;

        return randomTermRent;
    }

    public static int randomSubway = setupRandomSubway();

    public static int setupRandomSubway() {
        int numberOfOption = 224;

        Random random = new Random();
        randomSubway = random.nextInt(numberOfOption + 1);

        return randomSubway;
    }
}
