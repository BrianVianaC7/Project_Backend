package com.project.modulo4.models.player.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreatePlayerDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String longName;
    @NotBlank
    private long categoryId;
    @NotBlank
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "El formato de la fecha debe ser dd-mm-aaaa")
    private String birthDate;

    @Min(value = 18, message = "Tiene que ser mayor de edad")
    private int age;


    @Min(value = 1, message = "El dorsal tiene que ser mayor a 0")
    private int numberJersey;

    @Min(value = 1, message = "El id no es valido")
    private long nation;
    @Min(value = 1, message = "El id no es valido")
    private long league;
    @Min(value = 1, message = "El id no es valido")
    private long clubTeam;

    @NotBlank(message = "La posición no puede estar en blanco")
    @Pattern(regexp = "^(POR|LD|LI|DFC|MCD|MC|MCO|MD|MI|ED|EI|DC|SD|PUN|SDI)$", message = "La posición no es válida")
    private String position;

    @NotBlank
    private String image;


}
