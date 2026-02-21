package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
    }

    @Test
    public void testBlockTitle() {
        driver.get("https://www.mts.by/");
        By titleXPath = By.xpath(".//div[@class='pay__wrapper']/h2");
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(titleXPath));

        String actualTitle = titleElement.getText().trim();
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testPartnersImages() {
        driver.get("https://www.mts.by/");

        By partnersUlXPath = By.xpath(".//div[@class='pay__partners']/ul");
        wait.until(ExpectedConditions.presenceOfElementLocated(partnersUlXPath));

        List<WebElement> images = driver.findElements(By.xpath(".//div[@class='pay__partners']/ul//img"));
        assertEquals(5, images.size());

        List<String> actualAlts = images.stream()
                .map(img -> img.getAttribute("alt"))
                .map(alt -> alt != null ? alt.trim() : "")
                .collect(Collectors.toList());

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
        driver.get("https://www.mts.by/");
        closeCookieIfPresent();

        By helpLinkXPath = By.xpath(".//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']");
        WebElement helpLink = wait.until(ExpectedConditions.elementToBeClickable(helpLinkXPath));

        helpLink.click();

        String expectedUrlPart = "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        wait.until(ExpectedConditions.urlContains(expectedUrlPart));

        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(expectedUrlPart));
    }

    private void closeCookieIfPresent() {
        try {
            By cookieButtonXPath = By.xpath(".//button[@class='btn btn_black cookie__ok']");
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieButtonXPath));
            cookieButton.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(cookieButtonXPath));
        } catch (Exception e) {
            System.out.println("Cookie-баннер не найден или уже закрыт");
        }
    }

    @Test
    public void testOnlinePaymentForm() {
        driver.get("https://www.mts.by/");
        closeCookieIfPresent();

        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone")));
        phoneField.sendKeys("297777777");

        WebElement sumField = driver.findElement(By.id("connection-sum"));
        sumField.sendKeys("100");

        WebElement emailField = driver.findElement(By.id("connection-email"));
        emailField.sendKeys("test.mail@mail.ru");

        By continueButtonXPath = By.xpath(".//form[@class='pay-form opened']/button");
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonXPath));
        continueButton.click();

        By overlayXPath = By.xpath(".//div[@class='payment-widget-app']");
        WebElement overlay = wait.until(ExpectedConditions.visibilityOfElementLocated(overlayXPath));
        assertTrue(overlay.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
