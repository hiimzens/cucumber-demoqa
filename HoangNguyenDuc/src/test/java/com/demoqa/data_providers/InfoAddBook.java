package com.demoqa.data_providers;

import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import static com.demoqa.constants.FilePathConstants.PARAM_ADD_BOOK_FILE_PATH;
import static com.demoqa.utils.JsonUtil.loadJsonFile;

public class InfoAddBook {
    static JsonObject paramAddBook;
    {
        try {
            paramAddBook = loadJsonFile(PARAM_ADD_BOOK_FILE_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUsername() {
        return paramAddBook.get("username").getAsString();
    }

    public String getPassword() {
        return paramAddBook.get("password").getAsString();
    }

    public String getUserID() {
        return paramAddBook.get("userId").getAsString();
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