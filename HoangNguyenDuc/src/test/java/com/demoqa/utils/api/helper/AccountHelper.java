package com.demoqa.utils.api.helper;

import com.demoqa.utils.api.APIConstants;
import com.google.gson.JsonObject;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.demoqa.utils.api.APIConstants.ACCOUNT_PREFIX;

public class AccountHelper extends RequestHelper {
    private static final String GET_USER_DETAIL_ENDPOINT = "/User/%s";
    private static final String GENERATE_TOKEN_END_POINT = "/GenerateToken";
    public static String prefixAccountURL = APIConstants.DEMOQA_HOST + ACCOUNT_PREFIX;
    public static String LOGIN_END_POINT = "/Login";


    public Response getUserDetail(String userId, String token) throws IOException {
        String url = prefixAccountURL + String.format(GET_USER_DETAIL_ENDPOINT,userId);
        JsonObject body = new JsonObject();
        Headers headers = createHeaders(HeaderHelper.getAuthorizationHeaders(token));
        return sendRequest(
                APIConstants.RequestType.GET,
                url,
                headers,
                body
        );
    }
    public List<String> generateToken(String username, String password) {
        String url = prefixAccountURL + GENERATE_TOKEN_END_POINT;
        JsonObject body = new JsonObject();
        body.addProperty("userName", username);
        body.addProperty("password", password);
        Response response = sendRequest(
                APIConstants.RequestType.POST,
                url,
                null,
                body.toString()
        );
        String token = response.jsonPath().getString("token");
        String expires = response.jsonPath().getString("expires");
        return Arrays.asList(token, expires);
    }
}
