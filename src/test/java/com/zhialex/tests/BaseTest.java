package com.zhialex.tests;

import com.codeborne.selenide.Configuration;
import com.zhialex.pages.CartPage;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

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
        String[] browser = System.getProperty("browser").split("_");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.browser = browser[0];
        Configuration.browserVersion = browser[1];
        Configuration.remote = String.format(
                "https://%s:%s@selenoid.autotests.cloud/wd/hub",
                System.getProperty("user"),
                System.getProperty("password")
        );
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
    }
}
