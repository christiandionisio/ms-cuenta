package com.example.mscuenta.dto;

import lombok.Data;

@Data
public class PersonaDto {

    private Long id;
    private String nombre;
    private String genero;
    private String edad;
    private String identificacion;
    private String direccion;
    private String telefono;
}
