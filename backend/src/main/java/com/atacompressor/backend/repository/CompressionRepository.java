package com.atacompressor.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atacompressor.backend.entity.CompressionRecord;

@Repository
public interface CompressionRepository extends JpaRepository<CompressionRecord, Long> {

}
