package com.demoqa.steps;

import com.demoqa.context.ScenarioContext;
import com.demoqa.pages.BasePage;
import com.demoqa.pages.BookStorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static com.demoqa.constants.UrlConstants.BOOK_STORE_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SearchBookStep {
    ScenarioContext scenarioContext;

    public SearchBookStep(ScenarioContext context){
        scenarioContext = context;
    }
    BookStorePage bookStorePage = new BookStorePage();
    @Given("The user is on Book Store Page")
    public void theUserIsOnBookStorePage() {
        BasePage.navigate(BOOK_STORE_URL);
    }

    @When("User inputs book name")
    public void userInputsBookName(List<Map<String, String>> table) {
        String bookNameQuery = table.get(0).get("bookName");
        bookStorePage.inputQuerySearch(bookNameQuery);
        scenarioContext.setContext("bookName", bookNameQuery);
    }

    @Then("all books match with input criteria will be displayed.")
    public void allBooksMatchWithInputCriteriaWillBeDisplayed() {
        String bookNameQuery = scenarioContext.getContext("bookName", String.class);
        boolean searchResult = bookStorePage.isSearchResultCorrect(bookNameQuery);
        assertThat("Verify search result", searchResult, equalTo(true));
    }
}
