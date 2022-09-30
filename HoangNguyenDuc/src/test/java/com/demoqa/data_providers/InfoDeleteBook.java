package com.demoqa.data_providers;

import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static com.demoqa.constants.FilePathConstants.PARAM_DELETE_BOOK_FILE_PATH;
import static com.demoqa.utils.JsonUtil.loadJsonFile;

public class InfoDeleteBook {

    static JsonObject paramDeleteBook;
    {
        try {
            paramDeleteBook = loadJsonFile(PARAM_DELETE_BOOK_FILE_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public String getUsername(){
        return paramDeleteBook.get("username").getAsString();
    }
    public String getPassword(){
        return paramDeleteBook.get("password").getAsString();
    }
    public String getUserID(){
        return paramDeleteBook.get("userId").getAsString();
    }
    public String getIsbn(){
        return paramDeleteBook.get("isbn").getAsString();
    }
    public Map<String, String> loginParameterCookies(String userToken, String expires){
        Map<String, String> parameterCookies = new HashMap<>();
        parameterCookies.put("userName",getUsername());
        parameterCookies.put("userID", getUserID());
        parameterCookies.put("token",userToken);
        parameterCookies.put("expires", expires);
        return parameterCookies;
    }
}
