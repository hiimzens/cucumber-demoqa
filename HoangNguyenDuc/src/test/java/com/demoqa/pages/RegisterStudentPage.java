package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class RegisterStudentPage extends BasePage {
    /**---------------------------Register Form------------------------------------------*/

    private static final By TXT_FIRST_NAME = By.id("firstName");
    private static final By TXT_LAST_NAME = By.id("lastName");
    private static final By TXT_EMAIL = By.id("userEmail");
    private static final String RDO_GENDER_XPATH = "//label[contains(text(),'%s')]";
    private static final By TXT_MOBILE_NUMBER = By.id("userNumber");
    private static final By DTP_DATE_OF_BIRTH = By.id("dateOfBirthInput");
    private static final By DDL_YEAR_OF_BIRTH = By.xpath("//select[contains(@class,'year-select')]");
    private static final By DDL_MONTH_OF_BIRTH = By.xpath("//select[contains(@class,'month-select')]");
    private static final String OPT_DAY_OF_BIRTH_XPATH = "//div[contains(@aria-label,'month')]//div[contains(@class,'day') and text()='%s']";
    private static final By TXT_SUBJECTS = By.id("subjectsInput");
    private static final String OPT_SUBJECTS_XPATH = "//div[@id='subjectsContainer']//div[text()='%s' and @id]";
    private static final String CHK_HOBBIES_XPATH = "//label[contains(@for,'hobbies') and contains(text(),'%s')]";
    private static final By BTN_UPLOAD_PICTURE = By.cssSelector("input[id=uploadPicture]");
    private static final By TXA_CURRENT_ADDRESS = By.id("currentAddress");
    private static final By DDL_STATE = By.xpath("//div[@id='state']//div[text()='Select State']");

    private static final String OPT_STATE_XPATH = "//div[@id='state']//div[contains(@id,'select') and text()='%s']";
    private static final By DDL_CITY = By.xpath("//div[@id='city']//div[text()='Select City']");
    private static final String OPT_CITY_XPATH = "//div[@id='city']//div[contains(@id,'select') and text()='%s']";
    private static final By BTN_SUBMIT = By.id("submit");

    /**---------------------------Register Method------------------------------------------*/

    public void inputFirstName (String firstName){
        inputText(TXT_FIRST_NAME, firstName);
    }
    public void inputLastName (String lastName){
        inputText(TXT_LAST_NAME, lastName);
    }
    public void inputEmail (String email){
        inputText(TXT_EMAIL,email);
    }
    public void selectGender(String genderParameter){
        By RDO_GENDER = formatXpath(RDO_GENDER_XPATH,genderParameter);
        clickElement(RDO_GENDER);
    }
    public void inputPhoneNumber(String phoneNumber){
        inputText(TXT_MOBILE_NUMBER,phoneNumber);
    }
    public String getDefaultDob(){
        WebElement dobField = findElement(DTP_DATE_OF_BIRTH);
        return dobField.getAttribute("value");
    }
    public void selectDateOfBirth(String dateOfBirth) {
        clickElement(DTP_DATE_OF_BIRTH);
        String[] dateParts = dateOfBirth.split(" ");
        selectOptionByText(DDL_YEAR_OF_BIRTH, dateParts[2]);
        selectOptionByText(DDL_MONTH_OF_BIRTH, dateParts[1]);
        By OPT_DAY_OF_BIRTH = formatXpath(OPT_DAY_OF_BIRTH_XPATH, dateParts[0]);
        clickElement(OPT_DAY_OF_BIRTH);
    }
    public void inputSubject(List<String> listSubjectParameter){
        for (String subjectParameter: listSubjectParameter) {
            inputText(TXT_SUBJECTS, subjectParameter);
            By OPT_SUBJECTS = formatXpath(OPT_SUBJECTS_XPATH,subjectParameter);
            clickElement(OPT_SUBJECTS);
        }
    }
    public void selectHobby(String hobby){
        By CHK_HOBBIES = formatXpath(CHK_HOBBIES_XPATH,hobby);
        clickElement(CHK_HOBBIES);
    }
    public void inputPicturePath(String picturePath){
        inputText(BTN_UPLOAD_PICTURE,picturePath);
    }
    public void inputCurrentAddress(String currentAddress){
        inputText(TXA_CURRENT_ADDRESS,currentAddress);
    }
    public void selectState(String stateParameter){
        By OPT_STATE = formatXpath(OPT_STATE_XPATH,stateParameter);
        selectDropdownValue(DDL_STATE, OPT_STATE);
    }
    public void selectCity(String cityParameter){
        By OPT_CITY = formatXpath(OPT_CITY_XPATH,cityParameter);
        selectDropdownValue(DDL_CITY, OPT_CITY);
    }
    public void clickSubmitBTN() {
        clickElement(BTN_SUBMIT);
    }

}
