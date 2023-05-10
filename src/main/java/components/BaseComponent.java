package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.WaitHelper;

import static setup.DriverUtils.driver;

public abstract class BaseComponent {

    protected Actions actions;

    public BaseComponent() {
        actions = new Actions(driver);
    }

    public abstract boolean isLoaded();

    public boolean isElementDisplayed(By locator) {
        try {
            WaitHelper.getInstance(5).waitForElementToBeVisible(locator);
            return true;
        } catch (Error ignored) {
            return false;
        }
    }

    public boolean isElementClickable(By locator, int seconds) {
        try {
            WaitHelper.getInstance(seconds).waitForElementToBeClickable(locator);
            return true;
        } catch (Error ignored) {
            return false;
        }
    }

    public boolean isElementDisplayed(By locator, int seconds) {
        try {
            WaitHelper.getInstance(seconds).waitForElementToBeVisible(locator);
            return true;
        } catch (Error ignored) {
            return false;
        }
    }

    public boolean isElementClickable(By locator) {
        try {
            WaitHelper.getInstance(5).waitForElementToBeClickable(locator);
            return true;
        } catch (Error ignored) {
            return false;
        }
    }

    public void click(By locator) {
        WebElement element = WaitHelper.getInstance(5).waitForElementToBeClickable(locator);
        element.click();
    }

    public String getText(By locator) {
        WebElement element = WaitHelper.getInstance(5).waitForElementToBeVisible(locator);
        return element.getText();
    }

    public void typeIn(By locator, String text) {
        WebElement element = WaitHelper.getInstance(5).waitForElementToBeVisible(locator);
        element.sendKeys(text);
    }

    public void clearContent(By locator) {
        WebElement element = WaitHelper.getInstance(1).waitForElementToBeClickable(locator);
        element.clear();
    }

}
