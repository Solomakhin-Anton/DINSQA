package rest;

import data.UserData;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestUser {
    public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static String usedPost(UserData userData) {
        return given()
                .spec(requestSpec)
                .body(userData)
                .when()
                .post("/users")
                .then().log().all()
                .statusCode(201)
                .extract()
                .asString();
    }

    public static String usedPut(UserData userData) {
        return given()
                .spec(requestSpec)
                .body(userData)
                .when()
                .put("/users/1")
                .then().log().all()
                .statusCode(200)
                .extract()
                .asString();
    }

    public static String usedDelete(UserData userData) {
        return given()
                .spec(requestSpec)
                .body(userData)
                .when()
                .delete("/users/3")
                .then().log().all()
                .statusCode(202)
                .extract()
                .asString();
    }

    public static String usedGet(UserData userData) {
        return given()
                .spec(requestSpec)
                .body(userData)
                .when()
                .get("/users")
                .then().log().all()
                .statusCode(200)
                .extract()
                .asString();
    }

    public static String usedPostNull(UserData userData) {
        return given()
                .spec(requestSpec)
                .body(userData)
                .when()
                .post("/users")
                .then().log().all()
                .statusCode(400)
                .extract()
                .asString();
    }

    public static String usedDeleteNothing(UserData userData) {
        return given()
                .spec(requestSpec)
                .body(userData)
                .when()
                .delete("/users/45")
                .then().log().all()
                .statusCode(404)
                .extract()
                .asString();
    }
}
