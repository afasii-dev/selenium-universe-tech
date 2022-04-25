package pageObject.somon.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//*[@name='q']")
    private WebElement search;

    @FindBy(xpath = "//*[@class='js-suggest-link-rubric']")
    private List<WebElement> searchSuggestItems;

    @FindBy(xpath = "//*[@class='js-dd-item'][@data-id!='all']")
    private List<WebElement> cities;

    @FindBy(xpath = "//*[@class='search-submit red-click']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@class='dd-block  js-dropdown dd-created']")
    private WebElement citiesDropdown;

    public void method() {

    }

}
