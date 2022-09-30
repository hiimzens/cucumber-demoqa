package com.demoqa.steps;

import com.demoqa.context.ScenarioContext;
import com.demoqa.models.StudentInfo;
import com.demoqa.pages.RegisteredStudentForm;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.text.ParseException;

import static com.demoqa.utils.DateUtils.convertSubDateToDate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegisteredStudentFormStep {

    RegisteredStudentForm registeredStudentForm = new RegisteredStudentForm();
    ScenarioContext scenarioContext;

    public RegisteredStudentFormStep(ScenarioContext context){
        scenarioContext = context;
    }
    @Then("a form appear show the input information")
    public void aFormAppearShowTheInputInformation() {
        StudentInfo studentInfo = scenarioContext.getContext("studentInfo",StudentInfo.class);
        assertThat("Verify student name", registeredStudentForm.getRegisteredFullName(), equalTo(studentInfo.getFirstName()+ " " + studentInfo.getLastName()));
        assertThat("Verify email", registeredStudentForm.getRegisteredEmail(), equalTo(studentInfo.getEmail()));
        assertThat("Verify gender", registeredStudentForm.getRegisteredGender(), equalTo(studentInfo.getGender()));
        assertThat("Verify mobile", registeredStudentForm.getRegisteredMobile(), equalTo(studentInfo.getMobile()));
        assertThat("Verify dateOfBirth", registeredStudentForm.getRegisteredDateOfBirth(), equalTo(studentInfo.getDateOfBirth()));
        assertThat("Verify subjects", registeredStudentForm.getRegisteredSubject(), equalTo(studentInfo.getSubjects()));
        assertThat("Verify hobbies", registeredStudentForm.getRegisteredHobby(), equalTo(studentInfo.getHobby()));
        assertThat("Verify picture", registeredStudentForm.getRegisteredPicture(), equalTo(studentInfo.getPicture()));
        assertThat("Verify currentAddress", registeredStudentForm.getRegisteredAddress(), equalTo(studentInfo.getCurrentAddress()));
        if(!studentInfo.getState().equals("")){
            assertThat("Verify state and city", registeredStudentForm.getRegisteredStateAndCity(), equalTo(studentInfo.getState()+ " " + studentInfo.getCity()));
        }else assertThat("Verify state and city", registeredStudentForm.getRegisteredStateAndCity(), equalTo(""));

    }

    @And("a form appear show the mandatory input information")
    public void aFormAppearShowTheMandatoryInputInformation() throws ParseException {
        String firstName = scenarioContext.getContext("firstName", String.class);
        String lastName = scenarioContext.getContext("lastName", String.class);
        String gender = scenarioContext.getContext("gender", String.class);
        String mobile = scenarioContext.getContext("mobile", String.class);
        String dateOfBirth = scenarioContext.getContext("dateOfBirth", String.class);
        assertThat("Verify student name", registeredStudentForm.getRegisteredFullName(), equalTo(firstName+ " " + lastName));
        assertThat("Verify gender", registeredStudentForm.getRegisteredGender(), equalTo(gender));
        assertThat("Verify mobile", registeredStudentForm.getRegisteredMobile(), equalTo(mobile));
        assertThat("Verify dateOfBirth", registeredStudentForm.getRegisteredDateOfBirth(), equalTo(convertSubDateToDate(dateOfBirth)));
    }

    @Then("a successful message {string} is shown")
    public void aSuccessfulMessageIsShown(String thankYouMessage) {
        assertThat("Verify message", registeredStudentForm.getSubmittedMessage(), equalTo(thankYouMessage));
    }
}
