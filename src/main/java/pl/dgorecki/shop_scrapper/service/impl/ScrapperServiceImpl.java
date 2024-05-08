package pl.dgorecki.shop_scrapper.service.impl;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.dgorecki.shop_scrapper.entity.Shop;
import pl.dgorecki.shop_scrapper.enums.UrlRegexp;
import pl.dgorecki.shop_scrapper.service.ScrapperService;
import pl.dgorecki.shop_scrapper.service.dto.ScrappedProductData;
import pl.dgorecki.shop_scrapper.service.dto.ShopDTO;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScrapperServiceImpl implements ScrapperService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public ScrappedProductData scrapActualProductPrice(ShopDTO shopDTO, String url) {
        Document document = connectToTrackedProductSite(url);
        return downloadProductInfo(document, shopDTO);
    }

    @Override
    public Document connectToTrackedProductSite(String url) {
        try {
            return Jsoup.connect(url).userAgent("Mozilla/5.0").ignoreContentType(true)
                    .parser(Parser.xmlParser()).get();
        } catch (IOException connectionException) {
            throw new RuntimeException("Error - cannot connect with url : " + url);
        }
    }

    @Override
    public ScrappedProductData downloadProductInfo(Document loadedPage, ShopDTO shopDTO) {
        Pattern pattern = Pattern.compile(UrlRegexp.PRICE.getValue());

        String productName = loadedPage.getElementsByClass(shopDTO.getProductNameHtmlClass()).text();

//        String t = getProductPrice(loadedPage, shopDTO);

        BigDecimal productPrice = new BigDecimal(loadedPage.getElementsByClass(shopDTO.getPriceHtmlClass()).attr("content"));
        return new ScrappedProductData(productName, productPrice);
    }

    private String getProductPrice(Document loadedPage, ShopDTO shopDTO) {
        return loadedPage
                .getElementsByClass(shopDTO.getPriceHtmlClass())
                .get(0).attributes().asList()
                .stream().map(Attribute::getValue)
                .filter(s -> s.matches(UrlRegexp.PRICE.getValue())).findFirst()
                .orElse(loadedPage.getElementsByClass(shopDTO.getProductNameHtmlClass()).text());
    }

    private String getProductName(Document loadedPage, ShopDTO shopDTO) {
        loadedPage.getElementsByClass("sc-1bker4h-10 kHPtVn").get(0).children().tagName("h2").get(0).text();
        return null;
    }
}
