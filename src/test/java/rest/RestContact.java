package rest;

import data.ContactData;
import data.UserData;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestContact {
    public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static String usedPost(ContactData contactData) {
        return given()
                .spec(requestSpec)
                .body(contactData)
                .when()
                .post("/users/1/contacts")
                .then().log().all()
                .statusCode(201)
                .extract()
                .asString();
    }

    public static String usedPost2(ContactData contactData) {
        return given()
                .spec(requestSpec)
                .body(contactData)
                .when()
                .post("/users/2/contacts")
                .then().log().all()
                .statusCode(201)
                .extract()
                .asString();
    }

    public static String usedPut(ContactData contactData) {
        return given()
                .spec(requestSpec)
                .body(contactData)
                .when()
                .put("/users/1/contacts")
                .then().log().all()
                .statusCode(200)
                .extract()
                .asString();
    }

    public static String usedDelete(ContactData contactData) {
        return given()
                .spec(requestSpec)
                .body(contactData)
                .when()
                .delete("/users/2/contacts")
                .then().log().all()
                .statusCode(202)
                .extract()
                .asString();
    }

    public static String usedGet(ContactData contactData) {
        return given()
                .spec(requestSpec)
                .body(contactData)
                .when()
                .get("/users/1/contacts")
                .then().log().all()
                .statusCode(200)
                .extract()
                .asString();
    }

    public static String usedGet2(ContactData contactData) {
        return given()
                .spec(requestSpec)
                .body(contactData)
                .when()
                .get("/users/2/contacts")
                .then().log().all()
                .statusCode(200)
                .extract()
                .asString();
    }

    public static String usedPostNull(ContactData contactData) {
        return given()
                .spec(requestSpec)
                .body(contactData)
                .when()
                .post("/users/1/contacts")
                .then().log().all()
                .statusCode(400)
                .extract()
                .asString();
    }

    public static String usedDeleteNothing(ContactData contactData) {
        return given()
                .spec(requestSpec)
                .body(contactData)
                .when()
                .delete("/users/45/contacts")
                .then().log().all()
                .statusCode(404)
                .extract()
                .asString();
    }
}
