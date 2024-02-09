package com.project.modulo4.models.league.model;


import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.nation.model.NationModel;
import com.project.modulo4.utils.types.CategoryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "leagues_table")
public class LeagueModel {

    @Id
    private long leagueId;

    @ManyToOne
    @JoinColumn(name = "nation_id")
    private NationModel nation;

    @Column(nullable = false, length = 50)
    private String leagueName;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private CategoryType category;

    @Column(nullable = false, length = 50)
    private String leagueImage;

    /*@OneToMany(mappedBy = "league")  // Establece el mapeo inverso
    private List<ClubModel> clubs;*/

}
