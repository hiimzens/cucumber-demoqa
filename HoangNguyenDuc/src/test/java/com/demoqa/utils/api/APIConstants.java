package com.demoqa.utils.api;

public class APIConstants {
    public enum RequestType{
        GET,
        POST,
        PUT,
        DELETE,
        PATCH
    }
    public static String ACCOUNT_PREFIX = "/Account/v1";
    public static final String LOGIN_ENDPOINT = "/Login";
    public static final String BOOK_STORE_PREFIX = "/BookStore/v1";
    public static final String BOOKS_ENDPOINT = "/Books";
    public static final String DELETE_ALL_BOOK_ENDPOINT = "?UserId=";

}
