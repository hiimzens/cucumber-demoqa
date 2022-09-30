package com.demoqa.steps;

import com.demoqa.context.ScenarioContext;
import com.demoqa.pages.BasePage;
import com.demoqa.pages.BookDetailPage;
import com.demoqa.pages.BookStorePage;
import com.demoqa.pages.ProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.awt.*;
import static com.demoqa.constants.UrlConstants.BOOK_STORE_URL;
import static com.demoqa.constants.UrlConstants.PROFILE_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddBookStep {

    BookStorePage bookStorePage = new BookStorePage();
    BookDetailPage bookDetailPage = new BookDetailPage();
    ProfilePage profilePage = new ProfilePage();
    ScenarioContext scenarioContext;

    public AddBookStep(ScenarioContext context){
        scenarioContext = context;
    }

    @Given("User is on Book Store Page")
    public void userIsOnBookStorePage() {
        BasePage.navigate(PROFILE_URL);
        profilePage.deleteBookImmediately("Git Pocket Guide");
        BasePage.navigate(BOOK_STORE_URL);
    }

    @When("User select a book named {string}")
    public void userSelectABookNamed(String bookName) {
        bookStorePage.inputQuerySearch(bookName);
        bookStorePage.clickBookLink(bookName);
        scenarioContext.setContext("bookName", bookName);
    }

    @And("User click on {string} add button")
    public void userClickOnAddButton(String buttonAddName) throws AWTException {
        BasePage.zoomOut();
        bookDetailPage.clickAddButton(buttonAddName);
    }
    @Then("an alert {string} is shown")
    public void anAlertIsShown(String successfullyAddMessage) {
        assertThat("Verify successfully add message", bookDetailPage.getTextOfAlert(), equalTo(successfullyAddMessage));
        bookDetailPage.clickOKButtonOfAlert();
    }

    @And("Book is shown on user profile")
    public void bookIsShownOnUserProfile() {
        BasePage.navigate(PROFILE_URL);
        String bookName = scenarioContext.getContext("bookName", String.class);
        boolean searchResult = profilePage.isProfileHaveBook(bookName);
        assertThat("Verify added book", searchResult, equalTo(true));
    }
}
