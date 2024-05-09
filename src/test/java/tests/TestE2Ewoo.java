package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Ecommerce;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestE2Ewoo {

    private WebDriver driver;


    @Before
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://staging2.gabriell48.sg-host.com/wp-admin");
        driver.manage().window().maximize();
    }

    @Test
    //colocar aquí descripción del test.
    public void E2E(){
        Ecommerce ecommerce = new Ecommerce(driver);
        ecommerce.metodoE2E();

    }

    @After
    public void tearDown(){}

}
