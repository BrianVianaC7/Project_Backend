package com.project.modulo4.models.player.dto;

import com.project.modulo4.utils.types.PositionTypes;
import com.project.modulo4.utils.types.PreferredFootType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

@Data
public class CreatePlayerDTO {
    @NotBlank
    private String longName;

    @NotBlank
    private String nickName;

    @NotBlank
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "El formato de la fecha debe ser dd/mm/aaaa")
    private String birthDate;

    @Min(value = 1, message = "El dorsal tiene que ser mayor a 0")
    private int numberJersey;

    @NotNull(message = "La posición no puede estar en blanco")
    private PositionTypes position;

    @NotNull(message = "La preferredFoot no puede estar en blanco")
    private PreferredFootType preferredFoot;

    private double height;
    private double weight;

    @NotBlank
    private String image;


}
