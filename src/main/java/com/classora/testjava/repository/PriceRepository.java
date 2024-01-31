package com.classora.testjava.repository;

import com.classora.testjava.model.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<Prices, Long> {

    @Query("SELECT p FROM Prices p WHERE p.productId = :productId AND p.brandId = :brandId " +
            "AND :date BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC, p.startDate DESC")
    List<Prices> findApplicablePrices(LocalDateTime date, Integer productId, Integer brandId);
}
