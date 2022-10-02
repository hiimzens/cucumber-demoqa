package com.demoqa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.demoqa.steps.StepHooks.driver;

public class BasePage {

    private static final int SELENIUM_TIMEOUT_IN_SECONDS = Integer.parseInt(System.getProperty("TIMEOUT_IN_SECOND"));
    public static void navigate(String url){
        driver.get(System.getProperty("BASE_URL") + url);
    }

    //  ------------------- Query Element -----------------------------

    public static List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }
    public static WebElement findElement(By locator){
        return driver.findElement(locator);
    }
    //  ------------------- Wait Element -----------------------------

    public static WebElement waitForVisibilityOfElementLocated(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SELENIUM_TIMEOUT_IN_SECONDS));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SELENIUM_TIMEOUT_IN_SECONDS));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    //  ------------------- Interact with  Element -----------------------------
    //  Write Text
    public void inputText(By locator, String value) {
        WebElement element = waitForElementToBeClickable(locator);
        element.sendKeys(value);
    }
    public static void clickElement(By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        element.click();
    }
    public void selectDropdownValue(By dropdownField, By dropdownValue){
        clickElement(dropdownField);
        clickElement(dropdownValue);
    }
    public void selectOptionByText(By locator, String text){
        WebElement element = waitForVisibilityOfElementLocated(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    public boolean isElementDisplayed(By locator){
        try{
            return findElement(locator).isDisplayed();
        }catch (NoSuchElementException | StaleElementReferenceException exp){
            return false;
        }
    }
    public static By formatXpath(String stringLocator, String parameter){
        return By.xpath(String.format(stringLocator,parameter));
    }
    public static String getText(By locator) {
        WebElement element = waitForVisibilityOfElementLocated(locator);
        return element.getText();
    }

    public static ArrayList<String> getTextOfElements(By locator, Boolean moveToElement) {
        List<WebElement> elements = findElements(locator);
        ArrayList<String> result = new ArrayList<>();
        for (WebElement element : elements) {
            if (moveToElement == Boolean.TRUE) {
                Actions actionChains = new Actions(driver);
                actionChains.moveToElement(element).perform();
            }
            result.add(element.getText());
        }
        return result;
    }
    public static void addCookies(String name, String value){
        driver.manage().addCookie(new Cookie(name, value));
    }

    public static void scrollToPageBottom(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    public static void zoomOut() throws AWTException {
        for (int i = 0; i <= 4; i++) {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_MINUS);
            robot.keyRelease(KeyEvent.VK_MINUS);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }
    public Alert waitForAlertToBeVisible (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SELENIUM_TIMEOUT_IN_SECONDS));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
    public String getTextOfAlert(){
        Alert alert = waitForAlertToBeVisible();
        return alert.getText();
    }
    public void clickOKButtonOfAlert() {
        Alert alert = waitForAlertToBeVisible();
        alert.accept();
    }
}



