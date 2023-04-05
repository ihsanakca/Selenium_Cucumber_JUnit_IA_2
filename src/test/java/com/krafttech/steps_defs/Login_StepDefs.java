package com.krafttech.steps_defs;

import com.krafttech.pages.DashboardPage;
import com.krafttech.pages.LoginPage;
import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import com.sun.source.tree.AssertTree;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class Login_StepDefs {

    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();

//    WebDriver driver=Driver.get();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
//        System.out.println("Open Chrome and navigate to Login Page");
//        driver.get(ConfigurationReader.get("url"));
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("The user type in Selim credentials")
    public void the_user_type_in_selim_credentials() {
        //System.out.println("Selim types in valid userEmail and password");
        loginPage.loginMtd();
    }

    @When("The user type in Rosa credentials")
    public void the_user_type_in_rosa_credentials() {
        System.out.println("Rosa types in valid userEmail and password");
        loginPage.loginWithCredentialsMtd(ConfigurationReader.get("userEmail2"),ConfigurationReader.get("password2"));
    }

    @When("The user type in Ramanzi credentials")
    public void theUserTypeInRamanziCredentials() {
        loginPage.loginWithCredentialsMtd(ConfigurationReader.get("userEmail3"),ConfigurationReader.get("password3"));
    }

    @When("The user type in valid credentials: {string} and {string}")
    public void theUserTypeInAnd(String userEmail, String password) {
    loginPage.loginWithCredentialsMtd(userEmail,password);
    }


    @Then("The user type in valid credentials and verify successful login with user name")
    public void theUserTypeInValidCredentialsAndVerifySuccessfulLoginWithUserName(Map<String,String> userCredentials) {
        loginPage.loginWithCredentialsMtd(userCredentials.get("userEmail"),userCredentials.get("password"));
        String actualUserName = dashboardPage.userName.getText();
        Assert.assertEquals(userCredentials.get("userName"),actualUserName);
    }

    @Then("The warning message contains {string}")
    public void theWarningMessageContains(String warningMessage) {
        String actualMessage = loginPage.warningLoginMessageText(warningMessage);
        Assert.assertEquals(warningMessage,actualMessage);
    }

    @Then("The user type in valid credentials via list and verify successful login with user name")
    public void theUserTypeInValidCredentialsViaListAndVerifySuccessfulLoginWithUserName(List<String> userInfo) {
        loginPage.loginWithCredentialsMtd(userInfo.get(0),userInfo.get(1));
        Assert.assertEquals(dashboardPage.userName.getText(),userInfo.get(2));
    }
}
