package com.project.modulo4.models.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdatePlayerDTO {
    private String name;
    private String lastName;
    private String nickName;
    private String gender;
    private int numberJersey;
    private String nation;
    private String league;
    private String clubTeam;
    private String position;
    private int trophies;
}
