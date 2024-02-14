package pl.dgorecki.shop_scrapper.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TrackedProductDTO {

    private Long id;

    private String url;

    private BigDecimal price;

    private String productName;

    private Long shopId;

    private String shopName;
}
