package pl.dgorecki.shop_scrapper.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.dgorecki.shop_scrapper.enums.UrlRegexp;
import pl.dgorecki.shop_scrapper.service.UrlValidatorService;
import pl.dgorecki.shop_scrapper.service.errors.InvalidUrlException;

import java.util.Optional;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

@Service
public class UrlValidatorServiceImpl implements UrlValidatorService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final Pattern productUrlRegexp = Pattern.compile(UrlRegexp.URL.getValue());
    private static final Pattern shopUrlRegexp = Pattern.compile(UrlRegexp.SHOP.getValue());


    @Override
    public String validateUrlFormat(String url) {
        return extractUrl(url, productUrlRegexp).orElseThrow(() -> new InvalidUrlException("Invalid URL format"));
    }

    @Override
    public String getBaseShopUrl(String url) {
        return extractUrl(url, shopUrlRegexp).orElseThrow(() -> new InvalidUrlException("URL is not correctly formatted."));
    }


    private Optional<String> extractUrl(String url, Pattern pattern) {
        return pattern
                .matcher(url)
                .results()
                .map(MatchResult::group)
                .findFirst();
    }
}
