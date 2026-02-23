package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelpPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HelpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public boolean isUrlContains(String part) {
        try {
            wait.until(ExpectedConditions.urlContains(part));
            return driver.getCurrentUrl().contains(part);
        } catch (Exception e) {
            return false;
        }
    }
}
