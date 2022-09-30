package com.demoqa.models;

public class StudentInfo {
    public StudentInfo(String firstName, String lastName, String email, String gender, String mobile, String dateOfBirth, String subjects, String hobby, String picture, String currentAddress, String state, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
        this.subjects = subjects;
        this.hobby = hobby;
        this.picture = picture;
        this.currentAddress = currentAddress;
        this.state = state;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
    public String getMobile() {
        return mobile;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSubjects() {
        return subjects;
    }
    public String getHobby() {
        return hobby;
    }

    public String getPicture() {
        return picture;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }


    public String getState() {
        return state;
    }


    public String getCity() {
        return city;
    }


    public String firstName;
    public String lastName;
    public String email;
    public String gender;
    public String mobile;
    public String dateOfBirth;
    public String subjects;
    public String hobby;
    public String picture;
    public String currentAddress;
    public String state;
    public String city;

}
