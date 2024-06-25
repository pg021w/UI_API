package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;

    }

    By search = By.xpath("//input[@id='twotabsearchtextbox']");
    By productName = By.xpath("//span[@data-component-type='s-search-results']//div[@data-cel-widget='search_result_1']//child::div[1]//div[@data-cy='title-recipe']");
    By submit = By.xpath("//input[@type='submit']");
    By resultList = By.xpath("//span[contains(text(),'Apple iPhone')]//ancestor::div[starts-with(@data-asin,'B0')]");

    public void searchItem(String name) {
        driver.findElement(search).sendKeys(name);
        driver.findElement(submit).click();
    }

    public String getTitleLandingPage() {
        return driver.getTitle();
    }

    public List<WebElement> getResultList() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver.findElements(resultList);
    }

}

