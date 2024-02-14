package pl.dgorecki.shop_scrapper.service;

import pl.dgorecki.shop_scrapper.service.dto.ShopDTO;

public interface ShopService {
    ShopDTO save(ShopDTO shopDTO);

    ShopDTO getByName(String shopName);

    Boolean isExistByName(String name);

}
