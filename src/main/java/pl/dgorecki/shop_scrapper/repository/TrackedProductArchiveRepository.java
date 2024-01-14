package pl.dgorecki.shop_scrapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dgorecki.shop_scrapper.entity.TrackedProductArchive;

@Repository
public interface TrackedProductArchiveRepository extends JpaRepository<TrackedProductArchive, Long> {
}
