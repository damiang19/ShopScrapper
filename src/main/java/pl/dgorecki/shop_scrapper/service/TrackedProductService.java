package pl.dgorecki.shop_scrapper.service;

import pl.dgorecki.shop_scrapper.service.dto.TrackedProductDTO;

public interface TrackedProductService {
    TrackedProductDTO save(TrackedProductDTO trackedProductDTO);
}
