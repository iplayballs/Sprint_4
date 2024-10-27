package ru.qascooter.testCases;

import org.junit.Test;
import ru.qascooter.baseTest.BaseCookieClose;
import ru.qascooter.baseTest.BaseTestsBeforeAndAfter;
import ru.qascooter.pageObjects.OrderPageScooter;
import ru.qascooter.testCases.testData.OrderFormTestData;

import static org.junit.Assert.assertEquals;
import static ru.qascooter.baseTest.constants.BaseUrlConstants.URL_ORDER_SCOOTER;
import static ru.qascooter.testCases.testData.OrderFormTestData.*;

public class OrderFormTest extends BaseTestsBeforeAndAfter {

    @Test
    public void testFillingOrderFormSuccessShortTestData() {
        driver.get(URL_ORDER_SCOOTER);
        BaseCookieClose.clickCookieButtonClose(driver);
        BaseCookieClose.waitForInvisibilityCookieButtonClose(driver);

        OrderPageScooter objOrderPageScooter = new OrderPageScooter(driver);
        //ожидаем появления заголовка Для кого самокат
        objOrderPageScooter.waitForOrderHeader();
        //заполняем первую часть формы
        objOrderPageScooter.fillInputName(shortName);
        objOrderPageScooter.fillInputSurname(shortSurname);
        objOrderPageScooter.fillInputAdress(shortAdress);
        objOrderPageScooter.fillInputSearhSubway();
        objOrderPageScooter.fillInputPhoneNumber(eightPhoneNumber);
        objOrderPageScooter.clickButtonNext();
        //ожидаем появление заголовка второй части формы Про аренду
        objOrderPageScooter.waitForAboutRentHeader();
        //проверка перехода на вторую часть формы после клика на кнопку Далее
        assertEquals("Переход на вторую часть формы после клика на кнопку Далее", "Про аренду", objOrderPageScooter.getTextOfXpathAboutRentHeader());

        System.out.println("Тест testFillingOrderFormSuccessShortTestData заполнения Имени, Фамилии, Адреса, Метро, Номера телефона прошел успешно.");

        //заполняем вторую часть формы
        objOrderPageScooter.fillInputWhenToBringScooter(randomWhenToBringScooterDate);
        objOrderPageScooter.fillInputTermRent();
        OrderFormTestData.setBlackScooterColor(true);
        OrderFormTestData.setGreyScooterColor(false);
        objOrderPageScooter.setCheckBoxColour(blackScooterColor, greyScooterColor);
        objOrderPageScooter.fillInputComment(commentText);
        objOrderPageScooter.clickButtonOrder();
        //ожидаем появления заголовка модалки Хотите сделать заказ
        objOrderPageScooter.waitForHeaderModalWantToOrderFinished();
        //проверка появления формы
        assertEquals("Переход на модалку Хотите оформить заказ?", "Хотите оформить заказ?\n" +
                " ", objOrderPageScooter.getTextOfXpathHeaderModalWantToOrderFinished());

        System.out.println("Тест testFillingOrderFormSuccessShortTestData заполнения Когда призезти самокат, Срок, Цвет самоката, Комментрий прошел успешно.");

        //нажимаем Да в модалке Хотите оформить заказ
        objOrderPageScooter.clickButtonModalWantToOrderFinishedYes();
        //ожидание появления модалки Заказ оформлен
        objOrderPageScooter.waitForHeaderOrderFinished();
        //проверка появления модалки Заказ оформлен
        assertEquals("Переход на модалку Заказ оформлен", "Заказ оформлен", objOrderPageScooter.getTextOfXpathHeaderModalOrderFinished());

        System.out.println("Тест testFillingOrderFormSuccessShortTestData прошел успешно. Заказ успешно завершен.");
    }

    @Test
    public void testFillingOrderFormSuccessLongTestData() {
        driver.get(URL_ORDER_SCOOTER);
        BaseCookieClose.clickCookieButtonClose(driver);
        BaseCookieClose.waitForInvisibilityCookieButtonClose(driver);

        OrderPageScooter objOrderPageScooter = new OrderPageScooter(driver);
        //ожидаем появления заголовка Для кого самокат
        objOrderPageScooter.waitForOrderHeader();
        //заполняем первую часть формы
        objOrderPageScooter.fillInputName(longName);
        objOrderPageScooter.fillInputSurname(longSurname);
        objOrderPageScooter.fillInputAdress(longAdress);
        objOrderPageScooter.fillInputSearhSubway();
        objOrderPageScooter.fillInputPhoneNumber(plusSevenPhoneNumber);
        objOrderPageScooter.clickButtonNext();
        //ожидаем появление заголовка второй части формы Про аренду
        objOrderPageScooter.waitForAboutRentHeader();
        //проверка перехода на вторую часть формы после клика на кнопку Далее
        assertEquals("Переход на вторую часть формы после клика на кнопку Далее", "Про аренду", objOrderPageScooter.getTextOfXpathAboutRentHeader());

        System.out.println("Тест testFillingOrderFormSuccessLongTestData заполнения Имени, Фамилии, Адреса, Метро, Номера телефона прошел успешно.");

        //заполняем вторую часть формы
        objOrderPageScooter.fillInputWhenToBringScooter(randomWhenToBringScooterDate);
        objOrderPageScooter.fillInputTermRent();
        OrderFormTestData.setBlackScooterColor(false);
        OrderFormTestData.setGreyScooterColor(true);
        objOrderPageScooter.setCheckBoxColour(blackScooterColor, greyScooterColor);
        objOrderPageScooter.fillInputComment(commentText);
        objOrderPageScooter.clickButtonOrder();
        //ожидаем появления заголовка модалки Хотите сделать заказ
        objOrderPageScooter.waitForHeaderModalWantToOrderFinished();
        //проверка появления формы
        assertEquals("Переход на модалку Хотите оформить заказ?", "Хотите оформить заказ?\n" +
                " ", objOrderPageScooter.getTextOfXpathHeaderModalWantToOrderFinished());

        System.out.println("Тест testFillingOrderFormSuccessLongTestData заполнения Когда призезти самокат, Срок, Цвет самоката, Комментрий прошел успешно.");

        //нажимаем Да в модалке Хотите оформить заказ
        objOrderPageScooter.clickButtonModalWantToOrderFinishedYes();
        //ожидание появления модалки Заказ оформлен
        objOrderPageScooter.waitForHeaderOrderFinished();
        //проверка появления модалки Заказ оформлен
        assertEquals("Переход на модалку Заказ оформлен", "Заказ оформлен", objOrderPageScooter.getTextOfXpathHeaderModalOrderFinished());

        System.out.println("Тест testFillingOrderFormSuccessLongTestData прошел успешно. Заказ успешно завершен.");
    }
}
