package com.demoqa.steps;

import com.demoqa.data_providers.InfoAddBook;
import com.demoqa.data_providers.InfoDeleteBook;
import com.demoqa.pages.BasePage;
import com.demoqa.pages.LoginPage;
import com.demoqa.utils.api.helper.AccountHelper;
import io.cucumber.java.en.Given;

import java.util.List;

import static com.demoqa.constants.UrlConstants.LOGIN_URL;


public class LoginStep {

    InfoAddBook infoAddBook = new InfoAddBook();
    LoginPage loginPage = new LoginPage();
    AccountHelper accountHelper = new AccountHelper();
    InfoDeleteBook infoDeleteBook = new InfoDeleteBook();
    public static String userTokenDelete;


    @Given("User want to add book logged in to the application")
    public void userWantToAddBookLoggedInToTheApplication() {
        BasePage.navigate(LOGIN_URL);
        List<String> tokenAndExpires = accountHelper.generateToken(infoAddBook.getUsername(), infoAddBook.getPassword());
        String addBookUserToken = tokenAndExpires.get(0);
        String expires = tokenAndExpires.get(1);
        loginPage.addLoginCookies(infoAddBook.loginParameterCookies(addBookUserToken,expires));
    }

    @Given("User want to delete book logged in to the application")
    public void userWantToDeleteBookLoggedInToTheApplication() {
        BasePage.navigate(LOGIN_URL);
        List<String> tokenAndExpires = accountHelper.generateToken(infoDeleteBook.getUsername(), infoDeleteBook.getPassword());
        userTokenDelete = tokenAndExpires.get(0);
        String expires = tokenAndExpires.get(1);
        loginPage.addLoginCookies(infoDeleteBook.loginParameterCookies(userTokenDelete,expires));
    }
}
