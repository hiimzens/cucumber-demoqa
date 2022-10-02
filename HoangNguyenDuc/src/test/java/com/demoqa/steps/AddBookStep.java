package com.demoqa.steps;

import com.beust.ah.A;
import com.demoqa.context.ScenarioContext;
import com.demoqa.pages.BasePage;
import com.demoqa.pages.BookDetailPage;
import com.demoqa.pages.BookStorePage;
import com.demoqa.pages.ProfilePage;
import com.demoqa.utils.api.helper.AccountHelper;
import com.demoqa.utils.api.helper.BookHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.awt.*;
import static com.demoqa.constants.UrlConstants.BOOK_STORE_URL;
import static com.demoqa.constants.UrlConstants.PROFILE_URL;
import static com.demoqa.steps.StepHooks.baseURI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddBookStep {

    BookStorePage bookStorePage = new BookStorePage();
    BookDetailPage bookDetailPage = new BookDetailPage();

    BookHelper bookHelper = new BookHelper();
    ProfilePage profilePage = new ProfilePage();
    AccountHelper accountHelper = new AccountHelper();
    ScenarioContext scenarioContext;

    public AddBookStep(ScenarioContext context){
        scenarioContext = context;
    }

    @Given("User is on Book Store Page")
    public void userIsOnBookStorePage() {
        BasePage.navigate(BOOK_STORE_URL);
    }

    @When("User select a book named {string}")
    public void userSelectABookNamed(String bookName) {
        String userID = scenarioContext.getContext("userID", String.class);
        String userToken = scenarioContext.getContext("userToken",String.class);
        bookHelper.deleteAllBook(baseURI, userID, userToken);
        bookStorePage.inputQuerySearch(bookName);
        bookStorePage.clickBookLink(bookName);
        scenarioContext.setContext("bookName", bookName);
    }

    @And("User click on {string} add button")
    public void userClickOnAddButton(String buttonAddName) throws AWTException {
        BasePage.zoomOut();
        BasePage.scrollToPageBottom();
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
        profilePage.inputQuerySearch(bookName);
        boolean searchResult = profilePage.isBookShown(bookName);
        assertThat("Verify added book", searchResult, equalTo(true));
    }
}
