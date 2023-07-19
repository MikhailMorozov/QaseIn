package api.adapter;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static utilities.Constants.*;
import static utilities.Urls.BASE_API_URL;


public class BaseAdapter {

    //перенести в параметр при запуске
    private static final String TOKEN_VALUE = "7aaa3cc72425e629bbf82c4ce45c3cdace8f29447f88111b1ab231e44080a195";

    public Response get(String url) {
        return
                given()
                        .header(TOKEN,TOKEN_VALUE)
                .when()
                        .get(BASE_API_URL + url)
                .then()
                        .log().all()
                        .extract().response();
    }

    public Response post(String url, String body){
        return
                given()
                        .header(TOKEN, TOKEN_VALUE)
                        .header(CONTENT_TYPE, JSON)
                        .body(body)
                .when()
                        .post(BASE_API_URL + url)
                .then()
                        .log().all()
                        .extract().response();
    }

    public Response delete(String url, String body){
        return
                given()
                        .header(TOKEN, TOKEN_VALUE)
                        .header(CONTENT_TYPE, JSON)
                        .body(body)
                .when()
                        .delete(BASE_API_URL + url)
                .then()
                        .log().all()
                        .extract().response();
    }
}
