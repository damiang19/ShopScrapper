package pl.dgorecki.shop_scrapper.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dgorecki.shop_scrapper.repository.TrackedProductArchiveRepository;
import pl.dgorecki.shop_scrapper.service.TrackedProductArchiveService;

@Service
@AllArgsConstructor
public class TrackedProductServiceArchiveImpl implements TrackedProductArchiveService {

    private final TrackedProductArchiveRepository trackedProductArchiveRepository;

}
