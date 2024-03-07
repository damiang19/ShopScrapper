package pl.dgorecki.shop_scrapper.service;

import pl.dgorecki.shop_scrapper.service.dto.ScrappedProductData;
import pl.dgorecki.shop_scrapper.service.dto.TrackedProductDTO;

public interface TrackedProductService {
    TrackedProductDTO save(ScrappedProductData scrappedData, String url, Long shopId);

    TrackedProductDTO addNewProductToDatabase(String url);


}
