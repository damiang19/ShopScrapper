package pl.dgorecki.shop_scrapper.job;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import pl.dgorecki.shop_scrapper.service.TrackedProductArchiveService;
import pl.dgorecki.shop_scrapper.service.TrackedProductService;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class PriceScrapperJob {

    private final TrackedProductService trackedProductService;
    private final TrackedProductArchiveService trackedProductArchiveService;


    @Scheduled(fixedDelay = 43200000)
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
    }
}
