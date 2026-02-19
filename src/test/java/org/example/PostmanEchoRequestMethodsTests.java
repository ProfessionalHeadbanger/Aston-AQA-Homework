package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;

public class PostmanEchoRequestMethodsTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetMethod() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("args", hasEntry("foo1", "bar1"))
                .body("args", hasEntry("foo2", "bar2"));
    }

    @Test
    public void testPostMethodFormData() {
        given()
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParam("key1", "value1")
                .formParam("key2", "value2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("form", hasEntry("key1", "value1"))
                .body("form", hasEntry("key2", "value2"));
    }

    @Test
    public void testPostMethodRawText() {
        String rawText = "Hello, this is raw text content";

        given()
                .contentType(ContentType.TEXT)
                .body(rawText)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(rawText));
    }

    @Test
    public void testPutMethod() {
        given()
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParam("key1", "value1")
                .formParam("key2", "value2")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("form", hasEntry("key1", "value1"))
                .body("form", hasEntry("key2", "value2"));
    }

    @Test
    public void testPatchMethod() {
        given()
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParam("key1", "value1")
                .formParam("key2", "value2")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("form", hasEntry("key1", "value1"))
                .body("form", hasEntry("key2", "value2"));
    }

    @Test
    public void testDeleteMethod() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("args", hasEntry("foo1", "bar1"))
                .body("args", hasEntry("foo2", "bar2"));
    }
}