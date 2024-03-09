package pl.dgorecki.shop_scrapper.service;

import pl.dgorecki.shop_scrapper.service.dto.TrackedProductArchiveDTO;
import pl.dgorecki.shop_scrapper.service.dto.TrackedProductDTO;

public interface TrackedProductArchiveService {

    TrackedProductArchiveDTO save(TrackedProductDTO trackedProductDTO);
}
