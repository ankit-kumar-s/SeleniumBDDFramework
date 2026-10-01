package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import framework.utils.WaitUtils;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils waitUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    protected void click(By locator) {
        waitUtils.waitForElementToBeClickable(locator);
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        waitUtils.waitForElementToBeVisible(locator);
        driver.findElement(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        waitUtils.waitForElementToBeVisible(locator);
        return driver.findElement(locator).getText();
    }
    protected boolean isDisplayed(By locator) {
        waitUtils.waitForElementToBeVisible(locator);
        return driver.findElement(locator).isDisplayed();
    }
    protected void clear(By locator) {
        waitUtils.waitForElementToBeVisible(locator);
        driver.findElement(locator).clear();
    }
    protected String getAttribute(By locator, String attribute) {
        waitUtils.waitForElementToBeVisible(locator);
        return driver.findElement(locator).getAttribute(attribute);
    }
    protected void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }
}