package com.demoqa.steps;

import com.demoqa.context.ScenarioContext;
import com.demoqa.data_providers.InfoDeleteBook;
import com.demoqa.pages.BasePage;
import com.demoqa.pages.ProfilePage;
import com.demoqa.utils.api.helper.BookHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.demoqa.constants.UrlConstants.PROFILE_URL;
import static com.demoqa.steps.LoginStep.userTokenDelete;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteBookStep {
    InfoDeleteBook infoDeleteBook = new InfoDeleteBook();
    ProfilePage profilePage = new ProfilePage();
    BookHelper bookHelper = new BookHelper();
    ScenarioContext scenarioContext;

    public DeleteBookStep(ScenarioContext context){
        scenarioContext = context;
    }

    @Given("There is a book named {string}")
    public void thereIsABookNamed(String bookName) {
        System.out.println("Delete book for precondition:" + bookName);
        bookHelper.addBook(infoDeleteBook.getUserID(), userTokenDelete, infoDeleteBook.getIsbn());
    }
    @And("User is on profile page")
    public void userIsOnProfilePage() {
        BasePage.navigate(PROFILE_URL);
    }

    @When("The user search book {string}")
    public void theUserSearchBook(String bookName) {
        profilePage.inputQuerySearch(bookName);
        scenarioContext.setContext("bookName", bookName);
    }

    @And("The user clicks on Delete icon")
    public void theUserClicksOnDeleteIcon() {
        String bookName = scenarioContext.getContext("bookName", String.class);
        profilePage.deleteBookSuccessfully(bookName);
    }

    @And("The user click on OK button")
    public void theUserClickOnOKButton() {
        profilePage.clickConfirmDelete();
    }

    @Then("the user clicks on OK button of alert {string}")
    public void theUserClicksOnOKButtonOfAlert(String successfullyDeleteMessage) {
        String actualMessage = profilePage.getTextOfAlert();
        assertThat("Verify successfully delete message", actualMessage, equalTo(successfullyDeleteMessage));
        profilePage.clickOKButtonOfAlert();
    }

    @And("The book is not shown")
    public void theBookIsNotShown() {
        String bookName = scenarioContext.getContext("bookName", String.class);
        boolean searchResult = profilePage.isProfileHaveBook(bookName);
        assertThat("Verify delete book on profile page", searchResult, equalTo(false));
    }
}
