package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTests {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
    }

    @Test
    public void testBlockTitle() {
        homePage.open();
        String actualTitle = homePage.getTitleText();
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testPartnersImages() {
        homePage.open();
        List<String> actualAlts = homePage.getPartnersAlts();
        assertEquals(5, actualAlts.size());
        Set<String> expectedAlts = Set.of(
                "Visa",
                "Verified By Visa",
                "MasterCard",
                "MasterCard Secure Code",
                "Белкарт"
        );
        assertTrue(actualAlts.containsAll(expectedAlts) && expectedAlts.containsAll(actualAlts));
    }

    @Test
    public void testHelpLinkRedirect() {
        homePage.open();
        homePage.closeCookieIfPresent();
        HelpPage helpPage = homePage.clickHelpLink();
        String expectedUrlPart = "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        assertTrue(helpPage.isUrlContains(expectedUrlPart));
    }

    @Test
    public void testOnlinePaymentForm() {
        homePage.open();
        homePage.closeCookieIfPresent(); // как в оригинале

        homePage.fillPaymentForm("297777777", 100.00, "test.mail@mail.ru");
        homePage.clickContinueButton();

        assertTrue(homePage.isPaymentOverlayDisplayed());
    }

    @Test
    public void testOnlinePaymentFormFullCheck() {
        String phone = "297777777";
        double sum = 100.00;
        String email = "test.mail@mail.ru";

        homePage.open();
        homePage.closeCookieIfPresent();
        homePage.selectPaymentTypeByJs("pay-connection");

        homePage.fillPaymentForm(phone, sum, email);
        homePage.clickContinueButton();

        assertTrue(homePage.isPaymentOverlayDisplayed());

        homePage.switchToPaymentFrameIfPresent();

        double amountFromSpan = homePage.getPaymentAmountFromOverlay();
        double amountFromButton = homePage.getPaymentButtonAmount();
        assertEquals(sum, amountFromSpan);
        assertEquals(sum, amountFromButton);

        String expectedPhone = "375" + phone;
        String phoneText = homePage.getDisplayedPhone();
        assertTrue(phoneText.contains(expectedPhone));

        List<String> labels = homePage.getCardFieldLabels();
        List<String> expectedLabels = List.of(
                "Номер карты",
                "Срок действия",
                "CVC",
                "Имя и фамилия на карте"
        );
        assertTrue(labels.containsAll(expectedLabels));

        List<String> icons = homePage.getAllCardIconsSrc();
        assertTrue(icons.stream().anyMatch(s -> s.contains("visa-system")));
        assertTrue(icons.stream().anyMatch(s -> s.contains("mastercard-system")));
        assertTrue(icons.stream().anyMatch(s -> s.contains("belkart-system")));
        assertTrue(icons.stream().anyMatch(s -> s.contains("maestro-system")));
        assertTrue(icons.stream().anyMatch(s -> s.contains("mir-system")));
    }

    @Test
    public void testAllPaymentFormsPlaceholders() {
        homePage.open();
        homePage.closeCookieIfPresent();

        Map<String, List<String>> expectedData = Map.of(
                "pay-connection", List.of("Номер телефона", "Сумма", "E-mail для отправки чека"),
                "pay-internet", List.of("Номер абонента", "Сумма", "E-mail для отправки чека"),
                "pay-instalment", List.of("Номер счета на 44", "Сумма", "E-mail для отправки чека"),
                "pay-arrears", List.of("Номер счета на 2073", "Сумма", "E-mail для отправки чека")
        );

        for (String formId : expectedData.keySet()) {

            homePage.selectPaymentTypeByJs(formId);

            List<String> actual = homePage.getFormPlaceholders(formId);
            List<String> expected = expectedData.get(formId);

            assertEquals(expected, actual);
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
