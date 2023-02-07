package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestData;
import utilities.TextHandler;
import utilities.Waiter;

public class CarvanaTest extends Base{

    /**
     * Test Case 1: Test name = Validate Carvana home page title and url
     * Test priority = 1
     * Given user is on "https://www.carvana.com/"
     * Then validate title equals  "Carvana | Buy & Finance Used Cars Online | At Home Delivery"
     * And validate url equals  "https://www.carvana.com/"
     */
    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validateTitleAndUrl(){
        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.getProperty("appURL"));
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
    }

    /**
     *Test Case 2: Test name = Validate the Carvana logo
     * Test priority = 2
     * Given user is on "https://www.carvana.com/"
     * Then validate the logo of the “Carvana” is displayed
     */

    @Test(priority = 2, description = "Validate the Carvana logo")
    public void validateLogo(){
    Assert.assertTrue(basePage.logo.isDisplayed());
    }

    /**
     * Test Case 3: Test name = Validate the main navigation section items
     * Test priority = 3
     * Given user is on "https://www.carvana.com/"
     * Then validate the navigation section items below are displayed
     * |HOW IT WORKS      |
     * |ABOUT CARVANA     |
     * |SUPPORT & CONTACT
     */

    @Test(priority = 3, description = "Validate the main navigation section items")
    public void validateMainNavigation(){

        for (int i = 0; i < basePage.navigationOptions.size(); i++) {
            Waiter.waitForVisibilityOfElement(basePage.navigationOptions.get(i), 30);
            Assert.assertEquals(basePage.navigationOptions.get(i).getText(), TestData.navSectionItems[i]);
        }
    }

    /**
     * Test Case 4: Test name = Validate the sign in error message
     * Test priority = 4
     * Given user is on "https://www.carvana.com/"
     * When user clicks on “SIGN IN” button
     * Then user should be navigated to “Sign in” modal
     * When user enters email as johndoe   @gmail.com
     * And user clicks on "CONTINUE" button
     * And user enters password as "abcd1234"
     * And user clicks on "SIGN IN" button
     * Then user should see error message as "Email address and/or password combination is incorrect
     */

    @Test(priority = 4, description = "Validate the sign in error message")
    public void validateSignInMassege(){

        basePage.signInLink.click();
        Assert.assertTrue(basePage.signModal.getText().contains("SIGN IN"));
        basePage.emailInputBox.sendKeys(TestData.emailInput);
        basePage.modalSighInButton.click();
        basePage.passwordInputBox.sendKeys(TestData.passwordInput);
        basePage.modalSighInButton.click();
        Assert.assertEquals(basePage.errorMessage.getText(), TestData.errorMessage);
    }

    /**
     * Test Case 5: Test name = Validate the search filter options and search button
     * Test priority = 5
     * Given user is on "https://www.carvana.com/"
     * When user clicks on "SEARCH CARS" link
     * Then user should be routed to "https://www.carvana.com/cars"
     * And user should see filter options
     * |PAYMENT & PRICE      |
     * |MAKE & MODEL      |
     * |BODY TYPE |
     * |YEAR & MILEAGE      |
     * |FEATURES      |
     * |MORE FILTERS |
     */

    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void validateSearchFilter(){

        basePage.searchCarLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.getProperty("appURL") + "cars");
        for (int i = 0; i < TestData.searchFilterOption.length; i++) {
            Assert.assertTrue(searchPage.searchFilterOptions.get(i).isDisplayed());
            Assert.assertTrue(searchPage.searchFilterOptions.get(i).isEnabled());
            Assert.assertEquals(searchPage.searchFilterOptions.get(i).getText(), TestData.searchFilterOption[i]);
        }

    }

    /**
     * Test Case 6: Test name = Validate the search result tiles
     * Test priority = 6
     * Given user is on "https://www.carvana.com/"
     * When user clicks on "SEARCH CARS" link
     * Then user should be routed to "https://www.carvana.com/cars"
     * When user enters "mercedes-benz" to the search input box
     * And user clicks on "GO" button in the search input box
     * Then user should see "mercedes-benz" in the url
     * And validate each result tile
     */

    @Test(priority = 6, description = "Validate the search result tiles")
    public void validateSearchResult(){
    basePage.searchCarLink.click();
    Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.getProperty("appURL") + "cars");
    searchPage.searchInputBox.sendKeys(TestData.inputMercedesBenz);
    searchPage.goButton.click();
    Assert.assertTrue(driver.getCurrentUrl().contains(TestData.inputMercedesBenz));

    while(searchPage.nextButton.isEnabled()){
        for (int i = 0; i < searchPage.tiles.size(); i++) {
            Assert.assertTrue(searchPage.tiles.get(i).isDisplayed());
            Assert.assertTrue(searchPage.images.get(i).isDisplayed());
            Assert.assertTrue(searchPage.addToFavoriteButton.get(i).isDisplayed());
            Assert.assertTrue(searchPage.inventoryTypes.get(i).isDisplayed());
            Assert.assertFalse(searchPage.inventoryTypes.get(i).getText().isEmpty());
            Assert.assertNotNull(searchPage.inventoryTypes.get(i).getText());
            Assert.assertTrue(searchPage.makeModelAndYears.get(i).isDisplayed());
            Assert.assertFalse(searchPage.makeModelAndYears.get(i).getText().isEmpty());
            Assert.assertNotNull(searchPage.makeModelAndYears.get(i).getText());
            Assert.assertTrue(searchPage.trimAndMileages.get(i).isDisplayed());
            Assert.assertFalse(searchPage.trimAndMileages.get(i).getText().isEmpty());
            Assert.assertNotNull(searchPage.trimAndMileages.get(i).getText());
            Assert.assertTrue(searchPage.prices.get(i).isDisplayed());
            Assert.assertTrue(TextHandler.getInt(searchPage.prices.get(i).getText()) > 0);
            Assert.assertTrue(searchPage.monthlyPayments.get(i).isDisplayed());
            Assert.assertFalse(searchPage.monthlyPayments.get(i).getText().isEmpty());
            Assert.assertNotNull(searchPage.monthlyPayments.get(i).getText());
            Assert.assertTrue(searchPage.downPayments.get(i).isDisplayed());
            Assert.assertFalse(searchPage.downPayments.get(i).getText().isEmpty());
            Assert.assertNotNull(searchPage.downPayments.get(i).getText());
            Assert.assertTrue(searchPage.deliveryChips.get(i).isDisplayed());
            Assert.assertFalse(searchPage.deliveryChips.get(i).getText().isEmpty());
            Assert.assertNotNull(searchPage.deliveryChips.get(i).getText());
        }

        searchPage.nextButton.click();
        }
    }

}
