package pl.dgorecki.shop_scrapper.controller;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.dgorecki.shop_scrapper.service.TrackedProductService;
import pl.dgorecki.shop_scrapper.service.dto.TrackedProductDTO;


@AllArgsConstructor
@RestController("/tracked-product")
public class TrackedProductController {

    private final TrackedProductService trackedProductService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping("/save")
    public ResponseEntity<TrackedProductDTO> createTrackedProduct(@RequestBody String url) {
        log.debug("Request to create new TrackedProduct");
//        TrackedProductDTO trackedProductDTO = trackedProductService.save(u);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

}
