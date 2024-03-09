package pl.dgorecki.shop_scrapper.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dgorecki.shop_scrapper.repository.ShopRepository;
import pl.dgorecki.shop_scrapper.service.ShopService;
import pl.dgorecki.shop_scrapper.service.UrlValidatorService;
import pl.dgorecki.shop_scrapper.service.dto.ShopDTO;
import pl.dgorecki.shop_scrapper.service.errors.ShopNotFoundException;
import pl.dgorecki.shop_scrapper.service.mapper.ShopMapper;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final UrlValidatorService urlValidatorService;
    private final ShopRepository shopRepository;
    private final ShopMapper shopMapper;


    @Override
    @Transactional
    public ShopDTO save(ShopDTO shopDTO) {
        return null;
    }

    @Override
    @Transactional
    public ShopDTO getByUrl(String url) {
        String shopUrl = urlValidatorService.getBaseShopUrl(url);
        return shopMapper.toDto(shopRepository.findByShopUrl(shopUrl)
                .orElseThrow(() -> new ShopNotFoundException("Given shop does not exist in Database")));
    }


}
