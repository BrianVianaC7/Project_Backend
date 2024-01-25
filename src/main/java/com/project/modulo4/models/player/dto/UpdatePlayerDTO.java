package com.project.modulo4.models.player.dto;

import com.project.modulo4.utils.types.PositionTypes;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class UpdatePlayerDTO {
    @NotBlank
    private String longName;
    @NotBlank
    private String nickName;
    @Min(value = 1, message = "El dorsal tiene que ser mayor a 0")
    private int numberJersey;
    @NotNull(message = "La posición no puede estar en blanco")
    private PositionTypes position;
}
