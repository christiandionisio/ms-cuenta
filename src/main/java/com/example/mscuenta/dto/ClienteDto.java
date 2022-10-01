package com.example.mscuenta.dto;

import lombok.Data;

@Data
public class ClienteDto extends PersonaDto {

    private String password;
    private Boolean estado;
}
