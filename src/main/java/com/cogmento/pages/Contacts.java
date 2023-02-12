package com.cogmento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class Contacts extends HomePage{
    public Contacts(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "//a[@href= '/contacts/new']")
    protected WebElement createContactButton;
    @FindBy (name = "first_name")
    protected WebElement firstNameInput;
    @FindBy (name = "middle_name")
    protected WebElement middleNameInput;
    @FindBy (xpath = "//div [@class = 'four wide field']/button")
    protected WebElement accessBtn;
    @FindBy (xpath = "//div [@class = 'ui field']/div/input[@placeholder ='Email address']")
    protected WebElement emailInput;
    @FindBy (xpath = "//div [@class = 'ui field']/div [@name = 'status']")
    protected WebElement statusDropDown;
    @FindBy (xpath = "//div[@class = 'ui field']/div[@name = 'channel_type']")
   protected WebElement socialChannelsDropDown;

    @FindBy (xpath = "//div[@class = 'ui input']/input[@name = 'address']")
    protected WebElement streetInput;
    @FindBy (xpath = "//div[@class = 'ui input']/input[@name = 'city']")
    protected WebElement cityInput;
    @FindBy (xpath = "//div[@class = 'ui input']/input[@name = 'state']")
    protected WebElement stateInput;
    @FindBy (xpath = "//div[@class = 'ui input']/input[@name = 'zip']")
    protected WebElement postCodeInput;
    @FindBy (xpath = "//div[@class = 'three wide field']/div [@name = 'country']")
    protected WebElement countryDropDown;
    @FindBy (xpath = "//div[@class = 'ui input']/input[@name = 'position']")
    protected  WebElement positionInput;
    @FindBy (xpath = "//label[text()=  'Supervisor']/following-sibling::div/input")
    protected WebElement supervisorInput;
    @FindBy(xpath = "//label [text () = 'Referred By']/following-sibling::div/input")
    protected WebElement referredByInput;
    @FindBy (xpath = "//input[@class = 'hidden']/following-sibling::label [text () = 'Do not Call']")
    protected WebElement doNotCallBtn;
    @FindBy (xpath = "//input[@class = 'hidden']/following-sibling::label [text () = 'Do not Email']")
    protected WebElement doNotEmailBtn;

    @FindBy (xpath = "//label[text() = 'Identifier']/following-sibling::div/input")
    protected WebElement identifierInput;
    @FindBy (name = "last_name")
    protected WebElement lastNameInput;
    @FindBy (xpath = "//div[@name='company']/input")
    protected WebElement companyInput;
    @FindBy (xpath = "//label [@for = 'tags']/div/input")
    protected WebElement tagsInput;
    @FindBy (xpath = "//label [text () = 'Category'] /following-sibling::div")
    protected WebElement categoryDropDown;
    @FindBy (xpath = "//label [text () = 'Description'] /following-sibling::textarea")
    protected WebElement descriptionInput;


    public void createContact(HashMap<String,String> data) {
        navigate("contacts");
        driver.navigate().back();
        driver.navigate().forward();
        softAssert.assertTrue(createContactButton.isEnabled(), "Create button is not enabled");
        createContactButton.click();

        firstNameInput.sendKeys( (data.get("firstname")));
        middleNameInput.sendKeys(data.get("middlename"));

                if (!data.get("access").equals("public")) {
                    accessBtn.isEnabled();
                }
        emailInput.sendKeys(data.get ("email"));
        statusDropDown.click();
        statusDropDown.findElement(By.xpath("//div/div/span[text () = '"+data.get("status")+"']")).click();
        socialChannelsDropDown.click();
        socialChannelsDropDown.findElement(By.xpath("//div [@class = 'visible menu transition']/div/span [text() = '"+data.get("socialchannels")+"']")).click();
        streetInput.sendKeys(data.get("street"));
        cityInput.sendKeys(data.get("city"));
        stateInput.sendKeys(data.get("state/county"));
        postCodeInput.sendKeys(data.get("postcode"));
        countryDropDown.click();
        countryDropDown.findElement(By.xpath("//div[@role = 'option']/span [text () = '"+data.get("country")+"']")).click();
        positionInput.sendKeys(data.get ("position"));
        supervisorInput.sendKeys(data.get("supervisor"));
        referredByInput.sendKeys(data.get("referred"));

        if (data.get("call?").equals("yes")) {
            doNotCallBtn.click();
        }
        if (!data.get ("email?").equals("no")) {
            doNotEmailBtn.click();
        }
        identifierInput.sendKeys(data.get ("identifier"));
        lastNameInput.sendKeys(data.get ("lastname"));
        companyInput.sendKeys(data.get ("company"));
        tagsInput.sendKeys(data.get("tags"));
        categoryDropDown.click();
        categoryDropDown.findElement(By.xpath("//div [@class = 'visible menu transition']/div/span[text () = 'Lead']")).click();

        descriptionInput.sendKeys(data.get("description"));




////        lastNameInput.sendKeys(data.get ("lastname"));
        //        companyInput.sendKeys(data.get ("company"));
//                category.click();
//                category.findElement(By.xpath()).click();
//
//                status.click();
//                status.findElement(By.xpath()).click();
//
//                description.sendKeys(data.get("description"));
//
//                socialchannels.click();
//                socialchannels.findElement(By.xpath()).click();
//
//                socialchannelsInput.sendKeys (data.get("sociallink"));

               // street.sendKeys
        //дальше сделать FindBy













    }


}
