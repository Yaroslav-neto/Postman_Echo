package ru.netology;

import io.restassured.filter.log.LogDetail;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class PostmanEchoTests {
    @Test
    void shouldPostRequest() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("echo") // отправляемые данные (заголовки и query можно выставлять аналогично)
        // Выполняемые действия
                .when().log().all()
                .post("/post")
        // Проверки
                .then().log().all()
                .statusCode(200)
                .body("data", org.hamcrest.Matchers.equalTo("echo"))
                .headers("content-type", "application/json; charset=utf-8")
        ;
    }
}
