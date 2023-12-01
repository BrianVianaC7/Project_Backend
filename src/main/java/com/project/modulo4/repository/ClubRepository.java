package com.project.modulo4.repository;

import com.project.modulo4.models.club.model.ClubModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<ClubModel, Long> { }
