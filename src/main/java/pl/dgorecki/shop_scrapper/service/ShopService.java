package pl.dgorecki.shop_scrapper.service;

import pl.dgorecki.shop_scrapper.controller.payload.ShopData;
import pl.dgorecki.shop_scrapper.service.dto.ShopDTO;

public interface ShopService {
    ShopDTO save(ShopData shopData);

    ShopDTO getByUrl(String url);

}
