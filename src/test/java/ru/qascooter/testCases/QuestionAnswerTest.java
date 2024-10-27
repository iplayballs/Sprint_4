package ru.qascooter.testCases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.qascooter.baseTest.BaseCookieClose;
import ru.qascooter.baseTest.BaseTestsBeforeAndAfter;
import ru.qascooter.page.objects.HomePageScooter;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static ru.qascooter.baseTest.constants.BaseUrlConstants.URL_MAIN_SCOOTER;

@RunWith(Parameterized.class)
public class QuestionAnswerTest extends BaseTestsBeforeAndAfter {

    private final String expectedQuestion;
    private final String expectedAnswer;
    private final int accordionIndex;

    public QuestionAnswerTest(String expectedQuestion, String expectedAnswer, int accordionIndex) {
        this.expectedQuestion = expectedQuestion;
        this.expectedAnswer = expectedAnswer;
        this.accordionIndex = accordionIndex;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionAndAnswer() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7}
        };
    }

    @Test
    public void testComplianceFAQQuestionAnswer() {
        driver.get(URL_MAIN_SCOOTER);
        BaseCookieClose.clickCookieButtonClose(driver);
        BaseCookieClose.waitForInvisibilityCookieButtonClose(driver);

        HomePageScooter objHomePageScooter = new HomePageScooter(driver);
        objHomePageScooter.waitForHeaderQuestionsAboutMain();

        //собираем xpath вопроса и ответа
        String xpathLocatorQuestion = ".//div[@id='accordion__heading-" + accordionIndex + "']";
        String xpathLocatorAnswer = ".//div[@id='accordion__panel-" + accordionIndex + "']/p";

        //скролл до аккордеона
        WebElement element = driver.findElement(By.xpath(xpathLocatorQuestion));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        //ожидание кликабельности элемента
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLocatorQuestion)));

        //клик по вопросу
        driver.findElement(By.xpath(xpathLocatorQuestion)).click();

        //ожидание появления ответа
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLocatorAnswer)));

        //получаем текст вопроса и ответа из найденных элементов
        String elementQuestion = driver.findElement(By.xpath(xpathLocatorQuestion)).getText();
        String elementAnswer = driver.findElement(By.xpath(xpathLocatorAnswer)).getText();

        //собираем вопрос и ответ для сравнения
        String expectedQuestionAndAnswer = expectedQuestion + " " + expectedAnswer;
        String actualQuestionAndAnswer = elementQuestion + " " + elementAnswer;

        assertEquals("Ожидается вопрос: " + expectedQuestion + ". Ожидается ответ: " + expectedAnswer, expectedQuestionAndAnswer, actualQuestionAndAnswer);

        System.out.println("Тест QuestionAnswerTest прошел успешно.");
    }
}
