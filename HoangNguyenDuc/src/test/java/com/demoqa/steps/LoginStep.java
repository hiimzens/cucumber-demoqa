package com.demoqa.steps;

import com.demoqa.context.ScenarioContext;
import com.demoqa.pages.BasePage;
import com.demoqa.pages.LoginPage;
import com.demoqa.utils.api.helper.AccountHelper;
import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import java.io.FileNotFoundException;
import static com.demoqa.constants.FilePathConstants.ACCOUNT_INFO;
import static com.demoqa.constants.UrlConstants.LOGIN_URL;
import static com.demoqa.steps.StepHooks.baseURI;
import static com.demoqa.utils.JsonUtil.loadJsonFile;


public class LoginStep {

    AccountHelper accountHelper = new AccountHelper();
    ScenarioContext scenarioContext;
    LoginPage loginPage = new LoginPage();
    public LoginStep(ScenarioContext context){
        scenarioContext = context;
    }

    @Given("User {string} logged in to the application")
    public void userLoggedInToTheApplication(String purpose) throws FileNotFoundException {
        BasePage.navigate(LOGIN_URL);
        JsonObject accountsObject = loadJsonFile(ACCOUNT_INFO);
        JsonObject accountLogin = switch (purpose) {
            case "add" -> accountsObject.get("userAdd").getAsJsonObject();
            case "delete" -> accountsObject.get("userDelete").getAsJsonObject();
            default -> new JsonObject();
        };
        String username = accountLogin.get("username").getAsString();
        String password = accountLogin.get("password").getAsString();
        JsonPath session = accountHelper.getLoginRespond(baseURI, username, password);
        String userToken = session.getString("token");
        String userID = session.getString("userId");
        loginPage.addCookiesParameterUserName(username);
        loginPage.addCookiesParameterToken(userToken);
        loginPage.addCookiesParameterUserID(userID);
        loginPage.addCookiesParameterExpires(session.getString("expires"));
        scenarioContext.setContext("userID",userID);
        scenarioContext.setContext("userToken", userToken);
    }
}
