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

    @Override
    public String validateUrlFormat(String url) {
        return extractUrl(url, UrlRegexp.URL).orElseThrow(() -> new InvalidUrlException("Invalid URL format"));
    }

    @Override
    public String getBaseShopUrl(String url) {
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
