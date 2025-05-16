package org.example.repository;

import org.example.entity.RecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipientRepository extends JpaRepository<RecipientEntity, String> {
    Optional<RecipientEntity> findByEmail(String recipientEmail);
}
