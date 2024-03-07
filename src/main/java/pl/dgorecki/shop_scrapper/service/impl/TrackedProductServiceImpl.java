package pl.dgorecki.shop_scrapper.service.impl;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.dgorecki.shop_scrapper.entity.TrackedProduct;
import pl.dgorecki.shop_scrapper.repository.TrackedProductRepository;
import pl.dgorecki.shop_scrapper.service.ScrapperService;
import pl.dgorecki.shop_scrapper.service.ShopService;
import pl.dgorecki.shop_scrapper.service.TrackedProductArchiveService;
import pl.dgorecki.shop_scrapper.service.TrackedProductService;
import pl.dgorecki.shop_scrapper.service.dto.ScrappedProductData;
import pl.dgorecki.shop_scrapper.service.dto.ShopDTO;
import pl.dgorecki.shop_scrapper.service.dto.TrackedProductDTO;
import pl.dgorecki.shop_scrapper.service.mapper.TrackedProductMapper;

@Service
@AllArgsConstructor
public class TrackedProductServiceImpl implements TrackedProductService {

    private final TrackedProductArchiveService trackedProductArchiveService;
    private final TrackedProductMapper trackedProductMapper;
    private final TrackedProductRepository trackedProductRepository;
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final ScrapperService scrapperService;
    private final ShopService shopService;


    @Override
    public TrackedProductDTO save(ScrappedProductData scrappedData, String url, Long shopId) {
        TrackedProductDTO trackedProductDTO = new TrackedProductDTO();
        trackedProductDTO.setProductName(scrappedData.getProductName());
        trackedProductDTO.setPrice(scrappedData.getPrice());
        trackedProductDTO.setShopId(shopId);
        trackedProductDTO.setUrl(url);
        TrackedProduct trackedProduct = trackedProductRepository.save(trackedProductMapper.toEntity(trackedProductDTO));
        return trackedProductMapper.toDto(trackedProduct);
    }

    @Override
    public TrackedProductDTO addNewProductToDatabase(String url) {
        String linkToProduct =  shopService.validateUrlFormat(url);
        ShopDTO shopDTO =  shopService.getByUrl(linkToProduct);
        ScrappedProductData scrappedProductData = scrapperService.scrapActualProductPrice(shopDTO, linkToProduct);
        return save(scrappedProductData, linkToProduct, shopDTO.getId());
    }


}
