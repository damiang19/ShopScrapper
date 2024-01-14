package pl.dgorecki.shop_scrapper.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.dgorecki.shop_scrapper.entity.TrackedProduct;

import java.time.Instant;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TrackedProductArchiveDTO extends TrackedProductDTO{
    private Long id;
    private Instant date;
    private Long trackedProductId;
}
