package com.demoqa.pages;


public class LoginPage extends BasePage{
    public void addCookiesParameterUserName(String username){
        addCookies("username",username);
    }
    public void addCookiesParameterUserID(String userID){
        addCookies("userID",userID);
    }
    public void addCookiesParameterToken(String userToken){
        addCookies("token",userToken);
    }
    public void addCookiesParameterExpires(String expires){
        addCookies("expires",expires);
    }
}
