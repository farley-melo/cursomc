package com.farleydeftones.cursomc.endPoints.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StandardError {
    private String mensagem;
    private Integer status;
    private Long timestamp;
}
