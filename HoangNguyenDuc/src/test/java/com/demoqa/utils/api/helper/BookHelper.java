package com.demoqa.utils.api.helper;

import com.demoqa.utils.api.APIConstants;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static com.demoqa.utils.api.APIConstants.*;

public class BookHelper extends RequestHelper {

    public Response addBook(String baseURI, String userId, String token,String isbn) {
        String url = baseURI + BOOK_STORE_PREFIX + BOOKS_ENDPOINT;
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
    public Response deleteAllBook(String baseURI, String userId, String token){
        String url = baseURI + BOOK_STORE_PREFIX + BOOKS_ENDPOINT + DELETE_ALL_BOOK_ENDPOINT + userId;
        Headers headers = createHeaders(HeaderHelper.getAuthorizationHeaders(token));
        JsonObject body = new JsonObject();
        return sendRequest(
                APIConstants.RequestType.DELETE,
                url,
                headers,
                body.toString()
        );
    }
    public String getBookIsbn(String baseURI, String bookName) {
        String url = baseURI + BOOK_STORE_PREFIX + BOOKS_ENDPOINT;
        Headers headers = new Headers();
        JsonObject body = new JsonObject();
        Response response = sendRequest(
                APIConstants.RequestType.GET,
                url,
                headers,
                body

        );
        JsonPath respondBody = response.jsonPath();
        for (int i = 0; i < respondBody.getList("books.title").size(); i++) {
            if (respondBody.getList("books.title").get(i).equals(bookName)){
                return respondBody.get("books["+i+"].isbn");
            }
        }
        return null;
    }
}
