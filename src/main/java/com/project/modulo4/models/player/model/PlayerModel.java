package com.project.modulo4.models.player.model;


import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.nation.model.NationModel;
import com.project.modulo4.utils.types.PositionTypes;
import com.project.modulo4.utils.types.PreferredFootType;
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
    private String longName;

    @Column(nullable = false, length = 50)
    private String nickName;

    @Column(nullable = false, length = 50)
    private String birthDate;

    @ManyToOne
    @MapsId("NationId")
    @JoinColumn(name = "nation_id")
    private NationModel nation;

    @ManyToOne
    @MapsId("clubId")
    @JoinColumn(name = "club_id")
    private ClubModel club;

    @Column(nullable = false)
    @Range(min = 0, max = 1000)
    private int numberJersey;

    @Column(nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private PositionTypes position;

    @Column(nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    private PreferredFootType preferredFoot;

    @Column(nullable = false)
    @Range(min = 0, max = 1000)
    private double height;

    @Column(nullable = false)
    @Range(min = 0, max = 1000)
    private double weight;

    @Column(nullable = false)
    private String image;
}
