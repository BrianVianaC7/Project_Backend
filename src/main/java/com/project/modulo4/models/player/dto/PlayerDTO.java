package com.project.modulo4.models.player.dto;


import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.nation.model.NationModel;
import com.project.modulo4.utils.types.PositionTypes;
import com.project.modulo4.utils.types.PreferredFootType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.*;

@Data
public class PlayerDTO {
    private long id;
    private String longName;
    private String nickName;
    private String birthDate;
    private NationModel nation;
    private ClubModel club;
    private int numberJersey;
    private PositionTypes position;
    private PreferredFootType preferredFoot;
    private double height;
    private double weight;
    private String image;
}
