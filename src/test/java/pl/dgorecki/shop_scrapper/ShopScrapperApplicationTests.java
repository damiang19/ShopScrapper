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
		Document doc = Jsoup.connect("https://www.morele.net/monitor-lg-27mr400-b-13135674/").get();
		String newsHeadlines = doc.getElementById("product_price_brutto").attr("data-price");
		String title = doc.getElementsByTag("h1").text();
		TrackedProductArchiveDTO trackedProductArchiveDTO = new TrackedProductArchiveDTO();
		TrackedProductArchiveDTO updated = new TrackedProductArchiveDTO();

		String url = "eeeehttps://stackoverflow.com/questions/15446689/what-is-the-use-of-system-in-read";
			Optional<String> t = Pattern.compile("(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[a-zA-Z]{2,}|(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[a-zA-Z]{2,})")
					.(url)
					.results()
					.map(MatchResult::group)
					.findFirst();
			System.out.println(t.get());
	}

}
