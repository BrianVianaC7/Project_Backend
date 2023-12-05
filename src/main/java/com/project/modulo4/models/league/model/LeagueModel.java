package com.project.modulo4.models.league.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@ToString
@Entity
@Table(name = "leagues_table")
public class LeagueModel {

    @Id
    private long leagueId;
    @Column(nullable = false, name = "nation_id")
    @Range(min = 1, max = 20)
    private long nationId;
    @Column(nullable = false, length = 50)
    private String leagueName;
    @Column(nullable = false, name = "category_id")
    @Range(min = 1, max = 20)
    private long categoryId;
    @Column(nullable = false, length = 50)
    private String leagueImage;
}
