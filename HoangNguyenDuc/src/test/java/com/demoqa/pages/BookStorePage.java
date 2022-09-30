package com.demoqa.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import java.util.List;

public class BookStorePage extends BasePage{
    private static final String LNK_BOOK_XPATH = "//a[text()='%s']";
    private static final By TXT_SEARCH_BAR = By.id("searchBox");
    private static final By LNK_BOOKS_OF_STORE = By.cssSelector("div[class ='action-buttons'] a");

    public void clickBookLink(String bookName){
        By LNK_BOOK = formatXpath(LNK_BOOK_XPATH,bookName);
        clickElement(LNK_BOOK);
    }
    public void inputQuerySearch(String bookName){
        inputText(TXT_SEARCH_BAR,bookName);
    }
    public List<String> findBookElement(){
        return getTextOfElements(LNK_BOOKS_OF_STORE,true);
    }
    public boolean isSearchResultCorrect(String bookName){
        List<String> searchResults = findBookElement();
        for(String searchResult: searchResults){
           if(!StringUtils.containsIgnoreCase(searchResult,bookName)){
                return false;
            }
        }
        return true;
    }
}
