package com.demoqa.utils.api.helper;

import com.demoqa.utils.api.APIConstants;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static com.demoqa.utils.api.APIConstants.ACCOUNT_PREFIX;
import static com.demoqa.utils.api.APIConstants.LOGIN_ENDPOINT;

public class AccountHelper extends RequestHelper {

    public JsonPath getLoginRespond(String baseURI , String username, String password) {
        String url = baseURI + ACCOUNT_PREFIX + LOGIN_ENDPOINT;
        JsonObject body = new JsonObject();
        body.addProperty("userName", username);
        body.addProperty("password", password);
        Response response = sendRequest(
                APIConstants.RequestType.POST,
                url,
                null,
                body.toString()
        );
        return response.jsonPath();
    }
}
