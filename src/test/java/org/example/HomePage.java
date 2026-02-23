package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait driverWait;

    private final By titleBlock = By.xpath(".//div[@class='pay__wrapper']/h2");
    private final By partnersList = By.xpath(".//div[@class='pay__partners']/ul");
    private final By partnersImages = By.xpath(".//div[@class='pay__partners']/ul//img");
    private final By helpLink = By.xpath(".//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']");
    private final By cookieButton = By.xpath(".//button[@class='btn btn_black cookie__ok']");
    private final By phoneField = By.id("connection-phone");
    private final By sumField = By.id("connection-sum");
    private final By emailField = By.id("connection-email");
    private final By continueButton = By.xpath(".//form[@class='pay-form opened']/button");
    private final By paymentOverlay = By.xpath(".//div[@class='payment-widget-app']");
    private final By paymentFrame = By.xpath("//div[@class='payment-widget-app']//iframe");
    private final By payForm = By.id("pay");
    private final By paymentAmountBlock = By.xpath("//div[@class='pay-description__cost']");
    private final By cardBlock = By.xpath("//div[contains(@class,'card')]");
    private final By paymentDescriptionText = By.xpath("//div[@class='pay-description__text']/span");
    private final By cardIcons = By.xpath("//div[contains(@class,'cards-brands__container')]//img");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, 15);
    }

    public void open() {
        driver.get("https://www.mts.by/");
    }

    public String getTitleText() {
        WebElement title = driverWait.until(ExpectedConditions.visibilityOfElementLocated(titleBlock));
        return title.getText().trim();
    }

    public List<String> getPartnersAlts() {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(partnersList));
        List<WebElement> images = driver.findElements(partnersImages);
        return images.stream()
                .map(img -> img.getAttribute("alt"))
                .map(alt -> alt != null ? alt.trim() : "")
                .collect(Collectors.toList());
    }

    public HelpPage clickHelpLink() {
        WebElement link = driverWait.until(ExpectedConditions.elementToBeClickable(helpLink));
        link.click();
        return new HelpPage(driver);
    }

    public void fillPaymentForm(String phone, double sum, String email) {

        WebElement phoneEl = driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(phoneField)
        );
        phoneEl.clear();
        phoneEl.sendKeys(phone);

        WebElement sumEl = driver.findElement(sumField);
        sumEl.clear();
        sumEl.sendKeys(String.format("%.2f", sum));

        WebElement emailEl = driver.findElement(emailField);
        emailEl.clear();
        emailEl.sendKeys(email);
    }

    public void clickContinueButton() {
        WebElement btn = driverWait.until(ExpectedConditions.elementToBeClickable(continueButton));
        btn.click();
    }

    public boolean isPaymentOverlayDisplayed() {
        try {
            WebElement overlay = driverWait.until(ExpectedConditions.visibilityOfElementLocated(paymentOverlay));
            return overlay.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void closeCookieIfPresent() {
        try {
            WebElement cookieBtn = driverWait.until(ExpectedConditions.elementToBeClickable(cookieButton));
            cookieBtn.click();
            driverWait.until(ExpectedConditions.invisibilityOfElementLocated(cookieButton));
        } catch (Exception ignored) {}
    }

    public void selectPaymentTypeByJs(String formId) {

        WebElement selectElement = driverWait.until(
                ExpectedConditions.presenceOfElementLocated(payForm)
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "let select = arguments[0];" +
                        "let options = select.options;" +
                        "for (let i = 0; i < options.length; i++) {" +
                        "   if (options[i].getAttribute('data-open') === arguments[1]) {" +
                        "       select.selectedIndex = i;" +
                        "       select.dispatchEvent(new Event('change', { bubbles: true }));" +
                        "       break;" +
                        "   }" +
                        "}",
                selectElement,
                formId
        );

        By openedForm = By.xpath("//form[@id='" + formId + "' and contains(@class,'opened')]");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(openedForm));
    }

    public List<String> getFormPlaceholders(String formId) {
        By formLocator = By.id(formId);

        WebElement form = driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(formLocator)
        );

        List<WebElement> inputs = form.findElements(By.tagName("input"));

        return inputs.stream()
                .map(el -> el.getAttribute("placeholder"))
                .collect(Collectors.toList());
    }

    public void switchToPaymentFrameIfPresent() {
        try {
            WebElement frame = driverWait.until(
                    ExpectedConditions.presenceOfElementLocated(paymentFrame)
            );
            driver.switchTo().frame(frame);
        } catch (Exception ignored) {}
    }

    public double getPaymentAmountFromOverlay() {

        WebElement amountBlock = driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(paymentAmountBlock)
        );

        String text = amountBlock.getText();

        text = text.replace("BYN", "")
                .replace(",", ".")
                .trim();

        return Double.parseDouble(text);
    }

    public double getPaymentButtonAmount() {

        WebElement button = driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[@type='submit']")
                )
        );

        String text = button.getText();

        text = text.replaceAll("[^0-9,.]", "")
                .replace(",", ".");

        return Double.parseDouble(text);
    }

    public String getDisplayedPhone() {
        WebElement block = driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(paymentDescriptionText)
        );

        String text = block.getText();

        return text.replaceAll(".*Номер:", "").trim();
    }

    public List<String> getCardFieldLabels() {

        WebElement card = driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(cardBlock)
        );

        List<WebElement> labels = card.findElements(By.tagName("label"));

        return labels.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<String> getAllCardIconsSrc() {

        List<WebElement> icons = driverWait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(cardIcons)
        );

        return icons.stream()
                .map(icon -> icon.getAttribute("src"))
                .collect(Collectors.toList());
    }
}
