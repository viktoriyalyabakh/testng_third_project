package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{

    public SearchPage(){
        super();
    }

    @FindBy(css = "div[data-qa='menu-flex'] button")
    public List<WebElement> searchFilterOptions;

    @FindBy(css = "input[data-qa='search-bar-input']")
    public WebElement searchInputBox;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

    @FindBy(css = ".result-tile")
    public List<WebElement> tiles;

    @FindBy(css = "div.favorite-vehicle")
    public List<WebElement> addToFavoriteButton;

    @FindBy(css = ".result-tile img")
    public List<WebElement> images;

    @FindBy(css = "div.inventory-type-variant")
    public List<WebElement> inventoryTypes;

    @FindBy(css = "div.make-model")
    public List<WebElement> makeModelAndYears;

    @FindBy(css = "div.trim-mileage")
    public List<WebElement> trimAndMileages;

    @FindBy(css = "div.price")
    public List<WebElement> prices;

    @FindBy(css = "div.monthly-price")
    public List<WebElement> monthlyPayments;

    @FindBy(css = "div.down-payment")
    public List<WebElement> downPayments;

    @FindBy(id = "span.delivery")
    public List<WebElement> deliveryChips;

    @FindBy(css = "button[data-cv-test='Cv.Search.Pagination.NextPageButton']")
    public WebElement nextButton;




}
