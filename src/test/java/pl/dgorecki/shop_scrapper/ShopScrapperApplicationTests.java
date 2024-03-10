package pl.dgorecki.shop_scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.dgorecki.shop_scrapper.service.dto.TrackedProductArchiveDTO;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

@SpringBootTest
class ShopScrapperApplicationTests {

	@Test
	void contextLoads() throws IOException {
		Document doc = Jsoup.connect("https://www.x-kom.pl/p/1209968-smartfon-telefon-xiaomi-poco-x6-pro-5g-12-512gb-black.html")
				.userAgent("Mozilla/5.0")

				.get();

//		String newsHeadlines = doc.getElementById("product_price_brutto").attr("data-price");
//		String title = doc.getElementsByTag("h1").text();

//		// XKOM
//		String xkomPrize = doc.getElementsByClass("sc-n4n86h-1 hYfBFq").text();
//		// MORELE
//		String newsHeadlines = doc.getElementById("product-price").("data-price");
//
//		TrackedProductArchiveDTO trackedProductArchiveDTO = new TrackedProductArchiveDTO();
//		TrackedProductArchiveDTO updated = new TrackedProductArchiveDTO();




//		String url = "eeeehttps://stackoverflow.com/questions/15446689/what-is-the-use-of-system-in-read";
//			Optional<String> t = Pattern.compile("(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[a-zA-Z]{2,}|(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[a-zA-Z]{2,})")
//					.(url)
//					.results()
//					.map(MatchResult::group)
//					.findFirst();
//			System.out.println(t.get());
	}

}
