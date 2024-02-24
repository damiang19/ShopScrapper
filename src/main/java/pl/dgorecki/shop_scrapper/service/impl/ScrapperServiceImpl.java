package pl.dgorecki.shop_scrapper.service.impl;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import pl.dgorecki.shop_scrapper.service.ScrapperService;
import pl.dgorecki.shop_scrapper.service.dto.TrackedProductArchiveDTO;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ScrapperServiceImpl implements ScrapperService {


    public void scrap() throws IOException {
        Document doc = Jsoup.connect("https://www.morele.net/monitor-lg-27mr400-b-13135674/").get();
        String newsHeadlines = doc.getElementById("product_price_brutto").attr("data-price");
        String title = doc.getElementsByTag("h1").text();
        TrackedProductArchiveDTO trackedProductArchiveDTO = new TrackedProductArchiveDTO();
        TrackedProductArchiveDTO updated = new TrackedProductArchiveDTO();
    }

}
