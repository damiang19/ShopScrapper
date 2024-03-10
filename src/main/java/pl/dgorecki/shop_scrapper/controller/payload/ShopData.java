package pl.dgorecki.shop_scrapper.controller.payload;

import jakarta.validation.constraints.NotBlank;

public record ShopData(@NotBlank String productNameHtmlClass,
                       @NotBlank String priceHtmlClass,
                       @NotBlank String shopName,
                       @NotBlank String shopUrl) {

}
