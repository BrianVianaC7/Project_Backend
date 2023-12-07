package com.project.modulo4.repository.details;

import com.project.modulo4.models.details.players.PlayerDetailsKey;
import com.project.modulo4.models.details.players.PlayerDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerDetailRepository extends JpaRepository<PlayerDetailsModel, PlayerDetailsKey> {

}