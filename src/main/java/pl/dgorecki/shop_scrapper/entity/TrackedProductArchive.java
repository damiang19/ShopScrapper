package pl.dgorecki.shop_scrapper.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "sledzony_produkt_archiwum")
public class TrackedProductArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sledzony_produkt_id")
    private TrackedProduct trackedProduct;

    @Column(name = "cena_z_dnia")
    private Instant date;

    @Column(name = "cena")
    private BigDecimal price;

    @Column(name = "nazwa_produktu")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "sklep_id")
    private Shop shop;
}
