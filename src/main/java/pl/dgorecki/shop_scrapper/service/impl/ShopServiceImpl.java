package pl.dgorecki.shop_scrapper.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dgorecki.shop_scrapper.enums.UrlRegexp;
import pl.dgorecki.shop_scrapper.repository.ShopRepository;
import pl.dgorecki.shop_scrapper.service.ShopService;
import pl.dgorecki.shop_scrapper.service.dto.ShopDTO;
import pl.dgorecki.shop_scrapper.service.errors.InvalidUrlException;
import pl.dgorecki.shop_scrapper.service.errors.ShopNotFoundException;
import pl.dgorecki.shop_scrapper.service.mapper.ShopMapper;

import java.util.Optional;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

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
        String shopUrl = getBaseShopUrl(url);
        return shopMapper.toDto(shopRepository.findByShopUrl(shopUrl)
                .orElseThrow(() -> new ShopNotFoundException("Given shop does not exist in Database")));
    }
    @Override
    public String validateUrlFormat(String url) {
        return extractUrl(url, UrlRegexp.URL).orElseThrow(() -> new InvalidUrlException("Invalid URL format"));
    }

    private String getBaseShopUrl(String url) {
        return extractUrl(url, UrlRegexp.SHOP).orElseThrow(() -> new InvalidUrlException("URL is not correctly formatted."));
    }


    private Optional<String> extractUrl(String url, UrlRegexp urlRegexp) {
        return Pattern.compile(urlRegexp.getValue())
                .matcher(url)
                .results()
                .map(MatchResult::group)
                .findFirst();
    }

}
