package com.zhialex.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.name;

public class CartPage {

    private String cartPageUrl = "http://demowebshop.tricentis.com/cart";

    private SelenideElement
            updateCartButton = $(name("updatecart")),
            cartEmptyText = $(".order-summary-content");

    private ElementsCollection itemsCheckbox = $$(".remove-from-cart input");

    public CartPage setAllCheckbox() {
        for (SelenideElement checkbox : itemCheckbox) {
            checkbox.click();
        }
        return this;
    }

    public CartPage cleanCart() {
        updateCartButton.click();
        return this;
    }

    public void checkCartIsClean() {
        cartEmptyText.shouldBe(visible);
    }

    public String getCartPageUrl() {
        return cartPageUrl;
    }
}
