package com.project.modulo4.nation.repository;

import com.project.modulo4.nation.models.model.NationModel;
import com.project.modulo4.player.models.model.PlayerModel;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class NationRepository {

    private List<NationModel> nationModelList;

    public NationRepository() {
        nationModelList = new LinkedList<>();
    }

    public List<NationModel> getAll(){
        return nationModelList;
    }

    public Optional<NationModel> getById(long nationId) {
        return nationModelList.stream()
                .filter(nation -> nation.getNationId() == nationId)
                .findFirst();
    }


}
