package com.demoqa.utils.api.helper;

import com.demoqa.utils.api.APIConstants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestHelper {
    public Response sendRequest (APIConstants.RequestType method, String url, Headers headers, Object body) {
        RestAssured.baseURI = APIConstants.DEMOQA_HOST;
        if(headers == null){
            Map<String,String> map = new HashMap<>();
            headers = createHeaders(map);
        }
        RequestSpecification request = RestAssured.given()
                .contentType(ContentType.JSON)
                .headers(headers);
        return getResponse(request, method, url, body);
    }
    private Response getResponse (RequestSpecification reqSpec, APIConstants.RequestType method, String url, Object body ){
        Response response;
        System.setProperty("com.sun.security.enableAIAcaIssues", "true");
        switch (method){
            case POST:
                if(null == body || body.toString().isEmpty()){
                    response = reqSpec.when().post(url);
                } else {
                    response = reqSpec.body(body.toString()).when().post(url);
                }
                break;
            case PUT:
                response = reqSpec.body(body).when().put(url);
                break;
            case PATCH:
                response = reqSpec.body(body).when().patch();
                break;
            case DELETE:
                response = reqSpec.when().delete(url);
                break;
            default:
                response = reqSpec.get(url);
                break;
        }
        System.out.printf("URL: %s\n%n", url);
        System.out.printf("The request is sent with: %s\n%n", body.toString());
        System.out.printf("The respond is returned with \nStatus code: %s\nResponse Body:%n", response.statusCode());
        response.prettyPrint();
        return response;
    }
    public static Headers getHeader(){
        return new Headers(new Header("Content-Type","application/json"));
    }
    public static Headers createHeaders(Map<String,String> headersToAdd){
        List<Header> headerList = new ArrayList<>();
        Headers requestHeaders = getHeader();
        if(requestHeaders.exist()){
            for(Header requestHeader : requestHeaders){
                headerList.add(requestHeader);
            }
        }
        for(Map.Entry<String,String> stringEntry : headersToAdd.entrySet()){
            headerList.add(new Header(stringEntry.getKey(),stringEntry.getValue()));
        }
        return new Headers(headerList);
    }
}
