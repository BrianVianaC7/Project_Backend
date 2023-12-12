package com.project.modulo4.models.player.dto;

import com.project.modulo4.utils.types.PositionTypes;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class UpdatePlayerDTO {
    private String longName;
    private String nickName;
    private int numberJersey;
    private PositionTypes position;
}
