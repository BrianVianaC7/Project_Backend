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
    @Column(nullable = false,length = 50)
    private String name;
    @Column(nullable = false,length = 50)
    private String lastName;
    @Column(nullable = false,length = 50)
    private String nickName;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryDTO categoryId;
    @Column(nullable = false,length = 50)
    private String birthDate;
    @Column(nullable = false)
    @Range(min = 1,max = 150)
    private int age;
    @Column(nullable = false)
    @Range(min = 0,max = 1000)
    private int numberJersey;
    @ManyToOne
    @JoinColumn(name = "nation_id")
    private NationDTO nationId;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private LeagueDTO leagueId;
    @ManyToOne
    @JoinColumn(name = "club_id")
    private ClubDTO clubTeamId;
    @Column(nullable = false,length = 3)
    private String position;
    @Column(nullable = false)
    @Range(min = 2, max = 3)
    private int trophies;
    @Column(nullable = false)
    private String image;
}
