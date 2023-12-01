package com.project.modulo4.models.nation.model;

import com.project.modulo4.models.league.dto.LeagueDTO;
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
@Table(name = "nations_table")
public class NationModel {
    @Id
    private long nationId;
    @Column(nullable = false, name = "league_id")
    @Range(min = 1, max = 20)
    private long leagueId;
    @Column(nullable = false, length = 50)
    private String nationName;
    @Column(nullable = false, length = 5)
    private String shortName;
    @Column(nullable = false, length = 50)
    private String nationImage;
}
