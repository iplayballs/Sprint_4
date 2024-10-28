package ru.qascooter.test.cases.test.data;

import java.util.Random;

public class OrderFormTestData {
    public static String shortName = "Ян";
    public static String longName = "Абдурахмангаджи";

    public static String shortSurname = "Ли";
    public static String longSurname = "Оттовордемгентшенфельд";

    public static String shortAdress = "Московская 10";
    public static String longAdress = "Новосибирская область, город Бердск, дом 17";


    public static String eightPhoneNumber = "89998887766";
    public static String plusSevenPhoneNumber = "+79998887766";

    public static String randomWhenToBringScooterDate = setupRandomWhenToBringScooterDate();


    public static boolean blackScooterColor = true;
    public static boolean greyScooterColor = true;

    public static String commentText = "Повседневная практика показывает, что новая модель организационной деятельности представляет собой интересный эксперимент проверки системы обучения кадров, соответствует насущным потребностям. Товарищи! постоянное информационно-пропагандистское обеспечение нашей деятельности обеспечивает широкому кругу (специалистов) участие в формировании систем массового участия. Не следует, однако забывать, что новая модель организационной деятельности играет важную роль в формировании существенных финансовых и административных условий. Повседневная практика показывает, что постоянный количественный рост и сфера нашей активности представляет собой интересный эксперимент проверки дальнейших направлений развития. С другой стороны сложившаяся структура организации обеспечивает широкому кругу (специалистов) участие в формировании соответствующий условий активизации. Значимость этих проблем настолько очевидна, что постоянное информационно-пропагандистское обеспечение нашей деятельности в значительной степени обуславливает создание системы обучения кадров, соответствует насущным потребностям.";

    public static void setBlackScooterColor(boolean blackScooterColor) {
        OrderFormTestData.blackScooterColor = blackScooterColor;
    }

    public static void setGreyScooterColor(boolean greyScooterColor) {
        OrderFormTestData.greyScooterColor = greyScooterColor;
    }

    public static String setupRandomWhenToBringScooterDate() {
        int maxDays = 27;
        int maxMonth = 11;
        int actualYear = 2024;
        int maxYear = 2029;

        Random random = new Random();
        int randomDays = random.nextInt(maxDays) + 1;
        int randomMonth = random.nextInt(maxMonth) + 1;
        int randomYear = random.nextInt(maxYear - actualYear + 1) + actualYear;
        randomWhenToBringScooterDate = String.format("%02d.%02d.%04d", randomDays, randomMonth, randomYear);

        return randomWhenToBringScooterDate;
    }


}
