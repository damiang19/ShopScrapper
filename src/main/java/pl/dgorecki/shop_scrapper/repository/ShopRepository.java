package pl.dgorecki.shop_scrapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dgorecki.shop_scrapper.entity.Shop;

import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Long, Shop> {
    Optional<Shop> findByShopName(String shopName);
}
