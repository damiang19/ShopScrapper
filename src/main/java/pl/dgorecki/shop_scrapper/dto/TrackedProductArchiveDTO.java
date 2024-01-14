package pl.dgorecki.shop_scrapper.dto;

import jakarta.persistence.Column;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.dgorecki.shop_scrapper.entity.TrackedProduct;

import java.time.Instant;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class TrackedProductArchiveDTO extends TrackedProductDTO{
    private TrackedProduct trackedProduct;
    private Instant date;
}
