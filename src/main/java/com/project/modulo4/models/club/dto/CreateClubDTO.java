package com.project.modulo4.models.club.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateClubDTO {

    @NotBlank(message = "El nombre del club no puede estar en blanco")
    private String clubName;

    @NotBlank(message = "El nombre corto del club no puede estar en blanco")
    private String clubShortName;

    @NotBlank(message = "El nombre del estadio no puede estar en blanco")
    private String stadium;

    @NotBlank(message = "La URL de la imagen del club no puede estar en blanco")
    private String clubImage;

}
