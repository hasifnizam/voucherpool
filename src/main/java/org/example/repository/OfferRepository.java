package org.example.repository;

import org.example.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<OfferEntity, String> {
    Optional<OfferEntity> findByName(String offerName);
}
