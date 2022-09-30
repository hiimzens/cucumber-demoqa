package com.demoqa.pages;

import org.openqa.selenium.By;

public class BookDetailPage extends BasePage {
    private static final String BTN_ADD_TO_COLLECTION_XPATH = "//button[text()='%s']";

    public void clickAddButton(String addButtonText) {
        By btnAddToCollection = formatXpath(BTN_ADD_TO_COLLECTION_XPATH, addButtonText);
        clickElement(btnAddToCollection);
    }
}
