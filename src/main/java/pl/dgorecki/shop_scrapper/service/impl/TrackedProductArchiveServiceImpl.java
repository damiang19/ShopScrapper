package pl.dgorecki.shop_scrapper.service.impl;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.dgorecki.shop_scrapper.entity.TrackedProductArchive;
import pl.dgorecki.shop_scrapper.repository.TrackedProductArchiveRepository;
import pl.dgorecki.shop_scrapper.service.TrackedProductArchiveService;
import pl.dgorecki.shop_scrapper.service.dto.TrackedProductArchiveDTO;
import pl.dgorecki.shop_scrapper.service.dto.TrackedProductDTO;
import pl.dgorecki.shop_scrapper.service.mapper.TrackedProductArchiveMapper;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TrackedProductArchiveServiceImpl implements TrackedProductArchiveService {

    private final TrackedProductArchiveRepository trackedProductArchiveRepository;
    private final TrackedProductArchiveMapper trackedProductArchiveMapper;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public List<TrackedProductArchiveDTO> saveAll(List<TrackedProductDTO> trackedProductDTOList) {
        log.debug("Request to create archived tracked products");
        List<TrackedProductArchiveDTO> trackedProductArchiveDTOList = new ArrayList<>();
        trackedProductDTOList.forEach(trackedProductDTO -> trackedProductArchiveDTOList.add(TrackedProductArchiveDTO.from(trackedProductDTO)));
        List<TrackedProductArchive> listOfTrackedProductsArchives = trackedProductArchiveRepository
                .saveAll(trackedProductArchiveMapper.toEntity(trackedProductArchiveDTOList));
        return trackedProductArchiveMapper.toDto(listOfTrackedProductsArchives);
    }
}
