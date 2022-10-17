package testNG;

import org.example.driver.BaseClass;
import org.example.driver.Listener;
import org.example.pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Listeners(Listener.class)
public class SearchTest extends BaseClass {
public WebDriver driver;

    @Test(priority = 1)
    public void SearchForNoResults() throws InterruptedException, IOException {
        driver=initialization("https://www.imdb.com/");
        SearchPage searchPage= new SearchPage(driver);
        searchPage.search.sendKeys("Friends (1994) (TV Series)");
        searchPage.icon.click();
        System.out.println(searchPage.header.getText());
       // Assert.assertEquals(searchPage.movieNamePage.getText(),"Friends (1994) (TV Series");
    }
    @Test(priority = 2)
    public void SearchWithoutKeyword() throws InterruptedException, IOException {
        driver=initialization("https://www.imdb.com/");
        SearchPage loginPage= new SearchPage(driver);
        loginPage.icon.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(loginPage.alertMessage.getText(),"Search IMDb by typing a word or phrase in the search box at the top of this page.");
    }

    @Test(priority = 3)
    public void SelectTVEpisodes() throws InterruptedException, IOException {
        driver = initialization("https://www.imdb.com/");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.dropdown.click();
        List<WebElement> allOptions = driver.findElements(By.xpath("(//*[@id=\"iconContext-arrow-drop-down\"])[1]"));
        System.out.println(allOptions.size());
        for (int i = 0; i <= allOptions.size() - 1; i++) {
            if (allOptions.get(i).getText().contains("TV Episodes")) {
                allOptions.get(i).click();
                break;
            }
                searchPage.search.sendKeys("Friends");
                searchPage.icon.click();
                System.out.println(driver.getCurrentUrl());
              //  Assert.assertEquals(searchPage.movieNamePage.getText(),"Friends");
            }
        }

    @Test(priority = 4)
    public void displayResultCount() throws InterruptedException, IOException {
        driver = initialization("https://www.imdb.com/");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.dropdown.click();
        List<WebElement> allOptions = driver.findElements(By.xpath("(//*[@id=\"iconContext-arrow-drop-down\"])[1]"));
        System.out.println(allOptions.size());
        for (int i = 0; i <= allOptions.size() - 1; i++) {
            if (allOptions.get(i).getText().contains("TV Episodes")) {
                allOptions.get(i).click();
                break;
            }
            searchPage.search.sendKeys("Friends");
            searchPage.icon.click();
            searchPage.titleLink.click();
            String count = searchPage.count.getText();
            System.out.println("Result count is "+count);
    }
    }

    @Test(priority = 5)
    public void SearchForUmlauts() throws InterruptedException, IOException {
        driver=initialization("https://www.imdb.com/");
        SearchPage searchPage= new SearchPage(driver);
        searchPage.search.sendKeys("Müller");
        searchPage.icon.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(searchPage.header.getText(),"Results for \"Müller\"");
    }
}
