package com.project.modulo4.repository;

import com.project.modulo4.models.league.model.LeagueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LeagueRepository extends JpaRepository<LeagueModel, Long> { }
