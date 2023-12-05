package com.project.modulo4.models.player.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@ToString
@Entity
@Table(name = "players_table")
public class PlayerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, length = 50)
    private String LostName;
    @Column(nullable = false, length = 50)
    private String nickName;
    @Column(nullable = false, name = "category_id")
    @Range(min = 1, max = 2)
    private long categoryId;
    @Column(nullable = false, length = 50)
    private String birthDate;
    @Column(nullable = false)
    @Range(min = 0, max = 1000)
    private int numberJersey;
    @Column(nullable = false, name = "nation_id")
    @Range(min = 1, max = 156)
    private long nationId;

    @Column(nullable = false, name = "club_id")
    @Range(min = 1, max = 156)
    private long clubTeamId;
    @Column(nullable = false, length = 3)
    private String position;

    @Column(nullable = false)
    private String image;
}
