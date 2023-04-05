package com.krafttech.steps_defs;

import com.krafttech.pages.AddEducationPage;
import com.krafttech.pages.AddExperiencePage;
import com.krafttech.pages.OverviewPage;
import com.krafttech.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class MyProfile_StepDefs {
    OverviewPage overviewPage=new OverviewPage();
    AddEducationPage addEducationPage=new AddEducationPage();

    AddExperiencePage addExperiencePage=new AddExperiencePage();
    @Then("The user should be able to see overview page")
    public void theUserShouldBeAbleToSeeOverviewPage() {
        Assert.assertTrue(overviewPage.overviewPageSubTitle.isDisplayed());
    }

    @When("The user navigate to my profile tab: {string}")
    public void theUserNavigateToMyProfileTab(String tabName) {
        overviewPage.navigateUserProfileTabs(tabName);
    }

    @Then("The user should be able to see add education page")
    public void theUserShouldBeAbleToSeeAddEducationPage() {
        BrowserUtils.waitForVisibility(addEducationPage.addEducationBtn,5);
        Assert.assertTrue(addEducationPage.addEducationBtn.isDisplayed());
    }

    @When("The user fill the form with the followings {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserFillTheFormWithTheFollowings(String schoolName, String degree, String study, String fromDate, String toDate, String description) {
    addEducationPage.addEducation(schoolName,degree,study,fromDate,toDate,description);
    }

    @Then("The user should see added education record with school name :{string}")
    public void theUserShouldSeeAddedEducationRecordWithSchoolName(String expectedSchoolName) {
        String actualSchoolName = overviewPage.addedEducationName(expectedSchoolName);
        Assert.assertEquals("should be same and visible on the page",expectedSchoolName,actualSchoolName);
    }

    @And("The user should be able to delete education record with school name :{string}")
    public void theUserShouldBeAbleToDeleteEducationRecordWithSchoolName(String schoolName) {
        overviewPage.deleteEducation(schoolName);
    }

    @When("The user fill the form with the following list")
    public void theUserFillTheFormWithTheFollowingList(List<String> educationInfos) {
        addEducationPage.addEducation(educationInfos.get(0),educationInfos.get(1),educationInfos.get(2),educationInfos.get(3),
                educationInfos.get(4),educationInfos.get(5));
    }

    @Then("The user should be able to see related page with submit button: {string} page")
    public void theUserShouldBeAbleToSeeRelatedPageWithSubmitButtonPage(String profileTabsSubmitBtn) {
        overviewPage.assertProfileTabs(profileTabsSubmitBtn);
    }

    @When("The user fill the add experience form with {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserFillTheAddExperienceFormWith(String jobTitle, String company, String location, String fromDate, String toDate, String jobDescription) {
        addExperiencePage.addExperienceWithParameterMtd(jobTitle,company,location,fromDate,toDate,jobDescription);
    }

    @Then("The user should be able see last added experience with {string}")
    public void theUserShouldBeAbleSeeLastAddedExperienceWith(String jobTitle) {
        String actualJobTitle = overviewPage.addedExperienceName(jobTitle);
        Assert.assertEquals("should be same",jobTitle,actualJobTitle);
    }
}
