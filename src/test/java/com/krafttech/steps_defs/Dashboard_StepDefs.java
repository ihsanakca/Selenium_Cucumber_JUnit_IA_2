package com.krafttech.steps_defs;

import com.krafttech.pages.DashboardPage;
import com.krafttech.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Dashboard_StepDefs {
    DashboardPage dashboardPage=new DashboardPage();


    @Then("The user should be able to login successfully")
    public void the_user_should_be_able_to_login_successfully() {
        //System.out.println("Assert that user is able to login the site");
        Assert.assertTrue(dashboardPage.dashboardPageSubTitle.isDisplayed());
    }

    @Then("The user should be able to see {string}")
    public void theUserShouldBeAbleToSee(String expectedUserName) {
        String actualName = dashboardPage.userName.getText();
        Assert.assertEquals("should be same",expectedUserName,actualName);
        //dashboardPage.logoutAndNavigateToLoginPage(expectedUserName);
    }

    @When("The user navigate to {string} and {string}")
    public void theUserNavigateToAnd(String tabName, String moduleName) {
      dashboardPage.navigateTabAndModule(tabName,moduleName);
    }

    @Then("The user should be able to see all tabs that shown on the page")
    public void theUserShouldBeAbleToSeeAllTabsThatShownOnThePage(List<String> expectedTabNames) {
     //   List<WebElement> actualTabElements = dashboardPage.tabNames;
        List<String> actualTabNames = BrowserUtils.getElementsText(dashboardPage.tabNames);
        Assert.assertTrue(actualTabNames.containsAll(expectedTabNames));
        List<String> actualTabNames2 = BrowserUtils.getElementsText(By.cssSelector("nav>ul>li"));

        System.out.println("expectedTabNames = " + expectedTabNames);
        System.out.println("actualTabNames = " + actualTabNames);
        System.out.println("actualTabNames2 = " + actualTabNames2);

    }
}
