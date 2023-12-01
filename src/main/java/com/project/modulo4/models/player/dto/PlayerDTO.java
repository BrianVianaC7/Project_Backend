package com.project.modulo4.models.player.dto;


import com.project.modulo4.models.category.dto.CategoryDTO;
import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.nation.dto.NationDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PlayerDTO {
    private long id;
    private String name;
    private String lastName;
    private String nickName;
    private long categoryId;
    private String birthDate;
    private int age;
    private int numberJersey;
    private long nationId;
    private long leagueId;
    private long clubTeamId;
    private String position;
    private int trophies;
    private String image;
}
