package com.project.modulo4.player.models.dto;


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
    private String name;
    private String lastName;
    private String nickName;
    private String gender;
    private String birthDate;
    private int age;
    private int numberJersey;
    private String nation;
    private String league;
    private String clubTeam;
    private String position;
    private int trophies;
    private String image;
}
