package api.adapter;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static utilities.Constants.*;
import static utilities.Urls.BASE_URL;

public class BaseAdapter {

    //перенести в параметр при запуске
    private static final String TOKEN_VALUE = "65465";

    public Response get(String url) {
        return
                given()
                        .header(TOKEN,TOKEN_VALUE)
                .when()
                        .get(BASE_URL + url)
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
                        .post(BASE_URL + url)
                .then()
                        .log().all()
                        .extract().response();
    }
}
