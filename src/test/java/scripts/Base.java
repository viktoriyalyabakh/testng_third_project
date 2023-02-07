package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.SearchPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Base {

    WebDriver driver;
    BasePage basePage;
    SearchPage searchPage;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
        basePage = new BasePage();
        searchPage = new SearchPage();

    }

    @AfterMethod
    public void teardown() {
        //We will quit driver and do other proper clean ups
        Driver.quitDriver();
    }
}
