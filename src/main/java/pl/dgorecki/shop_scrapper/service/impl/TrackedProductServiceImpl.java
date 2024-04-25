package pl.dgorecki.shop_scrapper.service.impl;

import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dgorecki.shop_scrapper.entity.Shop;
import pl.dgorecki.shop_scrapper.entity.TrackedProduct;
import pl.dgorecki.shop_scrapper.entity.TrackedProduct_;
import pl.dgorecki.shop_scrapper.repository.TrackedProductRepository;
import pl.dgorecki.shop_scrapper.service.*;
import pl.dgorecki.shop_scrapper.service.criteria.TrackedProductCriteria;
import pl.dgorecki.shop_scrapper.service.dto.ScrappedProductData;
import pl.dgorecki.shop_scrapper.service.dto.ShopDTO;
import pl.dgorecki.shop_scrapper.service.dto.TrackedProductDTO;
import pl.dgorecki.shop_scrapper.service.mapper.TrackedProductMapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TrackedProductServiceImpl implements TrackedProductService {

    private final TrackedProductMapper trackedProductMapper;
    private final TrackedProductRepository trackedProductRepository;
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final UrlValidatorService urlValidatorService;
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
    public TrackedProductDTO addNewProduct(Shop url) {
        String linkToProduct =  urlValidatorService.validateUrlFormat(url.getShopUrl());
        ShopDTO shopDTO =  shopService.getByUrl(linkToProduct);
        ScrappedProductData scrappedProductData = scrapperService.scrapActualProductPrice(shopDTO, linkToProduct);
        return save(scrappedProductData, linkToProduct, shopDTO.getId());
    }

    public void update(List<TrackedProductDTO> trackedProductDTOList) {
        Set<Long> shopIds = trackedProductDTOList.stream().map(TrackedProductDTO::getShopId).collect(Collectors.toSet());
        List<ShopDTO> shopDTOList = shopService.getAllByIds(shopIds.stream().toList());
        // 1. Pobierz wszystkie sklepy
        // 2.
    }

    @Transactional
    public List<TrackedProductDTO> findByCriteria(TrackedProductCriteria trackedProductCriteria, Pageable pageable){
        Specification<TrackedProduct> specification = createSpecification(trackedProductCriteria);
        return trackedProductMapper.toDto(trackedProductRepository.findAll(specification,pageable).getContent());
    }


    protected Specification<TrackedProduct> createSpecification(TrackedProductCriteria trackedProductCriteria){
        Specification<TrackedProduct> specification = Specification.where(null);

        if(trackedProductCriteria.getProductNameStartsWith() != null){
            specification = specification.and((root, query, criteriaBuilder) -> {
                Predicate userName = criteriaBuilder.like(criteriaBuilder.upper(root.get(TrackedProduct_.productName)),
                        (trackedProductCriteria.getProductNameStartsWith() + "%").toUpperCase());
                return criteriaBuilder.and(userName);
            });
        }
        return specification;
    }

}
