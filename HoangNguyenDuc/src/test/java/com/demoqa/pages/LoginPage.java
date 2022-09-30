package com.demoqa.pages;

import java.util.Map;

public class LoginPage extends BasePage {
    public void addLoginCookies(Map<String, String> loginCookies ){
        for(Map.Entry<String, String> entry : loginCookies.entrySet()){
            addCookies(entry.getKey(),entry.getValue());
        }
    }
}
