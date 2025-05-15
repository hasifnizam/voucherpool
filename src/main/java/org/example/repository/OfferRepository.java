package org.example.repository;

import org.example.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<OfferEntity, Integer> {
    
}
