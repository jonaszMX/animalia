package com.mx.animalia.application.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class CiudadanoExistenteModel {
    @NotNull
    @Min(value = 1, message = "El valor deber ser mayor de 0")
    int idCiudadano;
}
