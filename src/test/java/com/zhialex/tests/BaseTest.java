package com.zhialex.tests;

import com.zhialex.pages.CartPage;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static com.zhialex.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.given;

public class BaseTest {

    CartPage cartPage = new CartPage();

    public String addProductToCart() {
        return given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("addtocart_51.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/51/1")
                .then()
                .extract()
                .cookie("Nop.customer");
    }

    @BeforeAll
    public static void beforeAll() {
        RestAssured.filters(withCustomTemplates());
    }
}
