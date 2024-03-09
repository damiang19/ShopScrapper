package pl.dgorecki.shop_scrapper.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dgorecki.shop_scrapper.entity.TrackedProductArchive;
import pl.dgorecki.shop_scrapper.repository.TrackedProductArchiveRepository;
import pl.dgorecki.shop_scrapper.service.TrackedProductArchiveService;
import pl.dgorecki.shop_scrapper.service.dto.TrackedProductArchiveDTO;
import pl.dgorecki.shop_scrapper.service.dto.TrackedProductDTO;
import pl.dgorecki.shop_scrapper.service.mapper.TrackedProductArchiveMapper;

import java.time.Instant;

@Service
@AllArgsConstructor
public class TrackedProductArchiveServiceImpl implements TrackedProductArchiveService {

    private final TrackedProductArchiveRepository trackedProductArchiveRepository;
    private final TrackedProductArchiveMapper trackedProductArchiveMapper;

    @Override
    public TrackedProductArchiveDTO save(TrackedProductDTO trackedProductDTO) {
        TrackedProductArchiveDTO trackedProductArchiveDTO = new TrackedProductArchiveDTO();
        trackedProductArchiveDTO.setDate(Instant.now());
        trackedProductArchiveDTO.setProductName(trackedProductDTO.getProductName());
        trackedProductArchiveDTO.setUrl(trackedProductDTO.getUrl());
        trackedProductArchiveDTO.setPrice(trackedProductDTO.getPrice());
        trackedProductArchiveDTO.setShopId(trackedProductDTO.getShopId());
        TrackedProductArchive trackedProductArchive = trackedProductArchiveRepository.save(trackedProductArchiveMapper.toEntity(trackedProductArchiveDTO));
        return trackedProductArchiveMapper.toDto(trackedProductArchive);
    }
}
