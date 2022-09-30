package com.demoqa.steps;

import com.demoqa.context.ScenarioContext;
import com.demoqa.models.StudentInfo;
import com.demoqa.pages.BasePage;
import com.demoqa.pages.RegisterStudentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.demoqa.constants.UrlConstants.STUDENT_REGISTRATION_URL;
import static com.demoqa.data_providers.StudentData.studentImageAsbPath;
import static com.demoqa.utils.DateUtils.convertSubDateToDate;

public class RegisterStudentStep {
    RegisterStudentPage registerStudentPage = new RegisterStudentPage();
    ScenarioContext scenarioContext;

    public RegisterStudentStep(ScenarioContext context){
        scenarioContext = context;
    }
    @Given("User is in register student page")
    public void userIsInRegisterStudentPage() {
        BasePage.navigate(STUDENT_REGISTRATION_URL);
    }

    @When("the user input information below to all fields to register form")
    public void theUserInputInformationBelowToAllFieldsToRegisterForm(List<Map<String, String>> table) throws ParseException, AWTException {
        String firstName = table.get(0).get("firstName");
        String lastName = table.get(0).get("lastName");
        String email = table.get(0).get("email");
        String gender = table.get(0).get("gender");
        String mobile = table.get(0).get("mobile");
        String dateOfBirth = table.get(0).get("dateOfBirth");
        String rawSubjects = table.get(0).get("subjects");
        String hobby = table.get(0).get("hobby");
        String picture = table.get(0).get("picture");
        String currentAddress = table.get(0).get("currentAddress");
        String state = table.get(0).get("state");
        String city = table.get(0).get("city");
        BasePage.zoomOut();
        if(firstName != null) {
            registerStudentPage.inputFirstName(firstName);
        }
        if(lastName!=null) registerStudentPage.inputLastName(lastName);
        if(email!=null) registerStudentPage.inputEmail(email);
        else email= "";
        if(gender!=null) registerStudentPage.selectGender(gender);
        if(mobile!=null) registerStudentPage.inputPhoneNumber(mobile);
        if(dateOfBirth!=null) {
            registerStudentPage.selectDateOfBirth(dateOfBirth);
        }
        else dateOfBirth = convertSubDateToDate(registerStudentPage.getDefaultDob());
        if(rawSubjects!=null){
            List<String> listSubject = new ArrayList<>(Arrays.asList(rawSubjects.split(", ")));
            registerStudentPage.inputSubject(listSubject);
        }
        else rawSubjects = "";
        BasePage.scrollToPageBottom();
        if(hobby!=null) registerStudentPage.selectHobby(hobby);
        else hobby = "";
        if(picture !=null) registerStudentPage.inputPicturePath(studentImageAsbPath);
        else picture = "";
        if(currentAddress !=null) registerStudentPage.inputCurrentAddress(currentAddress);
        else currentAddress = "";
        if(state !=null) registerStudentPage.selectState(state);
        else state = "";
        if(city !=null) registerStudentPage.selectCity(city);
        else city = "";

        scenarioContext.setContext("studentInfo", new StudentInfo(firstName,lastName,email,
                gender,mobile, dateOfBirth,rawSubjects,hobby,picture,currentAddress,state,city));
    }
    @And("the user click on submit button")
    public void theUserClickOnSubmitButton() {
        registerStudentPage.clickSubmitBTN();
    }

    @When("the user input information below to mandatory fields to register form")
    public void theUserInputInformationBelowToMandatoryFieldsToRegisterForm(List<Map<String, String>> table) throws AWTException {
        String firstName = table.get(0).get("firstName");
        String lastName = table.get(0).get("lastName");
        String gender = table.get(0).get("gender");
        String mobile = table.get(0).get("mobile");
        BasePage.zoomOut();
        registerStudentPage.inputFirstName(firstName);
        registerStudentPage.inputLastName(lastName);
        registerStudentPage.selectGender(gender);
        registerStudentPage.inputPhoneNumber(mobile);
        String defaultDob = registerStudentPage.getDefaultDob();
        scenarioContext.setContext("firstName", firstName);
        scenarioContext.setContext("lastName", lastName);
        scenarioContext.setContext("gender",gender);
        scenarioContext.setContext("mobile", mobile);
        scenarioContext.setContext("dateOfBirth", defaultDob);
    }
}
