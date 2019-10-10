package com.oracle.qa.pages;

import com.oracle.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffHomePage extends TestBase {
    //page Factory - object repo
    @FindBy(xpath = "//a[@title='Create Rediffmail Account']")
    WebElement createAccount;
    @FindBy(xpath = "//a[@class='signin']")
    WebElement signIn;

    //initlising the page objects
    public RediffHomePage() {
        PageFactory.initElements(driver, this);
    }

    // action class
    public String validateTitle() {
        return driver.getTitle();
    }

    public RegistrationPage createAccount() {
        createAccount.click();
        return new RegistrationPage();
    }
}
