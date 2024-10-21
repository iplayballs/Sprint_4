package testCases;

import base.BaseCookieClose;
import base.BaseTestsBeforeAndAfter;
import org.junit.Test;
import pageObjects.HomePageScooter;
import pageObjects.OrderPageScooter;

import static base.constants.BaseUrlConstants.URL_MAIN_SCOOTER;
import static org.junit.Assert.assertEquals;

public class ButtonOrderTest extends BaseTestsBeforeAndAfter {

    @Test
    public void testButtonOrderInHeader  (){
        driver.get(URL_MAIN_SCOOTER);
        BaseCookieClose.clickCookieButtonClose(driver);
        BaseCookieClose.waitForInvisibilityCookieButtonClose(driver);

        HomePageScooter objHomePageScooter = new HomePageScooter(driver);
        objHomePageScooter.waitForButtonOrderInHeader();

        objHomePageScooter.clickButtonOrderInHeader();

        OrderPageScooter objOrderPageScooter = new OrderPageScooter(driver);
        objOrderPageScooter.waitForOrderHeader();

        assertEquals("Переход на страницу /order", "Для кого самокат", objOrderPageScooter.getTextOfOrderHeader());

        System.out.println("Тест testButtonOrderInHeader прошел успешно.");
    }

    @Test
    public void testButtonOrderInHomeRoadMap  (){
        driver.get(URL_MAIN_SCOOTER);
        BaseCookieClose.clickCookieButtonClose(driver);
        BaseCookieClose.waitForInvisibilityCookieButtonClose(driver);

        HomePageScooter objHomePageScooter = new HomePageScooter(driver);
        objHomePageScooter.waitForHeaderQuestionsAboutMain();

        objHomePageScooter.scrollButtonOrderInHomeRoadMap();
        objHomePageScooter.clickButtonOrderInHomeRoadMap();

        OrderPageScooter objOrderPageScooter = new OrderPageScooter(driver);
        objOrderPageScooter.waitForOrderHeader();

        assertEquals("Переход на страницу /order", "Для кого самокат", objOrderPageScooter.getTextOfOrderHeader());

        System.out.println("Тест testButtonOrderInHomeRoadMap прошел успешно.");
    }
}
