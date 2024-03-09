package pl.dgorecki.shop_scrapper.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "sledzony_produkt")
public class TrackedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "link_do_produktu")
    private String url;

    @Column(name = "cena")
    private BigDecimal price;

    @Column(name = "nazwa_produktu")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "sklep_id")
    private Shop shop;

}
