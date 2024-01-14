package pl.dgorecki.shop_scrapper.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dgorecki.shop_scrapper.service.TrackedProductService;
import pl.dgorecki.shop_scrapper.service.dto.TrackedProductDTO;

@Service
@AllArgsConstructor
public class TrackedProductServiceImpl implements TrackedProductService {

    @Override
    public TrackedProductDTO save(TrackedProductDTO trackedProductDTO) {
        return null;
    }
}
