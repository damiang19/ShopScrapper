package pl.dgorecki.shop_scrapper.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "sklep")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productNameHtmlClass;

    private String priceHtmlClass;

    private String shopName;

    private String shopUrl;


}
