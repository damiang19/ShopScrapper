package pl.dgorecki.shop_scrapper.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.Instant;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class TrackedProductArchiveDTO extends TrackedProductDTO{
    private Instant date;
    private Long trackedProductId;
}
