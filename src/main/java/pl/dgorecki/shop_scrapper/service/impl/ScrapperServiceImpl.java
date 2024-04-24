package pl.dgorecki.shop_scrapper.service.impl;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.dgorecki.shop_scrapper.service.ScrapperService;
import pl.dgorecki.shop_scrapper.service.dto.ScrappedProductData;
import pl.dgorecki.shop_scrapper.service.dto.ShopDTO;

import java.io.IOException;
import java.math.BigDecimal;

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
        String productName = loadedPage.getElementsByClass(shopDTO.getProductNameHtmlClass()).text();
        BigDecimal productPrice = new BigDecimal(loadedPage.getElementsByClass(shopDTO.getPriceHtmlClass()).attr("content"));
        return new ScrappedProductData(productName, productPrice);
    }
}
