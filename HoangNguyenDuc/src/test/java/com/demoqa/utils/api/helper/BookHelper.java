package com.demoqa.utils.api.helper;

import com.demoqa.utils.api.APIConstants;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class BookHelper extends RequestHelper {
    private static final String BOOK_STORE_PREFIX = "/BookStore/v1";
    private static final String ADD_BOOK_END_POINT = "/Books";
    private static final String DELETE_BOOK_ENDPOINT = "/Book";
    public static String prefixAccountURL = APIConstants.DEMOQA_HOST + BOOK_STORE_PREFIX;
    public Response addBook(String userId, String token,String isbn) {
        String url = prefixAccountURL + ADD_BOOK_END_POINT;
        Headers headers = createHeaders(HeaderHelper.getAuthorizationHeaders(token));
        JsonArray collectionIsbn = new JsonArray();
        JsonObject bookIsbn = new JsonObject();
        bookIsbn.addProperty("isbn", isbn);
        collectionIsbn.add(bookIsbn);
        JsonObject body = new JsonObject();
        body.addProperty("userId", userId);
        body.add("collectionOfIsbns", collectionIsbn);
        return sendRequest(
                APIConstants.RequestType.POST,
                url,
                headers,
                body
        );
    }
    public Response deleteBook(String userId, String token, String isbn) {
        String url = prefixAccountURL + DELETE_BOOK_ENDPOINT;
        Headers headers = createHeaders(HeaderHelper.getAuthorizationHeaders(token));
        JsonObject body = new JsonObject();
        body.addProperty("isbn",isbn);
        body.addProperty("userId", userId);
        return sendRequest(
                APIConstants.RequestType.DELETE,
                url,
                headers,
                body
        );
    }
}
