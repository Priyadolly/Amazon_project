package AmazonHome;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHome {

    private WebDriver driver;

    public AmazonHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id="twotabsearchtextbox")
    @Getter
    WebElement searchBox;

    @FindBy(xpath="(//span[@class=\"rush-component\"]//span)[3]")
    @Getter
    WebElement searchResult;


    @FindBy(xpath = "//div[@id=\"searchMessageContainer\"]//span[2]")
    @Getter
    WebElement multipleKeywordResult;

    @FindBy(xpath = "//span[contains(text(), \"Try checking your spelling\")]")
    @Getter
    WebElement negativeResult;

    @FindBy(xpath = "(//span[@class=\"nnn\"])[1]")
    @Getter
    WebElement product1;



}
