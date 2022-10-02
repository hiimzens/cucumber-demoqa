package com.demoqa.pages;

import org.openqa.selenium.By;
import java.util.List;
public class ProfilePage extends BasePage {
    private static final String LNK_PROFILE_BOOK_XPATH = "//div[@class='action-buttons']//a[text()='%s']";
    private static final By TXT_SEARCH_BAR = By.id("searchBox");
    private static final By BTN_CONFIRM_DELETE = By.id("closeSmallModal-ok");
    private static final String BTN_DELETE_BOOK_XPATH = "//a[text()='%s']/ancestor::div[@role='rowgroup']//child::span[@title='Delete']";

    public By getDeleteButton(String bookName){
        return formatXpath(BTN_DELETE_BOOK_XPATH,bookName);
    }
    public void inputQuerySearch(String bookName){
        inputText(TXT_SEARCH_BAR,bookName);
    }

    public boolean isBookShown(String bookParameter){
        By LNK_PROFILE_BOOK = formatXpath(LNK_PROFILE_BOOK_XPATH, bookParameter);
        return isElementDisplayed(LNK_PROFILE_BOOK);
    }
    public void deleteBookSuccessfully(String bookParameter){
        clickElement(getDeleteButton(bookParameter));
    }
    public void clickConfirmDelete(){
        clickElement(BTN_CONFIRM_DELETE);
    }
}
