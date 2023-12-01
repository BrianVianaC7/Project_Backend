package com.project.modulo4.models.player.model;


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
@Entity
@Table(name = "players_table")
public class PlayerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 50)
    private String nickName;
    @Column(nullable = false, name = "category_id")
    @Range(min = 1, max = 2)
    private long categoryId;
    @Column(nullable = false, length = 50)
    private String birthDate;
    @Column(nullable = false)
    @Range(min = 1, max = 150)
    private int age;
    @Column(nullable = false)
    @Range(min = 0, max = 1000)
    private int numberJersey;
    @Column(nullable = false, name = "nation_id")
    @Range(min = 1, max = 156)
    private long nationId;
    @Column(nullable = false, name = "league_id")
    @Range(min = 1, max = 20)
    private long leagueId;

    @Column(nullable = false, name = "club_id")
    @Range(min = 1, max = 156)
    private long clubTeamId;
    @Column(nullable = false, length = 3)
    private String position;
    @Column(nullable = false)
    @Range(min = 0)
    private int trophies;
    @Column(nullable = false)
    private String image;
}
