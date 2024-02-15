package pl.dgorecki.shop_scrapper.service.impl;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.dgorecki.shop_scrapper.repository.TrackedProductRepository;
import pl.dgorecki.shop_scrapper.service.ShopService;
import pl.dgorecki.shop_scrapper.service.TrackedProductArchiveService;
import pl.dgorecki.shop_scrapper.service.TrackedProductService;
import pl.dgorecki.shop_scrapper.service.dto.TrackedProductDTO;

@Service
@AllArgsConstructor
public class TrackedProductServiceImpl implements TrackedProductService {

    private final TrackedProductArchiveService trackedProductArchiveService;
    private final TrackedProductRepository trackedProductRepository;
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final ShopService shopService;


    @Override
    public TrackedProductDTO save(TrackedProductDTO trackedProductDTO) {
        return null;
    }

    @Override
    public TrackedProductDTO addNewProductToDatabase(String url) {
        return null;
    }


}
