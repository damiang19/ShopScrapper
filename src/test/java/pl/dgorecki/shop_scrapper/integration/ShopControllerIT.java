package pl.dgorecki.shop_scrapper.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.reactive.server.WebTestClient;
import pl.dgorecki.shop_scrapper.ShopScrapperApplication;
import pl.dgorecki.shop_scrapper.controller.payload.ShopData;
import pl.dgorecki.shop_scrapper.repository.ShopRepository;
import pl.dgorecki.shop_scrapper.service.dto.ShopDTO;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
@AutoConfigureWebTestClient
@SpringBootTest(classes = ShopScrapperApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShopControllerIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ShopRepository shopRepository;

    private ShopData shopData;

    @BeforeEach
    public void init() {
        shopData = createPayload();
    }

    @Test
    void shouldCreateNewCustomers() {
        this.webTestClient
                .post()
                .uri("/shop")
                .bodyValue()
                .header(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus()
                .isCreated();
    }



    private ShopData createPayload() {
        return new ShopData("name", "price", "morele.net", "morele.net");
    }
}
