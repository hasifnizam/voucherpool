package org.example.repository;

import org.example.entity.VoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoucherRepository extends JpaRepository<VoucherEntity, String> {
    Optional<VoucherEntity> findByCode(String code);
}
