package pl.dgorecki.shop_scrapper.services;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import pl.dgorecki.shop_scrapper.ShopScrapperApplication;
import pl.dgorecki.shop_scrapper.controller.payload.ShopData;
import pl.dgorecki.shop_scrapper.entity.Shop;
import pl.dgorecki.shop_scrapper.repository.ShopRepository;
import pl.dgorecki.shop_scrapper.service.dto.ShopDTO;
import pl.dgorecki.shop_scrapper.service.impl.ShopServiceImpl;
import pl.dgorecki.shop_scrapper.service.impl.UrlValidatorServiceImpl;
import pl.dgorecki.shop_scrapper.service.mapper.ShopMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = ShopScrapperApplication.class)
public class ShopServiceTest {
    @Mock
    private ShopRepository shopRepository;

    @Mock
    private UrlValidatorServiceImpl urlValidatorService;

    @Mock
    ShopMapper shopMapper;

    @InjectMocks
    private ShopServiceImpl shopService;

    @Test
    void findAll_should_return_student_list() {
        when(urlValidatorService.getBaseShopUrl(anyString())).thenReturn("http://");
        when(shopMapper.toDto(any(Shop.class))).thenReturn(new ShopDTO());
        when(shopRepository.save(any(Shop.class))).thenReturn(new Shop());
        ShopDTO persist = shopService.save(new ShopData("tt", "tt", "tt", "tt"));
    }
}
