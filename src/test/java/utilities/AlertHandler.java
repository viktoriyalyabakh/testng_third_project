package utilities;

import org.openqa.selenium.WebDriver;

public class AlertHandler {

    public static void acceptAlert(){
        Driver.getDriver().switchTo().alert().accept();
    }

    public static void dismissAlert(){
        Driver.getDriver().switchTo().alert().dismiss();
    }

    public static void sendKeysToAlert(String key){
        Driver.getDriver().switchTo().alert().sendKeys(key);
    }

    public static String getAlertText(WebDriver driver){
        return driver.switchTo().alert().getText();
    }
}
