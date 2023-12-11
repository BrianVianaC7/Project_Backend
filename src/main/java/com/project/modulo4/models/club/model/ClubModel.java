package com.project.modulo4.models.club.model;


import com.project.modulo4.models.league.model.LeagueModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@ToString
@Entity
@Table(name = "clubs_table")
public class ClubModel {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "club_id", nullable = false, unique = true)
    private long clubId;

    @Column(nullable = false, length = 50)
    private String clubName;

    @Column(nullable = false, length = 5)
    private String clubShortName;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private LeagueModel league;

    @Column(nullable = false, length = 50)
    private String stadium;

    @Column(nullable = false, length = 50)
    private String clubImage;
}
