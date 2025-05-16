package org.example.repository;

import org.example.entity.RecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<RecipientEntity, Integer> {
}
