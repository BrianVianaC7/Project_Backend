package com.project.modulo4.models.player.dto;


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
    private String LongName;
    private String nickName;
    private long categoryId;
    private String birthDate;
    private int numberJersey;
    private long nationId;
    private String clubTeamId;
    private String position;
    private String preferredFoot;
    private double height;
    private double weight;
    private String image;
}
