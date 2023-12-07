package com.project.modulo4.models.player.dto;


import com.project.modulo4.utils.types.PositionTypes;
import com.project.modulo4.utils.types.PreferredFootType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PlayerDTO {
    private long id;
    private String longName;
    private String nickName;
    private String birthDate;
    private int numberJersey;
    private PositionTypes position;
    private PreferredFootType preferredFoot;
    private double height;
    private double weight;
    private String image;
}
