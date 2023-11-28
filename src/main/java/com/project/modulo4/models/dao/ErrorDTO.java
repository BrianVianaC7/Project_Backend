package com.project.modulo4.models.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {
    private String code;
    private String message;
    private Object details;

}
