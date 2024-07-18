package com.suman.repository;

import com.suman.entity.SumanCRUD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SumanCRUDRepository extends JpaRepository<SumanCRUD, Long> {
}