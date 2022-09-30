package com.demoqa.pages;

import org.openqa.selenium.By;

public class RegisteredStudentForm extends BasePage{
    private static final By LBL_SUBMITTED_MESSAGE = By.xpath("//div[contains(text(),'submit')]");
    private static final By LBL_FULL_NAME = By.xpath("//td[text()='Student Name']/following-sibling::td");
    private static final By LBL_STUDENT_EMAIL = By.xpath("//td[text()='Student Email']/following-sibling::td");
    private static final By LBL_GENDER = By.xpath("//td[text()='Gender']//following-sibling::td");
    private static final By LBL_MOBILE = By.xpath("//td[text()='Mobile']/following-sibling::td");
    private static final By LBL_DATE_OF_BIRTH = By.xpath("//td[text()='Date of Birth']/following-sibling::td");
    private static final By LBL_SUBJECTS = By.xpath("//td[text()='Subjects']/following-sibling::td");
    private static final By LBL_HOBBIES = By.xpath("//td[text()='Hobbies']/following-sibling::td");
    private static final By LBL_PICTURE = By.xpath("//td[text()='Picture']/following-sibling::td");
    private static final By LBL_ADDRESS = By.xpath("//td[text()='Address']/following-sibling::td");
    private static final By LBL_STATE_AND_CITY = By.xpath("//td[text()='State and City']/following-sibling::td");

    public String getSubmittedMessage(){
        return getText(LBL_SUBMITTED_MESSAGE);
    }
    public String getRegisteredFullName(){
        return getText(LBL_FULL_NAME);
    }
    public String getRegisteredEmail(){
        return getText(LBL_STUDENT_EMAIL);
    }
    public String getRegisteredGender(){
        return getText(LBL_GENDER);
    }
    public String getRegisteredMobile(){
        return getText(LBL_MOBILE);
    }
    public String getRegisteredDateOfBirth(){
        String dateOfBirth = getText(LBL_DATE_OF_BIRTH);
        return dateOfBirth.replace(",", " ");
    }
    public String getRegisteredSubject(){
        return getText(LBL_SUBJECTS);
    }
    public String getRegisteredHobby(){
        return getText(LBL_HOBBIES);
    }
    public String getRegisteredPicture(){
        return getText(LBL_PICTURE);
    }
    public String getRegisteredAddress(){
        return getText(LBL_ADDRESS);
    }
    public String getRegisteredStateAndCity(){
        return getText(LBL_STATE_AND_CITY);
    }
}
