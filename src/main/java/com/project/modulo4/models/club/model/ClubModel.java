package com.project.modulo4.models.club.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    @Column(nullable = false, length = 50)
    private String clubName;

    @Column(nullable = false, length = 5)
    private String clubShortName;

    @Column(nullable = false, length = 50)
    private String stadium;

    @Column(nullable = false, length = 50)
    private String clubImage;
}
