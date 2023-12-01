package com.project.modulo4.models.club.model;

import com.project.modulo4.models.category.dto.CategoryDTO;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.nation.dto.NationDTO;
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
@Table(name = "clubs_table")
public class ClubModel {
    @Id
    private long clubId;

    @Column(nullable = false, name = "league_id")
    @Range(min = 1, max = 20)
    private long leagueId;

    @Column(nullable = false, name = "nation_id")
    @Range(min = 1, max = 20)
    private long nationId;
    @Column(nullable = false, name = "category_id")
    @Range(min = 1, max = 20)
    private long categoryId;
    @Column(nullable = false, length = 50)
    private String clubName;
    @Column(nullable = false, length = 5)
    private String clubShortName;
    @Column(nullable = false, length = 50)
    private String stadium;
    @Column(nullable = false, length = 50)
    private String clubImage;
}
