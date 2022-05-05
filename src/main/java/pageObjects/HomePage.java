package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import tests.BaseClass;
import utilities.GeneralFunctions;
import utilities.Logging;


public class HomePage extends BaseClass {

    public HomePage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "login") public WebElement inpLoginName;
    @FindBy(name = "password") public WebElement inpPassword;
    @FindBy(xpath = "//button[@type='submit'][text()='Login']") public WebElement btnLogin;
    @FindBy(xpath = "//a[@class='nav-link'][text()='Logout']") public WebElement lnkLogout;
    @FindBy(xpath = "//*[contains(text(), 'Sign in')]") public WebElement lnkSignIn;
    @FindBy(xpath = "//a[@class='signup-btn button button-wide']") public WebElement lnkSignUp;
    /*
     * Method to validate page elements
     */
    SoftAssert softAssert = new SoftAssert();
    public void elementValidations() throws Exception {
        try {
            Logging.info("Validating elements on the page");
            softAssert.assertEquals(lnkSignUp.isEnabled(), "SIGN UP link does not exists");

        } catch (Exception e) {
            throw new Exception("Unable to continue with test due to - " + e.getMessage());
        }
    }

    /*
     * Method to click on Register button
     */
    public void clickOnSignUp() throws Exception{
        try{
            lnkSignIn.click();
            PageFactory.initElements(driver,this);
            lnkSignUp.click();
            GeneralFunctions.waitForPageLoad();
        }catch (Exception e){
            throw new Exception("Unable to click on SIGN UP link due to error - "+ e.getMessage());
        }
    }
}
