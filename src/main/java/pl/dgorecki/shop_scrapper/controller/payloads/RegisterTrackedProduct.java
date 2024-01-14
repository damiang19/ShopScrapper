package pl.dgorecki.shop_scrapper.controller.payloads;

import pl.dgorecki.shop_scrapper.Shop;

public record RegisterTrackedProduct(String url, Shop shop) {

}
