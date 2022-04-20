package opencart.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@RequiredArgsConstructor
public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//*[@class='btn btn-link navbar-btn']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@class='btn btn-black navbar-btn']")
    private WebElement registerButton;

    public void method(){

    }

}
