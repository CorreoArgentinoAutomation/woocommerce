package helpers;

import org.openqa.selenium.WebDriver;

public class Helper {
    public WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
