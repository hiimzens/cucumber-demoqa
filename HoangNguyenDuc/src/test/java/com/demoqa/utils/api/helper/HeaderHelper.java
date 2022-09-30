package com.demoqa.utils.api.helper;

import java.util.HashMap;
import java.util.Map;

public class HeaderHelper {
    static Map<String, String> headers = new HashMap<>();
    public static Map<String, String> getAuthorizationHeaders(String token){
        headers.put("Content-Type","application/json");
        headers.put("authorization","Bearer " + token );
        return headers;
    }
}
