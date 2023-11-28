package com.project.modulo4.repository;

import com.project.modulo4.models.model.PlayerModel;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlayerRepository {

    private long currentId;

    private List<PlayerModel> playerModelList;

    public PlayerRepository() {
        currentId = 0;
        playerModelList = new LinkedList<>();
    }

    public List<PlayerModel> getAll(){
        return playerModelList;
    }

    public PlayerModel createPlayer(PlayerModel playerModel) {
        playerModel.setId(++currentId);
        playerModelList.add(playerModel);
        return playerModel;
    }

    public Optional<PlayerModel> getById(long playerId) {
        return playerModelList.stream()
                .filter(player -> player.getId() == playerId)
                .findFirst();
    }

    public void deleteById(long playerId) {
        playerModelList.removeIf(player -> player.getId() == playerId);
    }
    public void updatePlayer(PlayerModel updatedPlayer) {
        for (int i = 0; i < playerModelList.size(); i++) {
            if (playerModelList.get(i).getId() == updatedPlayer.getId()) {
                playerModelList.set(i, updatedPlayer);
                break;
            }
        }
    }


}
