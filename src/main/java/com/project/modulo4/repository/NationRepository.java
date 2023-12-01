package com.project.modulo4.repository;

import com.project.modulo4.models.nation.model.NationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public interface NationRepository extends JpaRepository<NationModel, Long> { }
