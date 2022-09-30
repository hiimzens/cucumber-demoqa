package com.demoqa.pages;

import org.openqa.selenium.By;
import java.util.List;
public class ProfilePage extends BasePage {
    private static final By LNK_PROFILE_BOOKS = By.xpath("//div[@class='action-buttons']//a");
    private static final By BTN_NEXT = By.xpath("//button[text()='Next']");
    private static final By TXT_SEARCH_BAR = By.id("searchBox");
    private static final By LBL_TOTAL_PAGES = By.className("-totalPages");
    private static final By BTN_CONFIRM_DELETE = By.id("closeSmallModal-ok");
    private static final String BTN_DELETE_BOOK_XPATH = "//a[text()='%s']/ancestor::div[@role='rowgroup']//child::span[@title='Delete']";

    public int getTotalPages(){
        return Integer.parseInt(getText(LBL_TOTAL_PAGES));
    }

    public By getDeleteButton(String bookName){
        return formatXpath(BTN_DELETE_BOOK_XPATH,bookName);
    }
    public void clickNextBtn(){
        while (checkEnabledButton(BTN_NEXT)){
            scrollToPageBottom();
            clickElement(BTN_NEXT);
        }
    }
    public void inputQuerySearch(String bookName){
        inputText(TXT_SEARCH_BAR,bookName);
    }
    public boolean isProfileHaveBook(String bookParameter){
        for(int i = 0; i < getTotalPages();i++){
            List<String> books = getTextOfElements(LNK_PROFILE_BOOKS,true);
            for (String book : books) {
                if(book.equals(bookParameter)){
                    return true;
                }
            }
            clickNextBtn();
        }
        return false;
    }
    public void deleteBookSuccessfully(String bookParameter){
        for(int i = 0; i < getTotalPages();i++){
            List<String> books = getTextOfElements(LNK_PROFILE_BOOKS,true);
            for (String book : books) {
                if (book.equals(bookParameter)) {
                    clickElement(getDeleteButton(bookParameter));
                    return;
                }
            }
            clickNextBtn();
        }
    }
    public void deleteBookImmediately(String bookName) {
        for(int i = 0; i < getTotalPages();i++) {
            List<String> books = getTextOfElements(LNK_PROFILE_BOOKS, true);
            scrollToPageBottom();
            for (String book : books) {
                if (book.equals(bookName)) {
                    clickElement(getDeleteButton(bookName));
                    clickConfirmDelete();
                    clickOKButtonOfAlert();
                    return;
                }
            }
            clickNextBtn();
        }
    }
    public void clickConfirmDelete(){
        clickElement(BTN_CONFIRM_DELETE);
    }
}
