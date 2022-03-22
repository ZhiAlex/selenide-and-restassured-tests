package com.zhialex.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DeleteProductsFromCartTest extends BaseTest {

    @Test
    @DisplayName("Check cart cleaning")
    void deleteProductsFromCartTest() {

        String cookie = addProductToCart();

        open("http://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/logo.png");

        getWebDriver().manage().addCookie(new Cookie("Nop.customer", cookie));

        open(cartPage.getCartPageUrl());

        cartPage
                .setAllCheckbox()
                .cleanCart()
                .checkCartIsClean();
    }
}
