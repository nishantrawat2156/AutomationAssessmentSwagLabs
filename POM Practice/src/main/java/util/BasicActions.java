package util;

import config.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicActions {

    protected final WebDriver bot;
    protected final WebDriverWait waiter;

    public BasicActions(WebDriver bot) {
        this.bot = bot;
        this.waiter = new WebDriverWait(bot, 2);
    }

    protected boolean verifyProductRemoval(By element) {
        boolean isProdVisible = false;
        try{
            waiter.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException to) {
            isProdVisible = true;
        }
        return isProdVisible;
    }

//    //protected String pageTitle() {
//        return bot.getTitle();
//    }

    protected void enterUsername(By element) {
        bot.findElement(element).sendKeys(Properties.username);
    }

    protected void enterPassword(By element) {
        bot.findElement(element).sendKeys(Properties.password);
    }

    protected void click(By element) {bot.findElement(element).click();}

    protected String storeText(By element) {
        return bot.findElement(element).getText();
    }

    protected String textRetriever(By element) {
        return bot.findElement(element).getText();
    }

    protected boolean dataMatcher(String data, By element) {
        String text = textRetriever(element);

        if (text.equals(data)) {
            return true;
        } else {
            return false;
        }
    }

    protected void enterFirstNameForCheckout(By element) {bot.findElement(element).sendKeys(Properties.firstName);}

    protected void enterLastNameForCheckout(By element) {bot.findElement(element).sendKeys(Properties.lastName);}

    protected void enterPinCodeForCheckout(By element) {bot.findElement(element).sendKeys(Properties.postalCode);}

    public static void sleep(double sec) {
        try {
            Thread.sleep((long) (sec * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
