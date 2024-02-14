package pl.dgorecki.shop_scrapper.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dgorecki.shop_scrapper.service.ShopService;
import pl.dgorecki.shop_scrapper.service.dto.ShopDTO;

import java.util.regex.Pattern;

@Service
public class ShopServiceImpl implements ShopService {
    @Override
    public ShopDTO save(ShopDTO shopDTO) {
        return null;
    }

    @Override
    @Transactional
    public ShopDTO getByName(String shopName) {
        return null;
    }

    private String extractShopNameFromUrl(String url) {


        return null;
    }

    private Boolean isUrlCorrect(String url) {
        Pattern urlPattern = Pattern.compile("(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})");
        return urlPattern.matcher(url).matches();
    }

    @Override
    public Boolean isExistByName(String name) {
        return null;
    }
}
