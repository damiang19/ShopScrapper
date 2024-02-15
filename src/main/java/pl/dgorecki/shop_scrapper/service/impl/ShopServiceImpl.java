package pl.dgorecki.shop_scrapper.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dgorecki.shop_scrapper.repository.ShopRepository;
import pl.dgorecki.shop_scrapper.service.ShopService;
import pl.dgorecki.shop_scrapper.service.dto.ShopDTO;
import pl.dgorecki.shop_scrapper.service.errors.InvalidUrlException;

import java.util.Optional;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;


    @Override
    @Transactional
    public ShopDTO save(ShopDTO shopDTO) {
        return null;
    }

    @Override
    @Transactional
    public ShopDTO getByUrl(String url) {
//        shopRepository.findByUrlStartingWith()
        return null;
    }

    @Override
    public String validateShopUrl(String url) {
        return extractBaseShopUrl(url).orElseThrow(() -> new InvalidUrlException("URL is not correctly formatted."));
    }

    private Optional<String> extractBaseShopUrl(String url) {
        return Pattern.compile("(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[a-zA-Z]{2,}|(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[a-zA-Z]{2,})")
                .matcher(url)
                .results()
                .map(MatchResult::group)
                .findFirst();
    }

}
