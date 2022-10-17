package org.example.pages;

import org.example.driver.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseClass {



    @FindBy(xpath ="//input[@id=\"suggestion-search\"]" )
    public WebElement search;

    @FindBy(xpath ="//*[@id=\"iconContext-magnify\"]" )
    public WebElement icon;

    @FindBy(xpath = "//a[contains(text(),'Exam')]")
    public  WebElement movieName;

    @FindBy(xpath = "//h1[contains(text(),'Exam')]")
    public  WebElement movieNamePage;

    @FindBy(xpath = "//p[contains(text(),'Search IMDb by typing a word or phrase in the sear')]")
    public  WebElement alertMessage;

    @FindBy(xpath = "(//*[@id=\"iconContext-arrow-drop-down\"])[1]")
    public  WebElement dropdown;

    @FindBy(xpath = "//h1[@class=\"findHeader\"]")
    public  WebElement header;

    @FindBy(linkText = "Friends")
    public  WebElement titleLink;

    @FindBy(xpath = "//*[@data-testid=\"hero-subnav-bar-series-episode-count\"]")
    public  WebElement count;



    public SearchPage(WebDriver driver){
    this.driver= driver;
        PageFactory.initElements(driver,this);

 }

 public void handleAlert(){
     Alert alert = driver.switchTo().alert();
     alert.accept();
 }
}
